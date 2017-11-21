package team.ruike.cim.pojo;


import java.io.Serializable;

public class ProductWarehouseRegisterItem implements Serializable {

  private static final long serialVersionUID = -6715749602097496720L;
  private Integer productWarehouseRegisterItemId;
  private Integer menuId;
  private Integer productGoodsShelveId;
  private Integer menuNumber;
  private Integer productWarehouseRegisterId;
  private Integer status;


  public Integer getProductWarehouseRegisterItemId() {
    return productWarehouseRegisterItemId;
  }

  public void setProductWarehouseRegisterItemId(Integer productWarehouseRegisterItemId) {
    this.productWarehouseRegisterItemId = productWarehouseRegisterItemId;
  }


  public Integer getMenuId() {
    return menuId;
  }

  public void setMenuId(Integer menuId) {
    this.menuId = menuId;
  }


  public Integer getProductGoodsShelveId() {
    return productGoodsShelveId;
  }

  public void setProductGoodsShelveId(Integer productGoodsShelveId) {
    this.productGoodsShelveId = productGoodsShelveId;
  }


  public Integer getMenuNumber() {
    return menuNumber;
  }

  public void setMenuNumber(Integer menuNumber) {
    this.menuNumber = menuNumber;
  }


  public Integer getProductWarehouseRegisterId() {
    return productWarehouseRegisterId;
  }

  public void setProductWarehouseRegisterId(Integer productWarehouseRegisterId) {
    this.productWarehouseRegisterId = productWarehouseRegisterId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
