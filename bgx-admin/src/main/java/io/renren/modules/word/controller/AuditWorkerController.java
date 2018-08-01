package io.renren.modules.word.controller;

import io.renren.common.utils.R;
import io.renren.modules.word.entity.WorkerEntity;
import io.renren.modules.word.service.AuditorService;
import io.renren.modules.word.service.WorkerService;
import io.renren.modules.word.util.Constant;
import io.renren.modules.word.validator.AuditParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 劳务 审核
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-23 11:11:36
 */
@RestController
@RequestMapping("word/auditWorker")
public class AuditWorkerController extends AbstractAuditController<WorkerEntity> {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private AuditorService auditorService;

    public AuditWorkerController() {
        super.idMethod = "getwId";
        super.statusColumn = "status";
        super.statusGetMethod = "getStatus";
        super.statusSetMethod = "setStatus";
    }

    /**
     * 全部信息审核 通过 | 不通过
     */
    @RequestMapping("/updateByInfoStatus")
    public R updateByInfoStatus(@RequestBody AuditParams<WorkerEntity> auditParams) {
        isAudit(auditParams, Constant.INFO_WORKER_UPDATE, Constant.INFO_WORKER_SUCCESS, Constant.INFO_WORKER_FAILURE, Constant.LOG_INFO_WORKER, workerService, auditorService);

        return R.ok();
    }

    /**
     * 初始化信息审核状态
     */
    @RequestMapping("/updateByInfoStatusDefault")
    public R updateByInfoStatusDefault() {
        statusDefault(Constant.INFO_WORKER_UPDATE, workerService);

        return R.ok();
    }

    /**
     * 全部合同审核 通过 | 不通过
     */
    @RequestMapping("/updateByPactStatus")
    public R updateByPactStatus(@RequestBody AuditParams<WorkerEntity> auditParams) {
        isAudit(auditParams, Constant.PACT_WORKER_UPDATE, Constant.PACT_WORKER_SUCCESS, Constant.PACT_WORKER_FAILURE, Constant.LOG_PACT_WORKER, workerService, auditorService);

        return R.ok();
    }


    /**
     * 初始化审核状态
     */
    @RequestMapping("/updateByPactStatusDefault")
    public R updateByPactStatusDefault() {
        statusDefault(Constant.PACT_WORKER_UPDATE, workerService);

        return R.ok();
    }


}
