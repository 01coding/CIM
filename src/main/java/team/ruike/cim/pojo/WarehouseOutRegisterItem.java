package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 出库登记表项
 *
 * @author 孙天奇
 * @version 1.0
 */
public class WarehouseOutRegisterItem implements Serializable {

    private static final long serialVersionUID = 6782034736748393920L;
    /**
     * 出库登记表项id
     */
    private Integer warehouseOutRegisterItemId;
    /**
     * 物料id外键
     */
    private Integer materielId;
    /**
     * 货架id
     */
    private Integer goodsShelveId;
    /**
     * 出库数量
     */
    private Integer materielNumber;
    /**
     * 出口登记表外键
     */
    private Integer warehouseOutRegisterId;
    /**
     * 状态
     */
    private Integer status;


    public Integer getWarehouseOutRegisterItemId() {
        return warehouseOutRegisterItemId;
    }

    public void setWarehouseOutRegisterItemId(Integer warehouseOutRegisterItemId) {
        this.warehouseOutRegisterItemId = warehouseOutRegisterItemId;
    }


    public Integer getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Integer materielId) {
        this.materielId = materielId;
    }


    public Integer getGoodsShelveId() {
        return goodsShelveId;
    }

    public void setGoodsShelveId(Integer goodsShelveId) {
        this.goodsShelveId = goodsShelveId;
    }


    public Integer getMaterielNumber() {
        return materielNumber;
    }

    public void setMaterielNumber(Integer materielNumber) {
        this.materielNumber = materielNumber;
    }


    public Integer getWarehouseOutRegisterId() {
        return warehouseOutRegisterId;
    }

    public void setWarehouseOutRegisterId(Integer warehouseOutRegisterId) {
        this.warehouseOutRegisterId = warehouseOutRegisterId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
