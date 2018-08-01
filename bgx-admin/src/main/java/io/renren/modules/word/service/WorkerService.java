package io.renren.modules.word.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.word.entity.WorkerEntity;

import java.util.Map;

/**
 * 劳务信息
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-19 11:22:16
 */
public interface WorkerService extends IService<WorkerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

