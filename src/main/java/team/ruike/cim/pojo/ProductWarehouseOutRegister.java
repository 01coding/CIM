package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;
/**
 *成品库出库登记类
 * @author 王傲祥
 * @version 1.0
 */
public class ProductWarehouseOutRegister implements Serializable {

  private static final long serialVersionUID = -8539739381224598056L;
  /**
   *成品库出库登记ID
   */
  private Integer productWarehouseOutRegisterId;
  /**
   * 出库时间
   */
  private Date productWarehouseOutRegisterEndDate;
  /**
   * 用户表id外键领料人
   */
  private Integer userId;
  /**
   * 删除状态
   */
  private Integer status;


  public Integer getProductWarehouseOutRegisterId() {
    return productWarehouseOutRegisterId;
  }

  public void setProductWarehouseOutRegisterId(Integer productWarehouseOutRegisterId) {
    this.productWarehouseOutRegisterId = productWarehouseOutRegisterId;
  }


  public Date getProductWarehouseOutRegisterEndDate() {
    return productWarehouseOutRegisterEndDate;
  }

  public void setProductWarehouseOutRegisterEndDate(Date productWarehouseOutRegisterEndDate) {
    this.productWarehouseOutRegisterEndDate = productWarehouseOutRegisterEndDate;
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
