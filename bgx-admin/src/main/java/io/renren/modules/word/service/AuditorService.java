package io.renren.modules.word.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.word.entity.AuditorEntity;

import java.util.Map;

/**
 * 审核记录
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-18 17:04:45
 */
public interface AuditorService extends IService<AuditorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

