package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class ContractProductionDistribution implements Serializable {
  private static final long serialVersionUID = 4224470599322559142L;
  private Integer contractProductionDistributionId;
  private Integer contractProductionPlanItemId;
  private Integer workingId;
  private Integer userId;
  private Date startDate;
  private Date endDate;
  private Integer peopleNumber;
  private Integer productionLineId;
  private String remarks;
  private Integer status;
  private Integer nextWorkingNumber;


  public Integer getContractProductionDistributionId() {
    return contractProductionDistributionId;
  }

  public void setContractProductionDistributionId(Integer contractProductionDistributionId) {
    this.contractProductionDistributionId = contractProductionDistributionId;
  }


  public Integer getContractProductionPlanItemId() {
    return contractProductionPlanItemId;
  }

  public void setContractProductionPlanItemId(Integer contractProductionPlanItemId) {
    this.contractProductionPlanItemId = contractProductionPlanItemId;
  }


  public Integer getWorkingId() {
    return workingId;
  }

  public void setWorkingId(Integer workingId) {
    this.workingId = workingId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }


  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }


  public Integer getPeopleNumber() {
    return peopleNumber;
  }

  public void setPeopleNumber(Integer peopleNumber) {
    this.peopleNumber = peopleNumber;
  }


  public Integer getProductionLineId() {
    return productionLineId;
  }

  public void setProductionLineId(Integer productionLineId) {
    this.productionLineId = productionLineId;
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


  public Integer getNextWorkingNumber() {
    return nextWorkingNumber;
  }

  public void setNextWorkingNumber(Integer nextWorkingNumber) {
    this.nextWorkingNumber = nextWorkingNumber;
  }

}
