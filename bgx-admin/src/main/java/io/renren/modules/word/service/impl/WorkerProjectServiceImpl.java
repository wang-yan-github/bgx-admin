package io.renren.modules.word.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.word.dao.WorkerProjectDao;
import io.renren.modules.word.entity.WorkerProjectEntity;
import io.renren.modules.word.service.WorkerProjectService;


@Service("workerProjectService")
public class WorkerProjectServiceImpl extends ServiceImpl<WorkerProjectDao, WorkerProjectEntity> implements WorkerProjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WorkerProjectEntity> page = this.selectPage(
                new Query<WorkerProjectEntity>(params).getPage(),
                new EntityWrapper<WorkerProjectEntity>()
        );

        return new PageUtils(page);
    }

}
