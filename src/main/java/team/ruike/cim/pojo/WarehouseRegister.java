package team.ruike.cim.pojo;


import java.util.Date;

public class WarehouseRegister {

  private Integer warehouseRegisterId;
  private Integer everydayPurchasingPlanId;
  private Date warehouseRegisterDate;
  private Integer userId;
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
