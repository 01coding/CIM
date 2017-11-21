package team.ruike.cim.pojo;


import java.util.Date;

public class ContractProductionPlan {

  private Integer contractProductionPlanId;
  private Integer contractOrderId;
  private String productionBatch;
  private Integer status;
  private Date date;


  public Integer getContractProductionPlanId() {
    return contractProductionPlanId;
  }

  public void setContractProductionPlanId(Integer contractProductionPlanId) {
    this.contractProductionPlanId = contractProductionPlanId;
  }


  public Integer getContractOrderId() {
    return contractOrderId;
  }

  public void setContractOrderId(Integer contractOrderId) {
    this.contractOrderId = contractOrderId;
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
