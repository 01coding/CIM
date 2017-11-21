package team.ruike.cim.pojo;


import java.io.Serializable;
/**
 *成品仓库区域表类
 * @author 王傲祥
 * @version 1.0
 */
public class ProductWarehouseRegion implements Serializable {

  private static final long serialVersionUID = -7504917268504276428L;
  /**
   * 成品仓库区域表ID
   */
  private Integer productWarehouseRegionId;
  /**
   * 区域编号
   */
  private String productWarehouseRegionNo;
  /**
   * 菜品类型id(规定)
   */
  private Integer menuTypeId;
  /**
   * 备注
   */
  private String remarks;
  /**
   * 删除状态
   */
  private Integer status;
  /**
   * 成品仓库ID
   */
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
