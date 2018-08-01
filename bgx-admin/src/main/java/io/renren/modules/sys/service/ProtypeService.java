package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.ProtypeEntity;

import java.util.Map;

/**
 * 项目类型
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-13 10:48:42
 */
public interface ProtypeService extends IService<ProtypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

