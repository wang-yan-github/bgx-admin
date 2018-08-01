package io.renren.modules.word.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 审核记录
 * 
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-18 17:04:45
 */
@TableName("tb_auditor")
public class AuditorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long aId;
	/**
	 * 审核人内容 
	 */
	private String auditingContent;
	/**
	 * 审核人 
	 */
	private String auditingName;
	/**
	 * 审核时间 
	 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date auditingTime;
	/**
	 * 
	 */
	private Long infoId;
	/**
	 * 所属类型(1.发包方 2.发包方项目 3.劳务 4 劳务项目)
	 */
	private Integer type;

    public AuditorEntity(Long aId, String auditingContent, String auditingName, Date auditingTime, Long infoId, Integer type) {
        this.aId = aId;
        this.auditingContent = auditingContent;
        this.auditingName = auditingName;
        this.auditingTime = auditingTime;
        this.infoId = infoId;
        this.type = type;
    }

    public AuditorEntity(String auditingContent, String auditingName, Date auditingTime, Long infoId, Integer type) {
        this.auditingContent = auditingContent;
        this.auditingName = auditingName;
        this.auditingTime = auditingTime;
        this.infoId = infoId;
        this.type = type;
    }

    public AuditorEntity() {
    }

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public String getAuditingContent() {
        return auditingContent;
    }

    public void setAuditingContent(String auditingContent) {
        this.auditingContent = auditingContent;
    }

    public String getAuditingName() {
        return auditingName;
    }

    public void setAuditingName(String auditingName) {
        this.auditingName = auditingName;
    }

    public Date getAuditingTime() {
        return auditingTime;
    }

    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
