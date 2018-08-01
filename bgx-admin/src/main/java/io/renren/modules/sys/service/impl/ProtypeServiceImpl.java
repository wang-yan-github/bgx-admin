package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ProtypeDao;
import io.renren.modules.sys.entity.ProtypeEntity;
import io.renren.modules.sys.service.ProtypeService;


@Service("protypeService")
public class ProtypeServiceImpl extends ServiceImpl<ProtypeDao, ProtypeEntity> implements ProtypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProtypeEntity> page = this.selectPage(
                new Query<ProtypeEntity>(params).getPage(),
                new EntityWrapper<ProtypeEntity>()
        );

        return new PageUtils(page);
    }

}
