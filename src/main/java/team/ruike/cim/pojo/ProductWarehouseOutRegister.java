package team.ruike.cim.pojo;


import java.util.Date;

public class ProductWarehouseOutRegister {

  private Integer productWarehouseOutRegisterId;
  private Date productWarehouseOutRegisterEndDate;
  private Integer userId;
  private Integer status;


  public Integer getProductWarehouseOutRegisterId() {
    return productWarehouseOutRegisterId;
  }

  public void setProductWarehouseOutRegisterId(Integer productWarehouseOutRegisterId) {
    this.productWarehouseOutRegisterId = productWarehouseOutRegisterId;
  }


  public Date getProductWarehouseOutRegisterEndDate() {
    return productWarehouseOutRegisterEndDate;
  }

  public void setProductWarehouseOutRegisterEndDate(Date productWarehouseOutRegisterEndDate) {
    this.productWarehouseOutRegisterEndDate = productWarehouseOutRegisterEndDate;
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
