package team.ruike.cim.pojo;


import java.io.Serializable;
/**
 *成品库入库登记记录项类
 * @author 王傲祥
 * @version 1.0
 */
public class ProductWarehouseRegisterItem implements Serializable {

  private static final long serialVersionUID = -6715749602097496720L;
  /**
   * 成品库入库登记记录项ID
   */
  private Integer productWarehouseRegisterItemId;
  /**
   * 菜品ID
   */
  private Integer menuId;
  /**
   * 成品货架ID
   */
  private Integer productGoodsShelveId;
  /**
   * 入库数量
   */
  private Integer menuNumber;
  /**
   * 成品入库记录ID
   */
  private Integer productWarehouseRegisterId;
  /**
   * 删除状态
   */
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
