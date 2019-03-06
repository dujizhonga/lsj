package com.yrsoft.tripartite.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 认证管理-个人认证表 a_person
 *
 * @author mz
 * @date 2019-03-05
 */
public class Person
{
private static final long serialVersionUID = 1L;

/** 编号 */
private String id;
/** fk:会员编号(会员表：编号） */
private String memberId;
/** 姓名 */
private String name;
/** 身份证号 */
private String idCardCode;
/** 身份证正面图片 */
private String idCardImg;
/** 身份证背面图片 */
private String idCardBackImg;
/** 认证状态（0：待审核，1：审核通过，2：审核拒绝） */
private Integer status;
/** 创建时间 */
private Integer createTime;
/** 0新申请 1旧申请 */
private Integer newFlag;
/** 审核时间 */
private Integer checkTime;
/** fk:审核人（员工表：编号) */
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
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setIdCardCode(String idCardCode)
        {
        this.idCardCode = idCardCode;
        }

public String getIdCardCode()
        {
        return idCardCode;
        }
public void setIdCardImg(String idCardImg)
        {
        this.idCardImg = idCardImg;
        }

public String getIdCardImg()
        {
        return idCardImg;
        }
public void setIdCardBackImg(String idCardBackImg)
        {
        this.idCardBackImg = idCardBackImg;
        }

public String getIdCardBackImg()
        {
        return idCardBackImg;
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
	            .append("name", getName())
	            .append("idCardCode", getIdCardCode())
	            .append("idCardImg", getIdCardImg())
	            .append("idCardBackImg", getIdCardBackImg())
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
