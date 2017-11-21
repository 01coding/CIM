package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class TemporaryProductionDistribution implements Serializable {

  private static final long serialVersionUID = -7121600245271357479L;
  private Integer temporaryProductionDistributionId;
  private Integer temporaryProductionPlanItemId;
  private Integer workingId;
  private Integer userId;
  private Integer peopleNumber;
  private Integer productionLineId;
  private String remarks;
  private Integer status;
  private Integer nextWorkingNumber;
  private Date startDate;
  private Date endDate;


  public Integer getTemporaryProductionDistributionId() {
    return temporaryProductionDistributionId;
  }

  public void setTemporaryProductionDistributionId(Integer temporaryProductionDistributionId) {
    this.temporaryProductionDistributionId = temporaryProductionDistributionId;
  }


  public Integer getTemporaryProductionPlanItemId() {
    return temporaryProductionPlanItemId;
  }

  public void setTemporaryProductionPlanItemId(Integer temporaryProductionPlanItemId) {
    this.temporaryProductionPlanItemId = temporaryProductionPlanItemId;
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

}
