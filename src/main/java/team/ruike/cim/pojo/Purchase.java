package team.ruike.cim.pojo;


import java.util.Date;

public class Purchase {

  private Integer purchaseId;
  private Integer everydayPurchasingPlanId;
  private String remarks;
  private Integer status;
  private Date purchaseDate;
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
