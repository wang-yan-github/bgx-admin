package io.renren.modules.word.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.word.entity.CompanyEntity;

import java.util.Map;

/**
 * 
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-24 11:24:20
 */
public interface CompanyService extends IService<CompanyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

