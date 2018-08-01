package io.renren.modules.word.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.word.entity.WorkerProjectEntity;

import java.util.Map;

/**
 * 
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-25 18:07:56
 */
public interface WorkerProjectService extends IService<WorkerProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

