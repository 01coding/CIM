package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class ProductGoodsShelve implements Serializable {

  private static final long serialVersionUID = -5419830913202750841L;
  private Integer productGoodsShelveId;
  private String productGoodsShelveNo;
  private Integer menuId;
  private Integer menuNumber;
  private Date materielShelfLifeEndDate;
  private Integer status;
  private Integer productWarehouseRegionId;


  public Integer getProductGoodsShelveId() {
    return productGoodsShelveId;
  }

  public void setProductGoodsShelveId(Integer productGoodsShelveId) {
    this.productGoodsShelveId = productGoodsShelveId;
  }


  public String getProductGoodsShelveNo() {
    return productGoodsShelveNo;
  }

  public void setProductGoodsShelveNo(String productGoodsShelveNo) {
    this.productGoodsShelveNo = productGoodsShelveNo;
  }


  public Integer getMenuId() {
    return menuId;
  }

  public void setMenuId(Integer menuId) {
    this.menuId = menuId;
  }


  public Integer getMenuNumber() {
    return menuNumber;
  }

  public void setMenuNumber(Integer menuNumber) {
    this.menuNumber = menuNumber;
  }


  public Date getMaterielShelfLifeEndDate() {
    return materielShelfLifeEndDate;
  }

  public void setMaterielShelfLifeEndDate(Date materielShelfLifeEndDate) {
    this.materielShelfLifeEndDate = materielShelfLifeEndDate;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Integer getProductWarehouseRegionId() {
    return productWarehouseRegionId;
  }

  public void setProductWarehouseRegionId(Integer productWarehouseRegionId) {
    this.productWarehouseRegionId = productWarehouseRegionId;
  }

}
