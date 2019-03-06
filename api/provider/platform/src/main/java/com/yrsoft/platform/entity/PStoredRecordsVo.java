package com.yrsoft.platform.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
								
/**
 * 货运-储值记录表 p_stored_records
 *
 * @author mz
 * @date 2019-02-23
 */
public class PStoredRecordsVo
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
        //车辆id
        private String  carId;
        //车主id
        private String ownerId;
        //运单编号
        private String waybillNumber;
        //运单金额
        private Long actualFreight;
        //车辆类型（0.自由车辆 1.平台车辆 ）',
        private Integer flag;
		public static long getSerialVersionUID() {
			return serialVersionUID;
		}
		public static void setSerialVersionUID(long serialVersionUID) {
			PStoredRecordsVo.serialVersionUID = serialVersionUID;
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
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
	
}
