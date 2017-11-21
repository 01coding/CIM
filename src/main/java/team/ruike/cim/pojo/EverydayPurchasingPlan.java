package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class EverydayPurchasingPlan implements Serializable {

  private static final long serialVersionUID = -5022604544780534725L;
  private Integer everydayPurchasingPlanId;
  private Integer everydayPurchasingPlanNo;
  private Date everydayPurchasingPlanDate;
  private Integer status;


  public Integer getEverydayPurchasingPlanId() {
    return everydayPurchasingPlanId;
  }

  public void setEverydayPurchasingPlanId(Integer everydayPurchasingPlanId) {
    this.everydayPurchasingPlanId = everydayPurchasingPlanId;
  }


  public Integer getEverydayPurchasingPlanNo() {
    return everydayPurchasingPlanNo;
  }

  public void setEverydayPurchasingPlanNo(Integer everydayPurchasingPlanNo) {
    this.everydayPurchasingPlanNo = everydayPurchasingPlanNo;
  }


  public Date getEverydayPurchasingPlanDate() {
    return everydayPurchasingPlanDate;
  }

  public void setEverydayPurchasingPlanDate(Date everydayPurchasingPlanDate) {
    this.everydayPurchasingPlanDate = everydayPurchasingPlanDate;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
