package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class ContractProgress implements Serializable {
  private static final long serialVersionUID = -3202788285496916399L;
  private Integer contractProgressId;
  private Integer contractProductionDistributionId;
  private String remarks;
  private Date startDate;
  private Date endDate;
  private Integer status;


  public Integer getContractProgressId() {
    return contractProgressId;
  }

  public void setContractProgressId(Integer contractProgressId) {
    this.contractProgressId = contractProgressId;
  }


  public Integer getContractProductionDistributionId() {
    return contractProductionDistributionId;
  }

  public void setContractProductionDistributionId(Integer contractProductionDistributionId) {
    this.contractProductionDistributionId = contractProductionDistributionId;
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
