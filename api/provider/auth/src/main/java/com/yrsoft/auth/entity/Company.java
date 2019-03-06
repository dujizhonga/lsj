package com.yrsoft.auth.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
																			
/**
 * 认证管理-企业认证表 a_company
 *
 * @author mz
 * @date 2019-03-05
 */
public class Company
{
private static final long serialVersionUID = 1L;

/** 编号 */
private String id;
/** fk:会员编号（会员信息表：编号） */
private String memberId;
/** 公司名称 */
private String companyName;
/** 法人姓名 */
private String companyHost;
/** 营业执照号 */
private String businessLicenceCode;
/** 法人身份证号 */
private String companyHostId;
/** 营业执照地址 */
private String businessLicenceAddress;
/** 营业执照有效期 */
private String businessLicenceValiditytime;
/** 营业执照图片 */
private String businessLicenceImg;
/** 身份证正面图片 */
private String hostIdCardImg;
/** 身份证背面图片 */
private String hostIdCardBackImg;
/** 认证状态（0：待审核，1：审核通过，2：审核拒绝） */
private Integer status;
/** 创建时间 */
private Integer createTime;
/** 0:新申请;1:旧申请 */
private Integer newFlag;
/** 审核时间 */
private Integer checkTime;
/** fk:审核人(员工表：编号) */
private String checkUserId;
/** 审核意见 */
private String description;
/** 是否系统审核 默认0否，1是 */
private Integer isSys;
/** 是否佬司机原有数据（0：是 ，1：否） */
private Integer isLsjData;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setMemberId(String memberId)
        {
        this.memberId = memberId;
        }

public String getMemberId()
        {
        return memberId;
        }
public void setCompanyName(String companyName)
        {
        this.companyName = companyName;
        }

public String getCompanyName()
        {
        return companyName;
        }
public void setCompanyHost(String companyHost)
        {
        this.companyHost = companyHost;
        }

public String getCompanyHost()
        {
        return companyHost;
        }
public void setBusinessLicenceCode(String businessLicenceCode)
        {
        this.businessLicenceCode = businessLicenceCode;
        }

public String getBusinessLicenceCode()
        {
        return businessLicenceCode;
        }
public void setCompanyHostId(String companyHostId)
        {
        this.companyHostId = companyHostId;
        }

public String getCompanyHostId()
        {
        return companyHostId;
        }
public void setBusinessLicenceAddress(String businessLicenceAddress)
        {
        this.businessLicenceAddress = businessLicenceAddress;
        }

public String getBusinessLicenceAddress()
        {
        return businessLicenceAddress;
        }
public void setBusinessLicenceValiditytime(String businessLicenceValiditytime)
        {
        this.businessLicenceValiditytime = businessLicenceValiditytime;
        }

public String getBusinessLicenceValiditytime()
        {
        return businessLicenceValiditytime;
        }
public void setBusinessLicenceImg(String businessLicenceImg)
        {
        this.businessLicenceImg = businessLicenceImg;
        }

public String getBusinessLicenceImg()
        {
        return businessLicenceImg;
        }
public void setHostIdCardImg(String hostIdCardImg)
        {
        this.hostIdCardImg = hostIdCardImg;
        }

public String getHostIdCardImg()
        {
        return hostIdCardImg;
        }
public void setHostIdCardBackImg(String hostIdCardBackImg)
        {
        this.hostIdCardBackImg = hostIdCardBackImg;
        }

public String getHostIdCardBackImg()
        {
        return hostIdCardBackImg;
        }
public void setStatus(Integer status)
        {
        this.status = status;
        }

public Integer getStatus()
        {
        return status;
        }
public void setCreateTime(Integer createTime)
        {
        this.createTime = createTime;
        }

public Integer getCreateTime()
        {
        return createTime;
        }
public void setNewFlag(Integer newFlag)
        {
        this.newFlag = newFlag;
        }

public Integer getNewFlag()
        {
        return newFlag;
        }
public void setCheckTime(Integer checkTime)
        {
        this.checkTime = checkTime;
        }

public Integer getCheckTime()
        {
        return checkTime;
        }
public void setCheckUserId(String checkUserId)
        {
        this.checkUserId = checkUserId;
        }

public String getCheckUserId()
        {
        return checkUserId;
        }
public void setDescription(String description)
        {
        this.description = description;
        }

public String getDescription()
        {
        return description;
        }
public void setIsSys(Integer isSys)
        {
        this.isSys = isSys;
        }

public Integer getIsSys()
        {
        return isSys;
        }
public void setIsLsjData(Integer isLsjData)
        {
        this.isLsjData = isLsjData;
        }

public Integer getIsLsjData()
        {
        return isLsjData;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("memberId", getMemberId())
	            .append("companyName", getCompanyName())
	            .append("companyHost", getCompanyHost())
	            .append("businessLicenceCode", getBusinessLicenceCode())
	            .append("companyHostId", getCompanyHostId())
	            .append("businessLicenceAddress", getBusinessLicenceAddress())
	            .append("businessLicenceValiditytime", getBusinessLicenceValiditytime())
	            .append("businessLicenceImg", getBusinessLicenceImg())
	            .append("hostIdCardImg", getHostIdCardImg())
	            .append("hostIdCardBackImg", getHostIdCardBackImg())
	            .append("status", getStatus())
	            .append("createTime", getCreateTime())
	            .append("newFlag", getNewFlag())
	            .append("checkTime", getCheckTime())
	            .append("checkUserId", getCheckUserId())
	            .append("description", getDescription())
	            .append("isSys", getIsSys())
	            .append("isLsjData", getIsLsjData())
	        .toString();
        }
        }
