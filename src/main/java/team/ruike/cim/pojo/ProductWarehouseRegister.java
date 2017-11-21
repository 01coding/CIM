package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class ProductWarehouseRegister implements Serializable {
    private static final long serialVersionUID = -9125912786565069677L;
    private Integer productWarehouseRegisterId;
    private String productionBatch;
    private Date productWarehouseRegisterDate;
    private Integer userId;
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
