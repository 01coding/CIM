package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 入库登记记录项
 *
 * @author 孙天奇
 * @version 1.0
 */
public class WarehouseRegisterItem implements Serializable {

    private static final long serialVersionUID = -6425395051315653087L;
    /**
     * 入库登记记录项id
     */
    private Integer warehouseRegisterItemId;
    /**
     * 物料id外键
     */
    private Integer materielId;
    /**
     * 货架id
     */
    private Integer goodsShelveId;
    /**
     * 入库数量
     */
    private Integer materielNumber;
    /**
     * 入库记录id外键
     */
    private Integer warehouseRegisterId;
    /**
     * 入库登记记录项状态
     */
    private Integer status;


    public Integer getWarehouseRegisterItemId() {
        return warehouseRegisterItemId;
    }

    public void setWarehouseRegisterItemId(Integer warehouseRegisterItemId) {
        this.warehouseRegisterItemId = warehouseRegisterItemId;
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


    public Integer getWarehouseRegisterId() {
        return warehouseRegisterId;
    }

    public void setWarehouseRegisterId(Integer warehouseRegisterId) {
        this.warehouseRegisterId = warehouseRegisterId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
