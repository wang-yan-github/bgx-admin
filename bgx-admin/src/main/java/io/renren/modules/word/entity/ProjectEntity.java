package io.renren.modules.word.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 发包项目
 * 
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-18 10:52:01
 */
@TableName("tb_project")
public class ProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 发包方项目id 
	 */
	@TableId
	private Long pId;
	/**
	 * 发包方id 
	 */
	private Long cId;
	/**
	 * 项目结束时间 
	 */
	private Date endTime;
	/**
	 * 项目地址 
	 */
	private String pAddresss;
	/**
	 * 栏标价 
	 */
	private Double pColumnPrice;
	/**
	 * 合同url 
	 */
	private String pContract;
	/**
	 * 分包单位 
	 */
	private String pContractCom;
	/**
	 * 推包工侠（1是，0否） 
	 */
	private Integer pIsPushLabor;
	/**
	 * 推项目(1是，0否) 
	 */
	private Integer pIsPushProject;
	/**
	 * 发包方项目名称 
	 */
	private String pName;
	/**
	 * 施工人数 
	 */
	private Integer pNum;
	/**
	 * 项目编号 
	 */
	private String pNumber;
	/**
	 * 备注 
	 */
	private String pRemark;
	/**
	 * 项目规模 
	 */
	private String pScale;
	/**
	 * 项目状态 
	 */
	private Integer pStatus;
	/**
	 * 工程类型 
	 */
	private Integer type;
	/**
	 * 发包方项目类型（1：个人 、2：发包方（工程））
	 */
	private Integer projectType;
	/**
	 * 地区编码 
	 */
	private String region;
	/**
	 * 项目开始时间 
	 */
	private Date startTime;


	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getpAddresss() {
		return pAddresss;
	}

	public void setpAddresss(String pAddresss) {
		this.pAddresss = pAddresss;
	}

	public Double getpColumnPrice() {
		return pColumnPrice;
	}

	public void setpColumnPrice(Double pColumnPrice) {
		this.pColumnPrice = pColumnPrice;
	}

	public String getpContract() {
		return pContract;
	}

	public void setpContract(String pContract) {
		this.pContract = pContract;
	}

	public String getpContractCom() {
		return pContractCom;
	}

	public void setpContractCom(String pContractCom) {
		this.pContractCom = pContractCom;
	}

	public Integer getpIsPushLabor() {
		return pIsPushLabor;
	}

	public void setpIsPushLabor(Integer pIsPushLabor) {
		this.pIsPushLabor = pIsPushLabor;
	}

	public Integer getpIsPushProject() {
		return pIsPushProject;
	}

	public void setpIsPushProject(Integer pIsPushProject) {
		this.pIsPushProject = pIsPushProject;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getpNum() {
		return pNum;
	}

	public void setpNum(Integer pNum) {
		this.pNum = pNum;
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getpScale() {
		return pScale;
	}

	public void setpScale(String pScale) {
		this.pScale = pScale;
	}

	public Integer getpStatus() {
		return pStatus;
	}

	public void setpStatus(Integer pStatus) {
		this.pStatus = pStatus;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
}
