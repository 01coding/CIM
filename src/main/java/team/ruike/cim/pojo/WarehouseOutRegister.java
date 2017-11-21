package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 出库登记表
 *
 * @author 孙天奇
 * @version 1.0
 */
public class WarehouseOutRegister implements Serializable {

    private static final long serialVersionUID = -326486441366423505L;
    /**
     * 出库登记表id
     */
    private Integer warehouseOutRegisterId;
    /**
     * 出库时间
     */
    private Date warehouseOutRegisterEndDate;
    /**
     * 用户表id外键领料人
     */
    private Integer userId;
    /**
     * 状态
     */
    private Integer status;


    public Integer getWarehouseOutRegisterId() {
        return warehouseOutRegisterId;
    }

    public void setWarehouseOutRegisterId(Integer warehouseOutRegisterId) {
        this.warehouseOutRegisterId = warehouseOutRegisterId;
    }


    public Date getWarehouseOutRegisterEndDate() {
        return warehouseOutRegisterEndDate;
    }

    public void setWarehouseOutRegisterEndDate(Date warehouseOutRegisterEndDate) {
        this.warehouseOutRegisterEndDate = warehouseOutRegisterEndDate;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
