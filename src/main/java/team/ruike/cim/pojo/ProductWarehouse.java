package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.List;

/**
 * 成品仓库类
 * @author 王傲祥
 * @version 1.0
 */
public class ProductWarehouse implements Serializable {

  private static final long serialVersionUID = -2987997181280700582L;
  /**
   * 成品仓库ID
   */
  private Integer productWarehouseId;
  /**
   * 成品名称
   */
  private String productWarehouseName;
  /**
   * 备注
   */
  private String remarks;
  /**
   * 删除状态
   */
  private Integer status;
  /**
   * 成品仓库区域类集合
   */
  private List<ProductGoodsShelve> productGoodsShelveList;

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

  public List<ProductGoodsShelve> getProductGoodsShelveList() {
    return productGoodsShelveList;
  }

  public void setProductGoodsShelveList(List<ProductGoodsShelve> productGoodsShelveList) {
    this.productGoodsShelveList = productGoodsShelveList;
  }
}
