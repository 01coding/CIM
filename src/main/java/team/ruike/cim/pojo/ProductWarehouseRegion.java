package team.ruike.cim.pojo;


import java.io.Serializable;

public class ProductWarehouseRegion implements Serializable {

  private static final long serialVersionUID = -7504917268504276428L;
  private Integer productWarehouseRegionId;
  private String productWarehouseRegionNo;
  private Integer menuTypeId;
  private String remarks;
  private Integer status;
  private Integer productWarehouseId;


  public Integer getProductWarehouseRegionId() {
    return productWarehouseRegionId;
  }

  public void setProductWarehouseRegionId(Integer productWarehouseRegionId) {
    this.productWarehouseRegionId = productWarehouseRegionId;
  }


  public String getProductWarehouseRegionNo() {
    return productWarehouseRegionNo;
  }

  public void setProductWarehouseRegionNo(String productWarehouseRegionNo) {
    this.productWarehouseRegionNo = productWarehouseRegionNo;
  }


  public Integer getMenuTypeId() {
    return menuTypeId;
  }

  public void setMenuTypeId(Integer menuTypeId) {
    this.menuTypeId = menuTypeId;
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


  public Integer getProductWarehouseId() {
    return productWarehouseId;
  }

  public void setProductWarehouseId(Integer productWarehouseId) {
    this.productWarehouseId = productWarehouseId;
  }

}
