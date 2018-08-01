package io.renren.modules.word.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.word.dao.WorkerDao;
import io.renren.modules.word.entity.WorkerEntity;
import io.renren.modules.word.service.WorkerService;


@Service("workerService")
public class WorkerServiceImpl extends ServiceImpl<WorkerDao, WorkerEntity> implements WorkerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WorkerEntity> page = this.selectPage(
                new Query<WorkerEntity>(params).getPage(),
                new EntityWrapper<WorkerEntity>()
        );

        return new PageUtils(page);
    }

}
