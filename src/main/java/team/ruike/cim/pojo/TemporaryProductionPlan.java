package team.ruike.cim.pojo;


import java.util.Date;

public class TemporaryProductionPlan {

  private Integer temporaryProductionPlanId;
  private Integer temporaryOrderId;
  private String productionBatch;
  private Integer status;
  private Date date;


  public Integer getTemporaryProductionPlanId() {
    return temporaryProductionPlanId;
  }

  public void setTemporaryProductionPlanId(Integer temporaryProductionPlanId) {
    this.temporaryProductionPlanId = temporaryProductionPlanId;
  }


  public Integer getTemporaryOrderId() {
    return temporaryOrderId;
  }

  public void setTemporaryOrderId(Integer temporaryOrderId) {
    this.temporaryOrderId = temporaryOrderId;
  }


  public String getProductionBatch() {
    return productionBatch;
  }

  public void setProductionBatch(String productionBatch) {
    this.productionBatch = productionBatch;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
