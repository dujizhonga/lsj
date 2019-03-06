package com.yrsoft.delivery.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 货运-运单表 p_waybill
 *
 * @author mz
 * @date 2019-02-23
 */
public class PWaybill
{
private static final long serialVersionUID = 1L;

/** 主键id */
private String id;
/** 运单编号 */
private String waybillNumber;
/** 货运单id */
private String invoiceId;
/** 车辆id */
private String carId;
/** 运费id */
private String freightId;
/** 保险费支付记录id（p_insurance表id） */
private String insuranceId;
/** 预付运费（单位：分） */
private Long advanceFreight;
/** 实际运费(单位：分) */
private Long actualFreight;
/** 实际运费确认人(fk:员工表) */
private String freightConfirmer;
/** 实际运费确认时间 */
private Integer freightConfirmationTime;
/** 实际运费确认意见 */
private String freightConfirmationOpinion;
/** 修改运费原因 */
private String modifyCause;
/** 磅单照片(发货前) */
private String poundsImg1;
/** 磅单照片(送达后) */
private String poundsImg2;
/** 磅单重量（发货前 单位：吨） */
private String poundsNum1;
/** 磅单重量（送达后 单位：吨） */
private String poundsNum2;
/** 运单创建时间 */
private Integer createTime;
/** 发货时间 */
private Integer deliveryTime;
/** 货物送达时间 */
private Integer deliveryGoodsTime;
/** 确认收货时间 */
private Integer confirmReceiptTime;
/** 运单类型（0.指派单  1.系统单 ） */
private Integer flag;
/** 是否撤销运单(0：否，1：是) */
private Integer isCancel;
/** 运单状态 0-未发货 1-已发货 2-已送达 3-已收货 4-已撤销 */
private Integer waybillState;
/** 储值状态 0-否 1-是 */
private Integer storedState;
/** 运单运费支付状态(0.未支付 1.已支付 2.支付中) */
private Integer freightPayState;
/** 运费支付方式 （0-垫资 1-垫支 2-现金） */
private Integer freightPayWay;
/** 运单保险费支付状态(0.未支付 1.已支付 2.支付中) */
private Integer insurancePayState;
/** 是否已评论（0：否，1是） */
private Integer isComments;
/** 评论星级（5：五星，4：四星.....） */
private Integer star;
/** 评价内容 */
private String comment;
/** 评价选项 */
private String evaluateOptions;
/** 运单开票状态(0:未开票 1:开票中,2:已开票 ) */
private Integer receiptStatus;
/** 删除状态（0：未删除，1：已删除） */
private Integer deleteFlag;

public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setWaybillNumber(String waybillNumber)
        {
        this.waybillNumber = waybillNumber;
        }

public String getWaybillNumber()
        {
        return waybillNumber;
        }
public void setInvoiceId(String invoiceId)
        {
        this.invoiceId = invoiceId;
        }

public String getInvoiceId()
        {
        return invoiceId;
        }
public void setCarId(String carId)
        {
        this.carId = carId;
        }

public String getCarId()
        {
        return carId;
        }
public void setFreightId(String freightId)
        {
        this.freightId = freightId;
        }

public String getFreightId()
        {
        return freightId;
        }
public void setInsuranceId(String insuranceId)
        {
        this.insuranceId = insuranceId;
        }

public String getInsuranceId()
        {
        return insuranceId;
        }
public void setAdvanceFreight(Long advanceFreight)
        {
        this.advanceFreight = advanceFreight;
        }

public Long getAdvanceFreight()
        {
        return advanceFreight;
        }
public void setActualFreight(Long actualFreight)
        {
        this.actualFreight = actualFreight;
        }

public Long getActualFreight()
        {
        return actualFreight;
        }
public void setFreightConfirmer(String freightConfirmer)
        {
        this.freightConfirmer = freightConfirmer;
        }

public String getFreightConfirmer()
        {
        return freightConfirmer;
        }
public void setFreightConfirmationTime(Integer freightConfirmationTime)
        {
        this.freightConfirmationTime = freightConfirmationTime;
        }

public Integer getFreightConfirmationTime()
        {
        return freightConfirmationTime;
        }
public void setFreightConfirmationOpinion(String freightConfirmationOpinion)
        {
        this.freightConfirmationOpinion = freightConfirmationOpinion;
        }

public String getFreightConfirmationOpinion()
        {
        return freightConfirmationOpinion;
        }
public void setModifyCause(String modifyCause)
        {
        this.modifyCause = modifyCause;
        }

public String getModifyCause()
        {
        return modifyCause;
        }
public void setPoundsImg1(String poundsImg1)
        {
        this.poundsImg1 = poundsImg1;
        }

public String getPoundsImg1()
        {
        return poundsImg1;
        }
public void setPoundsImg2(String poundsImg2)
        {
        this.poundsImg2 = poundsImg2;
        }

public String getPoundsImg2()
        {
        return poundsImg2;
        }
public void setPoundsNum1(String poundsNum1)
        {
        this.poundsNum1 = poundsNum1;
        }

public String getPoundsNum1()
        {
        return poundsNum1;
        }
public void setPoundsNum2(String poundsNum2)
        {
        this.poundsNum2 = poundsNum2;
        }

public String getPoundsNum2()
        {
        return poundsNum2;
        }
public void setCreateTime(Integer createTime)
        {
        this.createTime = createTime;
        }

public Integer getCreateTime()
        {
        return createTime;
        }
public void setDeliveryTime(Integer deliveryTime)
        {
        this.deliveryTime = deliveryTime;
        }

public Integer getDeliveryTime()
        {
        return deliveryTime;
        }
public void setDeliveryGoodsTime(Integer deliveryGoodsTime)
        {
        this.deliveryGoodsTime = deliveryGoodsTime;
        }

public Integer getDeliveryGoodsTime()
        {
        return deliveryGoodsTime;
        }
public void setConfirmReceiptTime(Integer confirmReceiptTime)
        {
        this.confirmReceiptTime = confirmReceiptTime;
        }

public Integer getConfirmReceiptTime()
        {
        return confirmReceiptTime;
        }
public void setFlag(Integer flag)
        {
        this.flag = flag;
        }

public Integer getFlag()
        {
        return flag;
        }
public void setIsCancel(Integer isCancel)
        {
        this.isCancel = isCancel;
        }

public Integer getIsCancel()
        {
        return isCancel;
        }
public void setWaybillState(Integer waybillState)
        {
        this.waybillState = waybillState;
        }

public Integer getWaybillState()
        {
        return waybillState;
        }
public void setStoredState(Integer storedState)
        {
        this.storedState = storedState;
        }

public Integer getStoredState()
        {
        return storedState;
        }
public void setFreightPayState(Integer freightPayState)
        {
        this.freightPayState = freightPayState;
        }

public Integer getFreightPayState()
        {
        return freightPayState;
        }
public void setFreightPayWay(Integer freightPayWay)
        {
        this.freightPayWay = freightPayWay;
        }

public Integer getFreightPayWay()
        {
        return freightPayWay;
        }
public void setInsurancePayState(Integer insurancePayState)
        {
        this.insurancePayState = insurancePayState;
        }

public Integer getInsurancePayState()
        {
        return insurancePayState;
        }
public void setIsComments(Integer isComments)
        {
        this.isComments = isComments;
        }

public Integer getIsComments()
        {
        return isComments;
        }
public void setStar(Integer star)
        {
        this.star = star;
        }

public Integer getStar()
        {
        return star;
        }
public void setComment(String comment)
        {
        this.comment = comment;
        }

public String getComment()
        {
        return comment;
        }
public void setEvaluateOptions(String evaluateOptions)
        {
        this.evaluateOptions = evaluateOptions;
        }

public String getEvaluateOptions()
        {
        return evaluateOptions;
        }
public void setReceiptStatus(Integer receiptStatus)
        {
        this.receiptStatus = receiptStatus;
        }

public Integer getReceiptStatus()
        {
        return receiptStatus;
        }
public void setDeleteFlag(Integer deleteFlag)
        {
        this.deleteFlag = deleteFlag;
        }

public Integer getDeleteFlag()
        {
        return deleteFlag;
        }

public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("id", getId())
	            .append("waybillNumber", getWaybillNumber())
	            .append("invoiceId", getInvoiceId())
	            .append("carId", getCarId())
	            .append("freightId", getFreightId())
	            .append("insuranceId", getInsuranceId())
	            .append("advanceFreight", getAdvanceFreight())
	            .append("actualFreight", getActualFreight())
	            .append("freightConfirmer", getFreightConfirmer())
	            .append("freightConfirmationTime", getFreightConfirmationTime())
	            .append("freightConfirmationOpinion", getFreightConfirmationOpinion())
	            .append("modifyCause", getModifyCause())
	            .append("poundsImg1", getPoundsImg1())
	            .append("poundsImg2", getPoundsImg2())
	            .append("poundsNum1", getPoundsNum1())
	            .append("poundsNum2", getPoundsNum2())
	            .append("createTime", getCreateTime())
	            .append("deliveryTime", getDeliveryTime())
	            .append("deliveryGoodsTime", getDeliveryGoodsTime())
	            .append("confirmReceiptTime", getConfirmReceiptTime())
	            .append("flag", getFlag())
	            .append("isCancel", getIsCancel())
	            .append("waybillState", getWaybillState())
	            .append("storedState", getStoredState())
	            .append("freightPayState", getFreightPayState())
	            .append("freightPayWay", getFreightPayWay())
	            .append("insurancePayState", getInsurancePayState())
	            .append("isComments", getIsComments())
	            .append("star", getStar())
	            .append("comment", getComment())
	            .append("evaluateOptions", getEvaluateOptions())
	            .append("receiptStatus", getReceiptStatus())
	            .append("deleteFlag", getDeleteFlag())
	        .toString();
        }
        }
