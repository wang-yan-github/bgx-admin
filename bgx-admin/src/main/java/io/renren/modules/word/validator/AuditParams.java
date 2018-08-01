package io.renren.modules.word.validator;

import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.word.entity.AuditorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 审核参数
 *
 * @author wangyan
 * @param <T> 实体
 */
@Setter
@Getter
public class AuditParams<T> extends AbstractController {

    /**
     * 临时数据
     */
    List<T> temp;
    /**
     * 源头 更新数据
     */
    List<T> updateSource;
    /**
     * 目标 更新数据
     */
    List<T> updateTarget;
    /**
     * 审核记录
     */
    List<AuditorEntity> auditorEntityList;
    /**
     * 审核人
     */
    String userName;
    /**
     * 审核ids
     */
    String ids;
    /**
     * 审核状态
     */
    Integer status;
    /**
     * 审核内容
     */
    String content;

    public AuditParams() {
        this.temp = new ArrayList<>();
        this.updateSource = new ArrayList<>();
        this.updateTarget = new ArrayList<>();
        this.auditorEntityList = new ArrayList<>();
        this.userName = getUser().getUsername();
    }


}
