package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.MessageEntity;

import java.util.Map;

/**
 * 
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-11 10:40:49
 */
public interface MessageService extends IService<MessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

