package io.renren.modules.word.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 劳务信息
 * 
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-19 11:22:16
 */
@TableName("tb_worker")
public class WorkerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 包工侠、劳务id 
	 */
	@TableId
	private Long wId;
	/**
	 * 详细地址 
	 */
	private String address;
	/**
	 * 年龄 
	 */
	private Integer age;
	/**
	 * 出生日期 
	 */
	private String birthday;
	/**
	 * 身份证地址 
	 */
	private String cardAddress;
	/**
	 * 资质证书 
	 */
	private String certificate;
	/**
	 * 劳务所属公司 
	 */
	private String company;
	/**
	 * 施工工种 
	 */
	private String consType;
	/**
	 * 创建时间 
	 */
	private Date createTime;
	/**
	 * 信用等级 
	 */
	private String creditRating;
	/**
	 * 信用积分 
	 */
	private Integer creditScore;
	/**
	 * 联系人姓名 
	 */
	private String dutyName;
	/**
	 * 联系人电话 
	 */
	private String dutyPhone;
	/**
	 * 头像 
	 */
	private String headPortrait;
	/**
	 * 邀请码 
	 */
	private String iCode;
	/**
	 * 身份证号 
	 */
	private String idCard;
	/**
	 * 工程相册 
	 */
	private String imgs;
	/**
	 * 自我介绍 
	 */
	private String introduction;
	/**
	 * 登录时间 
	 */
	private Date loginTime;
	/**
	 * 最高薪资 
	 */
	private Double maximum;
	/**
	 * 最低薪资 
	 */
	private Double minimum;
	/**
	 * 名称 
	 */
	private String name;
	/**
	 * 所属职位 
	 */
	private String position;
	/**
	 * 所属地区 
	 */
	private String region;
	/**
	 * 备注 
	 */
	private String remark;
	/**
	 * 性别 
	 */
	private String sex;
	/**
	 * 状态 
	 */
	private Integer status;
	/**
	 * 技术类型 
	 */
	private String technicalType;
	/**
	 * 类型 （1：包工侠 、2：劳务） 
	 */
	private Integer type;
	/**
	 * 可工作地 
	 */
	private String workAddress;
	/**
	 * 从业年限 
	 */
	private String workTime;


	public Long getwId() {
		return wId;
	}

	public void setwId(Long wId) {
		this.wId = wId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCardAddress() {
		return cardAddress;
	}

	public void setCardAddress(String cardAddress) {
		this.cardAddress = cardAddress;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getConsType() {
		return consType;
	}

	public void setConsType(String consType) {
		this.consType = consType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getDutyPhone() {
		return dutyPhone;
	}

	public void setDutyPhone(String dutyPhone) {
		this.dutyPhone = dutyPhone;
	}


	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getiCode() {
		return iCode;
	}

	public void setiCode(String iCode) {
		this.iCode = iCode;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Double getMaximum() {
		return maximum;
	}

	public void setMaximum(Double maximum) {
		this.maximum = maximum;
	}

	public Double getMinimum() {
		return minimum;
	}

	public void setMinimum(Double minimum) {
		this.minimum = minimum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTechnicalType() {
		return technicalType;
	}

	public void setTechnicalType(String technicalType) {
		this.technicalType = technicalType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
}
