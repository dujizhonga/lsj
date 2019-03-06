package com.yrsoft.tripartite.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 会员管理-会员表 m_member
 *
 * @author mz
 * @date 2019-02-23
 */
public class MMember
{
private static final long serialVersionUID = 1L;

/** 编号 */
private String id;
/** 手机号 */
private String telephone;
/** 0:男 1：女 */
private Integer sex;
/** 出生日期 */
private String birthday;
/** qq登录 */
private String qq;
/** qq身份识别码 */
private String qqId;
/** 微信登录 */
private String wechat;
/** 微信身份识别码 */
private String wxId;
/** 昵称 */
private String nickname;
/** 移动端版本 */
private String appVersion;
/** 锁定标志(0：未锁定，1：已锁定) */
private Integer lockFlag;
/** 用户管理密码(即提现密码和解卡密码) */
private String withdrawalPassword;
/** 登录密码 */
private String password;
/** 邮箱 */
private String email;
/** 注册时间 */
private Integer registerTime;
/** 最后一次登录时间 */
private Integer lastLoginTime;
/** 邀请码 */
private String inviteCode;
/** 0 安卓 1:IOS */
private Integer loginTelType;
/** 最后一次登录ip */
private String lastLoginIp;
/** 头像地址 */
private String headImg;
/** 注册类型(0：货主端，1：车主端) */
private Integer registerType;
/** 油卡余额 */
private Long oilsBalance;
/** 油卡充值总金额 */
private Long oilsRechargeBalance;
/** 气卡余额 */
private Long gasBalance;
/** etc 余额 */
private Long etcBalance;
/** 垫支额度 */
private Long settleQuota;
/** 垫支余额 */
private Long settleBalance;
/** 冻结金额 */
private Long freezingAmount;
/** 已使用金额 */
private Long amountUsed;
/** 已提现金额 */
private Long presentAmount;
/** 充值总金额(通过微信，支付宝充入的金额，不包含退款和结算金额) */
private Long totalRecharge;
/** 垫资总金额 */
private Long totalLoaning;
/** 垫支总金额 */
private Long totalSettle;
/** 充值余额 */
private Long rechargeBalance;
/** 垫资余额 */
private Long loaningBalance;
/** 信用分 */
private Long credit;
/** 积分余额 */
private Long integral;
/** 真实姓名  */
private String realName;
/** 地址 */
private String address;
/** 司机认证状态(0.未认证通过 1.认证通过) */
private Integer driverAuthStatus;
/** 个人认证状态(0.未认证通过 1.认证通过） */
private Integer personalAuthStatus;
/** 企业认证状态(0.未认证通过 1.认证通过) */
private Integer companyAuthStatus;
/** 车主认证状态(0.未认证通过 1.认证通过) */
private Integer carOwnerAuthStatus;
/** 货主认证状态(0.未认证通过 1.认证通过) */
private Integer shipperAuthStatus;
/** 发票代开认证是否通过（0：未通过 ， 1：已通过） */
private Integer carOwnerIssuedStatus;
/** app端用户是否更新状态(0:不更新 1:更新) */
private Integer isUpdate;
/** 是否佬司机原有数据（0：是 1：否） */
private Integer isLsjData;
/** 提现冻结金额（当用户申请提现的时候，将金额冻结，提现成功后减去相应金额） */
private Long freezingAmountWithdrawals;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setTelephone(String telephone)
        {
        this.telephone = telephone;
        }

public String getTelephone()
        {
        return telephone;
        }
public void setSex(Integer sex)
        {
        this.sex = sex;
        }

public Integer getSex()
        {
        return sex;
        }
public void setBirthday(String birthday)
        {
        this.birthday = birthday;
        }

public String getBirthday()
        {
        return birthday;
        }
public void setQq(String qq)
        {
        this.qq = qq;
        }

public String getQq()
        {
        return qq;
        }
public void setQqId(String qqId)
        {
        this.qqId = qqId;
        }

public String getQqId()
        {
        return qqId;
        }
public void setWechat(String wechat)
        {
        this.wechat = wechat;
        }

public String getWechat()
        {
        return wechat;
        }
public void setWxId(String wxId)
        {
        this.wxId = wxId;
        }

public String getWxId()
        {
        return wxId;
        }
public void setNickname(String nickname)
        {
        this.nickname = nickname;
        }

public String getNickname()
        {
        return nickname;
        }
public void setAppVersion(String appVersion)
        {
        this.appVersion = appVersion;
        }

public String getAppVersion()
        {
        return appVersion;
        }
public void setLockFlag(Integer lockFlag)
        {
        this.lockFlag = lockFlag;
        }

public Integer getLockFlag()
        {
        return lockFlag;
        }
public void setWithdrawalPassword(String withdrawalPassword)
        {
        this.withdrawalPassword = withdrawalPassword;
        }

public String getWithdrawalPassword()
        {
        return withdrawalPassword;
        }
public void setPassword(String password)
        {
        this.password = password;
        }

public String getPassword()
        {
        return password;
        }
public void setEmail(String email)
        {
        this.email = email;
        }

public String getEmail()
        {
        return email;
        }
public void setRegisterTime(Integer registerTime)
        {
        this.registerTime = registerTime;
        }

public Integer getRegisterTime()
        {
        return registerTime;
        }
public void setLastLoginTime(Integer lastLoginTime)
        {
        this.lastLoginTime = lastLoginTime;
        }

public Integer getLastLoginTime()
        {
        return lastLoginTime;
        }
public void setInviteCode(String inviteCode)
        {
        this.inviteCode = inviteCode;
        }

public String getInviteCode()
        {
        return inviteCode;
        }
public void setLoginTelType(Integer loginTelType)
        {
        this.loginTelType = loginTelType;
        }

public Integer getLoginTelType()
        {
        return loginTelType;
        }
public void setLastLoginIp(String lastLoginIp)
        {
        this.lastLoginIp = lastLoginIp;
        }

public String getLastLoginIp()
        {
        return lastLoginIp;
        }
public void setHeadImg(String headImg)
        {
        this.headImg = headImg;
        }

public String getHeadImg()
        {
        return headImg;
        }
public void setRegisterType(Integer registerType)
        {
        this.registerType = registerType;
        }

public Integer getRegisterType()
        {
        return registerType;
        }
public void setOilsBalance(Long oilsBalance)
        {
        this.oilsBalance = oilsBalance;
        }

public Long getOilsBalance()
        {
        return oilsBalance;
        }
public void setOilsRechargeBalance(Long oilsRechargeBalance)
        {
        this.oilsRechargeBalance = oilsRechargeBalance;
        }

public Long getOilsRechargeBalance()
        {
        return oilsRechargeBalance;
        }
public void setGasBalance(Long gasBalance)
        {
        this.gasBalance = gasBalance;
        }

public Long getGasBalance()
        {
        return gasBalance;
        }
public void setEtcBalance(Long etcBalance)
        {
        this.etcBalance = etcBalance;
        }

public Long getEtcBalance()
        {
        return etcBalance;
        }
public void setSettleQuota(Long settleQuota)
        {
        this.settleQuota = settleQuota;
        }

public Long getSettleQuota()
        {
        return settleQuota;
        }
public void setSettleBalance(Long settleBalance)
        {
        this.settleBalance = settleBalance;
        }

public Long getSettleBalance()
        {
        return settleBalance;
        }
public void setFreezingAmount(Long freezingAmount)
        {
        this.freezingAmount = freezingAmount;
        }

public Long getFreezingAmount()
        {
        return freezingAmount;
        }
public void setAmountUsed(Long amountUsed)
        {
        this.amountUsed = amountUsed;
        }

public Long getAmountUsed()
        {
        return amountUsed;
        }
public void setPresentAmount(Long presentAmount)
        {
        this.presentAmount = presentAmount;
        }

public Long getPresentAmount()
        {
        return presentAmount;
        }
public void setTotalRecharge(Long totalRecharge)
        {
        this.totalRecharge = totalRecharge;
        }

public Long getTotalRecharge()
        {
        return totalRecharge;
        }
public void setTotalLoaning(Long totalLoaning)
        {
        this.totalLoaning = totalLoaning;
        }

public Long getTotalLoaning()
        {
        return totalLoaning;
        }
public void setTotalSettle(Long totalSettle)
        {
        this.totalSettle = totalSettle;
        }

public Long getTotalSettle()
        {
        return totalSettle;
        }
public void setRechargeBalance(Long rechargeBalance)
        {
        this.rechargeBalance = rechargeBalance;
        }

public Long getRechargeBalance()
        {
        return rechargeBalance;
        }
public void setLoaningBalance(Long loaningBalance)
        {
        this.loaningBalance = loaningBalance;
        }

public Long getLoaningBalance()
        {
        return loaningBalance;
        }
public void setCredit(Long credit)
        {
        this.credit = credit;
        }

public Long getCredit()
        {
        return credit;
        }
public void setIntegral(Long integral)
        {
        this.integral = integral;
        }

public Long getIntegral()
        {
        return integral;
        }
public void setRealName(String realName)
        {
        this.realName = realName;
        }

public String getRealName()
        {
        return realName;
        }
public void setAddress(String address)
        {
        this.address = address;
        }

public String getAddress()
        {
        return address;
        }
public void setDriverAuthStatus(Integer driverAuthStatus)
        {
        this.driverAuthStatus = driverAuthStatus;
        }

public Integer getDriverAuthStatus()
        {
        return driverAuthStatus;
        }
public void setPersonalAuthStatus(Integer personalAuthStatus)
        {
        this.personalAuthStatus = personalAuthStatus;
        }

public Integer getPersonalAuthStatus()
        {
        return personalAuthStatus;
        }
public void setCompanyAuthStatus(Integer companyAuthStatus)
        {
        this.companyAuthStatus = companyAuthStatus;
        }

public Integer getCompanyAuthStatus()
        {
        return companyAuthStatus;
        }
public void setCarOwnerAuthStatus(Integer carOwnerAuthStatus)
        {
        this.carOwnerAuthStatus = carOwnerAuthStatus;
        }

public Integer getCarOwnerAuthStatus()
        {
        return carOwnerAuthStatus;
        }
public void setShipperAuthStatus(Integer shipperAuthStatus)
        {
        this.shipperAuthStatus = shipperAuthStatus;
        }

public Integer getShipperAuthStatus()
        {
        return shipperAuthStatus;
        }
public void setCarOwnerIssuedStatus(Integer carOwnerIssuedStatus)
        {
        this.carOwnerIssuedStatus = carOwnerIssuedStatus;
        }

public Integer getCarOwnerIssuedStatus()
        {
        return carOwnerIssuedStatus;
        }
public void setIsUpdate(Integer isUpdate)
        {
        this.isUpdate = isUpdate;
        }

public Integer getIsUpdate()
        {
        return isUpdate;
        }
public void setIsLsjData(Integer isLsjData)
        {
        this.isLsjData = isLsjData;
        }

public Integer getIsLsjData()
        {
        return isLsjData;
        }
public void setFreezingAmountWithdrawals(Long freezingAmountWithdrawals)
        {
        this.freezingAmountWithdrawals = freezingAmountWithdrawals;
        }

public Long getFreezingAmountWithdrawals()
        {
        return freezingAmountWithdrawals;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("telephone", getTelephone())
	            .append("sex", getSex())
	            .append("birthday", getBirthday())
	            .append("qq", getQq())
	            .append("qqId", getQqId())
	            .append("wechat", getWechat())
	            .append("wxId", getWxId())
	            .append("nickname", getNickname())
	            .append("appVersion", getAppVersion())
	            .append("lockFlag", getLockFlag())
	            .append("withdrawalPassword", getWithdrawalPassword())
	            .append("password", getPassword())
	            .append("email", getEmail())
	            .append("registerTime", getRegisterTime())
	            .append("lastLoginTime", getLastLoginTime())
	            .append("inviteCode", getInviteCode())
	            .append("loginTelType", getLoginTelType())
	            .append("lastLoginIp", getLastLoginIp())
	            .append("headImg", getHeadImg())
	            .append("registerType", getRegisterType())
	            .append("oilsBalance", getOilsBalance())
	            .append("oilsRechargeBalance", getOilsRechargeBalance())
	            .append("gasBalance", getGasBalance())
	            .append("etcBalance", getEtcBalance())
	            .append("settleQuota", getSettleQuota())
	            .append("settleBalance", getSettleBalance())
	            .append("freezingAmount", getFreezingAmount())
	            .append("amountUsed", getAmountUsed())
	            .append("presentAmount", getPresentAmount())
	            .append("totalRecharge", getTotalRecharge())
	            .append("totalLoaning", getTotalLoaning())
	            .append("totalSettle", getTotalSettle())
	            .append("rechargeBalance", getRechargeBalance())
	            .append("loaningBalance", getLoaningBalance())
	            .append("credit", getCredit())
	            .append("integral", getIntegral())
	            .append("realName", getRealName())
	            .append("address", getAddress())
	            .append("driverAuthStatus", getDriverAuthStatus())
	            .append("personalAuthStatus", getPersonalAuthStatus())
	            .append("companyAuthStatus", getCompanyAuthStatus())
	            .append("carOwnerAuthStatus", getCarOwnerAuthStatus())
	            .append("shipperAuthStatus", getShipperAuthStatus())
	            .append("carOwnerIssuedStatus", getCarOwnerIssuedStatus())
	            .append("isUpdate", getIsUpdate())
	            .append("isLsjData", getIsLsjData())
	            .append("freezingAmountWithdrawals", getFreezingAmountWithdrawals())
	        .toString();
        }
        }
