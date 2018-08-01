package io.renren.modules.word.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.word.entity.ProjectEntity;

import java.util.Map;

/**
 * 发包项目
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-18 10:52:01
 */
public interface ProjectService extends IService<ProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

