package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 入库登记表
 *
 * @author 孙天奇
 * @version 1.0
 */
public class WarehouseRegister implements Serializable {

    private static final long serialVersionUID = 3392966639955030964L;
    /**
     * 入库登记表id
     */
    private Integer warehouseRegisterId;
    /**
     * 每日采购计划id外键
     */
    private Integer everydayPurchasingPlanId;
    /**
     * 入库时间
     */
    private Date warehouseRegisterDate;
    /**
     * 入库人用户表外键
     */
    private Integer userId;
    /**
     * 状态
     */
    private Integer status;


    public Integer getWarehouseRegisterId() {
        return warehouseRegisterId;
    }

    public void setWarehouseRegisterId(Integer warehouseRegisterId) {
        this.warehouseRegisterId = warehouseRegisterId;
    }


    public Integer getEverydayPurchasingPlanId() {
        return everydayPurchasingPlanId;
    }

    public void setEverydayPurchasingPlanId(Integer everydayPurchasingPlanId) {
        this.everydayPurchasingPlanId = everydayPurchasingPlanId;
    }


    public Date getWarehouseRegisterDate() {
        return warehouseRegisterDate;
    }

    public void setWarehouseRegisterDate(Date warehouseRegisterDate) {
        this.warehouseRegisterDate = warehouseRegisterDate;
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
