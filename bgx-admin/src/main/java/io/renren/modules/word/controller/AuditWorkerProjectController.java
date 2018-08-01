package io.renren.modules.word.controller;

import io.renren.common.utils.R;
import io.renren.modules.word.entity.ProjectEntity;
import io.renren.modules.word.entity.WorkerProjectEntity;
import io.renren.modules.word.service.AuditorService;
import io.renren.modules.word.service.ProjectService;
import io.renren.modules.word.service.WorkerProjectService;
import io.renren.modules.word.util.Constant;
import io.renren.modules.word.validator.AuditParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目 审核
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-23 11:11:36
 */
@RestController
@RequestMapping("word/auditWorkerProject")
public class AuditWorkerProjectController extends AbstractAuditController<WorkerProjectEntity> {

    @Autowired
    private WorkerProjectService workerProjectService;
    @Autowired
    private AuditorService auditorService;

    public AuditWorkerProjectController() {
        super.idMethod = "getwPId";
        super.statusColumn = "w_status";
        super.statusGetMethod = "getwStatus";
        super.statusSetMethod = "setwStatus";
    }

    /**
     * 全部信息审核 通过 | 不通过
     */
    @RequestMapping("/updateByInfoStatus")
    public R updateByInfoStatus(@RequestBody AuditParams<WorkerProjectEntity> auditParams) {
        isAudit(auditParams, Constant.INFO_WORKER_PROJECT_UPDATE, Constant.INFO_WORKER_PROJECT_SUCCESS, Constant.INFO_WORKER_PROJECT_FAILURE, Constant.LOG_INFO_WORKER_PROJECT, workerProjectService, auditorService);

        return R.ok();
    }

    /**
     * 初始化信息审核状态
     */
    @RequestMapping("/updateByInfoStatusDefault")
    public R updateByInfoStatusDefault() {
        statusDefault(Constant.INFO_WORKER_PROJECT_UPDATE, workerProjectService);

        return R.ok();
    }

    /**
     * 全部完工审核 通过 | 不通过
     */
    @RequestMapping("/updateByOverStatus")
    public R updateByOverStatus(@RequestBody AuditParams<WorkerProjectEntity> auditParams) {
        isAudit(auditParams, Constant.OVER_WORKER_UPDATE, Constant.OVER_WORKER_SUCCESS, Constant.OVER_WORKER_FAILURE, Constant.LOG_OVER_WORKER, workerProjectService, auditorService);

        return R.ok();
    }


    /**
     * 初始化审核状态
     */
    @RequestMapping("/updateByOverStatusDefault")
    public R updateByOverStatusDefault() {
        statusDefault(Constant.OVER_WORKER_UPDATE, workerProjectService);

        return R.ok();
    }


}
