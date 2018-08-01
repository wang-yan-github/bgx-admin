package io.renren.modules.word.controller;

import io.renren.common.utils.R;
import io.renren.modules.word.entity.CompanyEntity;
import io.renren.modules.word.service.AuditorService;
import io.renren.modules.word.service.CompanyService;
import io.renren.modules.word.util.Constant;
import io.renren.modules.word.validator.AuditParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发包方 审核
 *
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-23 11:11:36
 */
@RestController
@RequestMapping("word/auditCompany")
public class AuditCompanyController extends AbstractAuditController<CompanyEntity> {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private AuditorService auditorService;

    public AuditCompanyController() {
        super.idMethod = "getcId";
        super.statusColumn = "status";
        super.statusGetMethod = "getStatus";
        super.statusSetMethod = "setStatus";
    }

    /**
     * 全部信息审核 通过 | 不通过
     */
    @RequestMapping("/updateByInfoStatus")
    public R updateByInfoStatus(@RequestBody AuditParams<CompanyEntity> auditParams) {
        isAudit(auditParams, Constant.INFO_COMPANY_UPDATE, Constant.INFO_COMPANY_SUCCESS, Constant.INFO_COMPANY_FAILURE, Constant.LOG_INFO_COMPANY, companyService, auditorService);

        return R.ok();
    }

    /**
     * 初始化信息审核状态
     */
    @RequestMapping("/updateByInfoStatusDefault")
    public R updateByInfoStatusDefault() {
        statusDefault(Constant.INFO_COMPANY_UPDATE, companyService);

        return R.ok();
    }

    /**
     * 全部合同审核 通过 | 不通过
     */
    @RequestMapping("/updateByPactStatus")
    public R updateByPactStatus(@RequestBody AuditParams<CompanyEntity> auditParams) {
        isAudit(auditParams, Constant.PACT_COMPANY_UPDATE, Constant.PACT_COMPANY_SUCCESS, Constant.PACT_COMPANY_FAILURE, Constant.LOG_PACT_COMPANY, companyService, auditorService);

        return R.ok();
    }


    /**
     * 初始化审核状态
     */
    @RequestMapping("/updateByPactStatusDefault")
    public R updateByPactStatusDefault() {
        statusDefault(Constant.PACT_COMPANY_UPDATE, companyService);

        return R.ok();
    }


}
