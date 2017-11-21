package team.ruike.cim.pojo;


import java.io.Serializable;

public class ProductWarehouse implements Serializable {

  private static final long serialVersionUID = -2987997181280700582L;
  private Integer productWarehouseId;
  private String productWarehouseName;
  private String remarks;
  private Integer status;


  public Integer getProductWarehouseId() {
    return productWarehouseId;
  }

  public void setProductWarehouseId(Integer productWarehouseId) {
    this.productWarehouseId = productWarehouseId;
  }


  public String getProductWarehouseName() {
    return productWarehouseName;
  }

  public void setProductWarehouseName(String productWarehouseName) {
    this.productWarehouseName = productWarehouseName;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
