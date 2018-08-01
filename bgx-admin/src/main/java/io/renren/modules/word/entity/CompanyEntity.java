package io.renren.modules.word.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-24 11:24:20
 */
@TableName("tb_company")
public class CompanyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 发包方Id
     */
    @TableId
    private Long cId;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 企业认证授权书
     */
    private String authorization;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 营业执照
     */
    private String bizlicense;
    /**
     * 身份证地址
     */
    private String cardAddress;
    /**
     * 发包方类型 （1：个人 、2：企业（工程))
     */
    private Integer companyType;
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
     * 登录时间
     */
    private Date loginTime;
    /**
     * 名称
     */
    private String name;
    /**
     * 开户许可证
     */
    private String openingPermit;
    /**
     * 组织机构代码
     */
    private String orgcode;
    /**
     * 角色完善状态（0：注册未完善 1：完善）
     */
    private Integer perfectStatus;
    /**
     * 所属地区
     */
    private String region;
    /**
     * 税务登记证
     */
    private String registration;
    /**
     * 备注
     */
    private String remark;
    /**
     * 性别
     */
    private String sex;
    /**
     * 缩略名称
     */
    private String shortName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 法人名称
     */
    private String tdutyName;
    /**
     * 座机号码
     */
    private String tel;
    /**
     * 类型 （1:发包方(用于被预约的时候用))
     */
    private Integer type;


    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
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

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBizlicense() {
        return bizlicense;
    }

    public void setBizlicense(String bizlicense) {
        this.bizlicense = bizlicense;
    }

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpeningPermit() {
        return openingPermit;
    }

    public void setOpeningPermit(String openingPermit) {
        this.openingPermit = openingPermit;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public Integer getPerfectStatus() {
        return perfectStatus;
    }

    public void setPerfectStatus(Integer perfectStatus) {
        this.perfectStatus = perfectStatus;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTdutyName() {
        return tdutyName;
    }

    public void setTdutyName(String tdutyName) {
        this.tdutyName = tdutyName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "cId=" + cId +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", authorization='" + authorization + '\'' +
                ", birthday='" + birthday + '\'' +
                ", bizlicense='" + bizlicense + '\'' +
                ", cardAddress='" + cardAddress + '\'' +
                ", companyType=" + companyType +
                ", createTime=" + createTime +
                ", creditRating='" + creditRating + '\'' +
                ", creditScore=" + creditScore +
                ", dutyName='" + dutyName + '\'' +
                ", dutyPhone='" + dutyPhone + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", iCode='" + iCode + '\'' +
                ", idCard='" + idCard + '\'' +
                ", loginTime=" + loginTime +
                ", name='" + name + '\'' +
                ", openingPermit='" + openingPermit + '\'' +
                ", orgcode='" + orgcode + '\'' +
                ", perfectStatus=" + perfectStatus +
                ", region='" + region + '\'' +
                ", registration='" + registration + '\'' +
                ", remark='" + remark + '\'' +
                ", sex='" + sex + '\'' +
                ", shortName='" + shortName + '\'' +
                ", status=" + status +
                ", tdutyName='" + tdutyName + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                '}';
    }
}
