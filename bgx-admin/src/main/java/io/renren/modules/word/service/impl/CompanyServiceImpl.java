package io.renren.modules.word.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.word.dao.CompanyDao;
import io.renren.modules.word.entity.CompanyEntity;
import io.renren.modules.word.service.CompanyService;


@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CompanyEntity> page = this.selectPage(
                new Query<CompanyEntity>(params).getPage(),
                new EntityWrapper<CompanyEntity>()
        );

        return new PageUtils(page);
    }

}
