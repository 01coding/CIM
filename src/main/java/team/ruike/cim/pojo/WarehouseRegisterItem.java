package team.ruike.cim.pojo;


import java.io.Serializable;

public class WarehouseRegisterItem implements Serializable {

  private static final long serialVersionUID = -6425395051315653087L;
  private Integer warehouseRegisterItemId;
  private Integer materielId;
  private Integer goodsShelveId;
  private Integer materielNumber;
  private Integer warehouseRegisterId;
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
