package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class TemporaryProgress implements Serializable {

  private static final long serialVersionUID = -7849773436851293569L;
  private Integer temporaryProgressId;
  private Integer temporaryProductionDistributionId;
  private String remarks;
  private Date startDate;
  private Date endDate;
  private Integer status;


  public Integer getTemporaryProgressId() {
    return temporaryProgressId;
  }

  public void setTemporaryProgressId(Integer temporaryProgressId) {
    this.temporaryProgressId = temporaryProgressId;
  }


  public Integer getTemporaryProductionDistributionId() {
    return temporaryProductionDistributionId;
  }

  public void setTemporaryProductionDistributionId(Integer temporaryProductionDistributionId) {
    this.temporaryProductionDistributionId = temporaryProductionDistributionId;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
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


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
