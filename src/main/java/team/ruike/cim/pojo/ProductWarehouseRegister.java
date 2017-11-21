package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;
/**
 *成品库入库登记类
 * @author 王傲祥
 * @version 1.0
 */
public class ProductWarehouseRegister implements Serializable {
    private static final long serialVersionUID = -9125912786565069677L;
    /**
     * 成品库入库登记ID
     */
    private Integer productWarehouseRegisterId;
    /**
     * 生产批次
     */
    private String productionBatch;
    /**
     * 入库时间
     */
    private Date productWarehouseRegisterDate;
    /**
     * 入库人用户表
     */
    private Integer userId;
    /**
     * 删除状态
     */
    private Integer status;


    public Integer getProductWarehouseRegisterId() {
        return productWarehouseRegisterId;
    }

    public void setProductWarehouseRegisterId(Integer productWarehouseRegisterId) {
        this.productWarehouseRegisterId = productWarehouseRegisterId;
    }


    public String getProductionBatch() {
        return productionBatch;
    }

    public void setProductionBatch(String productionBatch) {
        this.productionBatch = productionBatch;
    }


    public Date getProductWarehouseRegisterDate() {
        return productWarehouseRegisterDate;
    }

    public void setProductWarehouseRegisterDate(Date productWarehouseRegisterDate) {
        this.productWarehouseRegisterDate = productWarehouseRegisterDate;
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
