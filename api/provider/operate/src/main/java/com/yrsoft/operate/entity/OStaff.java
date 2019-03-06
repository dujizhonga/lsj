package com.yrsoft.operate.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
										
/**
 * 运营管理-人员表 o_staff
 *
 * @author mz
 * @date 2019-02-23
 */
public class OStaff
{
private static final long serialVersionUID = 1L;

/** 编号 */
private String id;
/** 姓名 */
private String name;
/** 年龄   */
private Integer age;
/** 性别(0：男，1：女) */
private Integer sex;
/** 入职时间   */
private Integer entryTime;
/** 合同期限 */
private Integer contractPeriod;
/** 是否激活(0：激活，1：锁定) */
private Integer isActive;
/** 电话 */
private String telephone;
/** 工号 */
private String workNumber;
/** 密码 */
private String password;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setAge(Integer age)
        {
        this.age = age;
        }

public Integer getAge()
        {
        return age;
        }
public void setSex(Integer sex)
        {
        this.sex = sex;
        }

public Integer getSex()
        {
        return sex;
        }
public void setEntryTime(Integer entryTime)
        {
        this.entryTime = entryTime;
        }

public Integer getEntryTime()
        {
        return entryTime;
        }
public void setContractPeriod(Integer contractPeriod)
        {
        this.contractPeriod = contractPeriod;
        }

public Integer getContractPeriod()
        {
        return contractPeriod;
        }
public void setIsActive(Integer isActive)
        {
        this.isActive = isActive;
        }

public Integer getIsActive()
        {
        return isActive;
        }
public void setTelephone(String telephone)
        {
        this.telephone = telephone;
        }

public String getTelephone()
        {
        return telephone;
        }
public void setWorkNumber(String workNumber)
        {
        this.workNumber = workNumber;
        }

public String getWorkNumber()
        {
        return workNumber;
        }
public void setPassword(String password)
        {
        this.password = password;
        }

public String getPassword()
        {
        return password;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("name", getName())
	            .append("age", getAge())
	            .append("sex", getSex())
	            .append("entryTime", getEntryTime())
	            .append("contractPeriod", getContractPeriod())
	            .append("isActive", getIsActive())
	            .append("telephone", getTelephone())
	            .append("workNumber", getWorkNumber())
	            .append("password", getPassword())
	        .toString();
        }
        }
