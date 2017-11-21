package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;
/**
 *采购类
 * @author 王傲祥
 * @version 1.0
 */
public class Purchase implements Serializable {

  private static final long serialVersionUID = -5046439097768407830L;
  /**
   * 采购ID
   */
  private Integer purchaseId;
  /**
   * 每日采购计划ID
   */
  private Integer everydayPurchasingPlanId;
  /**
   * 备注
   */
  private String remarks;
  /**
   * 删除状态
   */
  private Integer status;
  /**
   * 采购时间
   */
  private Date purchaseDate;
  /**
   * 用户表id外键(采购人)
   */
  private Integer userId;


  public Integer getPurchaseId() {
    return purchaseId;
  }

  public void setPurchaseId(Integer purchaseId) {
    this.purchaseId = purchaseId;
  }


  public Integer getEverydayPurchasingPlanId() {
    return everydayPurchasingPlanId;
  }

  public void setEverydayPurchasingPlanId(Integer everydayPurchasingPlanId) {
    this.everydayPurchasingPlanId = everydayPurchasingPlanId;
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


  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

}
