package io.renren.modules.word.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.word.dao.AuditorDao;
import io.renren.modules.word.entity.AuditorEntity;
import io.renren.modules.word.service.AuditorService;


@Service("auditorService")
public class AuditorServiceImpl extends ServiceImpl<AuditorDao, AuditorEntity> implements AuditorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AuditorEntity> page = this.selectPage(
                new Query<AuditorEntity>(params).getPage(),
                new EntityWrapper<AuditorEntity>()
        );

        return new PageUtils(page);
    }

}
