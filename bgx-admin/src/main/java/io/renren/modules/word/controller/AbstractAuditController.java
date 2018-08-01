package io.renren.modules.word.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import io.renren.modules.word.entity.AuditorEntity;
import io.renren.modules.word.util.Constant;
import io.renren.modules.word.validator.AuditParams;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller 审核公共组件
 *
 * @author wangyan
 */
public abstract class AbstractAuditController<T> {


    /**
     * 实体类getId方法
     */
    protected String idMethod;
    /**
     * 数据库状态字段名
     */
    protected String statusColumn;
    /**
     * 实体类get状态方法
     */
    protected String statusGetMethod;
    /**
     * 实体类set状态方法
     */
    protected String statusSetMethod;

    /**
     * 判断是否审核
     *
     * @param auditParams 审核信息
     * @param success     成功码
     * @param failure     失败码
     */
    void isAudit(AuditParams<T> auditParams, int update, int success, int failure, int type, IService auditService, IService auditorService) {
        // 审核
        if (auditParams.getIds() != null && !auditParams.getIds().equals("")) {
            // 需要更新数据
            auditParams.setTemp(auditService.selectBatchIds(Arrays.asList(auditParams.getIds().split(","))));
            auditParams.setUpdateSource((List<T>) auditParams.getTemp().stream().filter(t -> {
                Method m;
                boolean temp = false;
                try {
                    m = t.getClass().getDeclaredMethod(statusGetMethod);
                    m.setAccessible(true);
                    temp = Integer.parseInt(m.invoke(t).toString()) == update;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return temp;
            }).collect(Collectors.toList()));

            successOrFailure(auditParams, success, failure, type);
        } else {
            // 需要更新数据
            auditParams.setUpdateSource(auditService.selectList(
                    new EntityWrapper<T>().eq(statusColumn, String.valueOf(update))
            ));

            successOrFailure(auditParams, success, failure, type);
        }

        // 避免空值 IllegalArgumentException
        if (auditParams.getUpdateTarget() != null && auditParams.getUpdateTarget().size() > 0) {
            //全部更新
            auditService.updateAllColumnBatchById(auditParams.getUpdateTarget());

        }
        // 避免空值 IllegalArgumentException
        if (auditParams.getAuditorEntityList() != null && auditParams.getAuditorEntityList().size() > 0) {
            //全部更新
            auditorService.insertBatch(auditParams.getAuditorEntityList());
        }
    }

    private void successOrFailure(AuditParams<T> auditParams, int success, int failure, int type) {
        switch (auditParams.getStatus()) {
            // 审核通过
            case Constant.SUCCESS:
                audit(auditParams, success, type);
                break;
            // 审核不通过
            case Constant.FAILURE:
                audit(auditParams, failure, type);
                break;
            default:
        }
    }

    private void audit(AuditParams<T> auditParams, int status, int type) {
        try {
            for (T entity : auditParams.getUpdateSource()) {
                //获取赋值状态方法
                Method m = entity.getClass().getDeclaredMethod(statusSetMethod, Integer.class);
                //暴力访问(忽略掉访问修饰符)
                m.setAccessible(true);
                m.invoke(entity, status);
                m = entity.getClass().getDeclaredMethod(idMethod);
                Long infoId = Long.valueOf(m.invoke(entity).toString());
                auditParams.getAuditorEntityList().add(new AuditorEntity(auditParams.getContent(), auditParams.getUserName(), new Date(), infoId, type));
                auditParams.getUpdateTarget().add(entity);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    /**
     * 默认初始化待审核
     *
     * @param update       待审核状态
     * @param auditService 服务对象
     */
    protected void statusDefault(int update, IService auditService) {
        List<T> updateSource = auditService.selectList(new EntityWrapper<T>().where(statusColumn + " != " + update));
        // 更新数据
        updateSource.forEach(t -> {
            try {
                Method m =t.getClass().getDeclaredMethod(statusSetMethod,Integer.class);
                m.setAccessible(true);
                m.invoke(t,update);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        // 避免空值 IllegalArgumentException
        if (updateSource.size() > 0) {
            //全部更新
            auditService.updateAllColumnBatchById(updateSource);
        }
    }


}
