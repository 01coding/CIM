package team.ruike.cim.pojo;


import java.io.Serializable;

public class ProductWarehouseOutRegisterItem implements Serializable {

  private static final long serialVersionUID = -6274426992693661592L;
  private Integer productWarehouseOutRegisterItemId;
  private Integer menuId;
  private Integer productGoodsShelveId;
  private Integer menuNumber;
  private Integer productWarehouseOutRegisterId;
  private Integer status;


  public Integer getProductWarehouseOutRegisterItemId() {
    return productWarehouseOutRegisterItemId;
  }

  public void setProductWarehouseOutRegisterItemId(Integer productWarehouseOutRegisterItemId) {
    this.productWarehouseOutRegisterItemId = productWarehouseOutRegisterItemId;
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


  public Integer getProductWarehouseOutRegisterId() {
    return productWarehouseOutRegisterId;
  }

  public void setProductWarehouseOutRegisterId(Integer productWarehouseOutRegisterId) {
    this.productWarehouseOutRegisterId = productWarehouseOutRegisterId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
