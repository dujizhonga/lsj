package com.yrsoft.website.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 网站管理-消息表 w_news
 *
 * @author mz
 * @date 2019-02-23
 */
public class WNews
{

	/** 主键id */
	private String id;
	/** 用户类型（0：司机端，1：货主端，2：网页端） */
	private Integer userType;
	/** 消息标题 */
	private String title;
	/** 消息内容 */
	private String content;
	/** 删除状态（0：未删除，1：已删除） */
	private Integer deleteFlag;
	/** 发布状态（0:未发布，1：已发布） */
	private Integer status;
	/** 发布时间 */
	private Integer publishTime;
	/** fk:创建人（用户表：编号） */
	private String createUser;
	/** 创建时间 */
	private Integer createTime;
	/** fk:修改人（用户表：编号） */
	private String updateUser;
	/** 修改时间 */
	private Integer updateTime;
	/** 消息所属会员id，如果为空 则所属所有人 */
	private String memberId;
	/** 0：未读  1：已读 */
	private Integer isRead;
	/** 对应的运单编号 */
	private String waybillNumber;
	/**车主的行为标示（1：已接单；2：已送达;3:已拒绝）*/
	private Integer newsType;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setPublishTime(Integer publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getPublishTime() {
		return publishTime;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public String getWaybillNumber() {
		return waybillNumber;
	}

	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}

	public Integer getNewsType() {
		return newsType;
	}

	public void setNewsType(Integer newsType) {
		this.newsType = newsType;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("userType", getUserType()).append("title", getTitle()).append("content", getContent())
				.append("deleteFlag", getDeleteFlag()).append("status", getStatus())
				.append("publishTime", getPublishTime()).append("createUser", getCreateUser())
				.append("createTime", getCreateTime()).append("updateUser", getUpdateUser())
				.append("updateTime", getUpdateTime()).append("memberId", getMemberId()).append("isRead", getIsRead())
				.append("waybillNumber", getWaybillNumber())
				.append("newsType",getNewsType()).toString();

	}

}
