package com.yrsoft.freight.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 货运-储值记录表 p_stored_records
 *
 * @author mz
 * @date 2019-02-23
 */
public class PStoredRecords
{
        private static long serialVersionUID = 1L;

        /** 主键ID */
        private String id;
        /** 运单ID */
        private String waybillId;
        /** 加油费比例 */
        private String oilScale;
        /** 加气费比例 */
        private String gasScale;
        /** ETC费比例 */
        private String etcScale;
        /** 创建时间 */
        private Integer createTime;
        /** 修改时间 */
        private Integer updateTime;
        /** 删除状态（0：未删除，1：已删除） */
        private Integer deleteFlag;
        
        
        //车主名称
        private String ownerName;
        //车主电话
        private String ownerTelephone;
        //车牌号
        private String carNum;
        //运单编号
        private String waybillNumber;
        //运单金额
        private Long actualFreight;
        //车辆id
        private String carId;
        //车主id
        private String ownerId;
        //储值类型数
        private int StoredTypeNum;
        //储值总金额
        private Double StoredTotalSum;
        //车辆类型（0.自有车辆  1.平台车辆 ）',
        private Integer flag;
		public static long getSerialVersionUID() {
			return serialVersionUID;
		}
		public static void setSerialVersionUID(long serialVersionUID) {
			PStoredRecords.serialVersionUID = serialVersionUID;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getWaybillId() {
			return waybillId;
		}
		public void setWaybillId(String waybillId) {
			this.waybillId = waybillId;
		}
		public String getOilScale() {
			return oilScale;
		}
		public void setOilScale(String oilScale) {
			this.oilScale = oilScale;
		}
		public String getGasScale() {
			return gasScale;
		}
		public void setGasScale(String gasScale) {
			this.gasScale = gasScale;
		}
		public String getEtcScale() {
			return etcScale;
		}
		public void setEtcScale(String etcScale) {
			this.etcScale = etcScale;
		}
		public Integer getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Integer createTime) {
			this.createTime = createTime;
		}
		public Integer getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Integer updateTime) {
			this.updateTime = updateTime;
		}
		public Integer getDeleteFlag() {
			return deleteFlag;
		}
		public void setDeleteFlag(Integer deleteFlag) {
			this.deleteFlag = deleteFlag;
		}
		public String getOwnerName() {
			return ownerName;
		}
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		public String getOwnerTelephone() {
			return ownerTelephone;
		}
		public void setOwnerTelephone(String ownerTelephone) {
			this.ownerTelephone = ownerTelephone;
		}
		public String getCarNum() {
			return carNum;
		}
		public void setCarNum(String carNum) {
			this.carNum = carNum;
		}
		public String getWaybillNumber() {
			return waybillNumber;
		}
		public void setWaybillNumber(String waybillNumber) {
			this.waybillNumber = waybillNumber;
		}
		public Long getActualFreight() {
			return actualFreight;
		}
		public void setActualFreight(Long actualFreight) {
			this.actualFreight = actualFreight;
		}
		public String getCarId() {
			return carId;
		}
		public void setCarId(String carId) {
			this.carId = carId;
		}
		public String getOwnerId() {
			return ownerId;
		}
		public void setOwnerId(String ownerId) {
			this.ownerId = ownerId;
		}
		public int getStoredTypeNum() {
			return StoredTypeNum;
		}
		public void setStoredTypeNum(int storedTypeNum) {
			StoredTypeNum = storedTypeNum;
		}
		public Double getStoredTotalSum() {
			return StoredTotalSum;
		}
		public void setStoredTotalSum(Double storedTotalSum) {
			StoredTotalSum = storedTotalSum;
		}
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
		
}
