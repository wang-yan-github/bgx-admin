package io.renren.modules.word.util;

/**
 * 常量
 * @author wangyan
 */
public class Constant {

    /** 成功 */
    public static final int SUCCESS = 1;
    /** 成功 */
    public static final int FAILURE = 0;

    /** 企业 信息日志类型 */
    public static final int LOG_INFO_COMPANY = 1;
    /** 企业 信息待审核 */
    public static final int INFO_COMPANY_UPDATE = 101;
    /** 企业 信息审核通过 */
    public static final int INFO_COMPANY_SUCCESS = 102;
    /** 企业 信息审核不通过 */
    public static final int INFO_COMPANY_FAILURE = 103;

    /** 劳务 信息日志类型 */
    public static final int LOG_INFO_WORKER = 2;
    /** 劳务 信息待审核 */
    public static final int INFO_WORKER_UPDATE = 101;
    /** 劳务 信息审核通过 */
    public static final int INFO_WORKER_SUCCESS = 102;
    /** 劳务 信息审核不通过 */
    public static final int INFO_WORKER_FAILURE = 103;

    /** 企业项目 信息日志类型 */
    public static final int LOG_INFO_COMPANY_PROJECT = 3;
    /** 企业项目 信息待审核 */
    public static final int INFO_COMPANY_PROJECT_UPDATE = 202;
    /** 企业项目 信息审核通过 */
    public static final int INFO_COMPANY_PROJECT_SUCCESS = 203;
    /** 企业项目 信息审核不通过 */
    public static final int INFO_COMPANY_PROJECT_FAILURE = 204;

    /** 劳务项目 信息日志类型 */
    public static final int LOG_INFO_WORKER_PROJECT = 4;
    /** 劳务项目 信息待审核 */
    public static final int INFO_WORKER_PROJECT_UPDATE = 202;
    /** 劳务项目 信息审核通过 */
    public static final int INFO_WORKER_PROJECT_SUCCESS = 203;
    /** 劳务项目 信息审核不通过 */
    public static final int INFO_WORKER_PROJECT_FAILURE = 204;

    /** 企业合同 信息日志类型 */
    public static final int LOG_PACT_COMPANY = 5;
    /** 企业合同 待审核 */
    public static final int PACT_COMPANY_UPDATE = 314;
    /** 企业合同 审核通过 */
    public static final int PACT_COMPANY_SUCCESS = 316;
    /** 企业合同 审核不通过 */
    public static final int PACT_COMPANY_FAILURE = 315;

    /** 劳务合同 信息日志类型*/
    public static final int LOG_PACT_WORKER = 6;
    /** 劳务合同 待审核 */
    public static final int PACT_WORKER_UPDATE = 314;
    /** 劳务合同 审核通过 */
    public static final int PACT_WORKER_SUCCESS = 316;
    /** 劳务合同 审核不通过 */
    public static final int PACT_WORKER_FAILURE = 315;

    /** 企业完工 信息日志类型*/
    public static final int LOG_OVER_COMPANY = 7;
    /** 企业完工 待审核 */
    public static final int OVER_COMPANY_UPDATE = 318;
    /** 企业完工 审核通过 */
    public static final int OVER_COMPANY_SUCCESS = 319;
    /** 企业完工 审核不通过 */
    public static final int OVER_COMPANY_FAILURE = 317;

    /** 劳务完工 信息日志类型*/
    public static final int LOG_OVER_WORKER = 8;
    /** 劳务完工 待审核 */
    public static final int OVER_WORKER_UPDATE = 318;
    /** 劳务完工 审核通过 */
    public static final int OVER_WORKER_SUCCESS = 319;
    /** 劳务完工 审核不通过 */
    public static final int OVER_WORKER_FAILURE = 317;
}
