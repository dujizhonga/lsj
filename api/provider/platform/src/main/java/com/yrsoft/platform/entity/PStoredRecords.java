package com.yrsoft.platform.entity;

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
        private static final long serialVersionUID = 1L;

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

        public static long getSerialVersionUID() {
                return serialVersionUID;
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
}
