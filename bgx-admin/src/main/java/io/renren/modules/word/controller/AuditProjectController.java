package io.renren.modules.word.controller;

import io.renren.common.utils.R;
import io.renren.modules.word.entity.ProjectEntity;
import io.renren.modules.word.service.AuditorService;
import io.renren.modules.word.service.ProjectService;
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
@RequestMapping("word/auditProject")
public class AuditProjectController extends AbstractAuditController<ProjectEntity> {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private AuditorService auditorService;

    public AuditProjectController() {
        super.idMethod = "getpId";
        super.statusColumn = "p_status";
        super.statusGetMethod = "getpStatus";
        super.statusSetMethod = "setpStatus";
    }

    /**
     * 全部信息审核 通过 | 不通过
     */
    @RequestMapping("/updateByInfoStatus")
    public R updateByInfoStatus(@RequestBody AuditParams<ProjectEntity> auditParams) {
        isAudit(auditParams, Constant.INFO_COMPANY_PROJECT_UPDATE, Constant.INFO_COMPANY_PROJECT_SUCCESS, Constant.INFO_COMPANY_PROJECT_FAILURE, Constant.LOG_INFO_COMPANY_PROJECT, projectService, auditorService);

        return R.ok();
    }

    /**
     * 初始化信息审核状态
     */
    @RequestMapping("/updateByInfoStatusDefault")
    public R updateByInfoStatusDefault() {
        statusDefault(Constant.INFO_COMPANY_PROJECT_UPDATE, projectService);

        return R.ok();
    }

    /**
     * 全部完工审核 通过 | 不通过
     */
    @RequestMapping("/updateByOverStatus")
    public R updateByOverStatus(@RequestBody AuditParams<ProjectEntity> auditParams) {
        isAudit(auditParams, Constant.OVER_COMPANY_UPDATE, Constant.OVER_COMPANY_SUCCESS, Constant.OVER_COMPANY_FAILURE, Constant.LOG_OVER_COMPANY, projectService, auditorService);

        return R.ok();
    }


    /**
     * 初始化审核状态
     */
    @RequestMapping("/updateByOverStatusDefault")
    public R updateByOverStatusDefault() {
        statusDefault(Constant.OVER_COMPANY_UPDATE, projectService);

        return R.ok();
    }


}
