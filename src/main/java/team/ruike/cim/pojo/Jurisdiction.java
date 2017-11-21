package team.ruike.cim.pojo;


import java.io.Serializable;

public class Jurisdiction implements Serializable {

  private static final long serialVersionUID = 4347802888183585718L;
  private Integer jurisdictionId;
  private String jurisdictionName;
  private String jurisdictionUrl;
  private Integer status;


  public Integer getJurisdictionId() {
    return jurisdictionId;
  }

  public void setJurisdictionId(Integer jurisdictionId) {
    this.jurisdictionId = jurisdictionId;
  }


  public String getJurisdictionName() {
    return jurisdictionName;
  }

  public void setJurisdictionName(String jurisdictionName) {
    this.jurisdictionName = jurisdictionName;
  }


  public String getJurisdictionUrl() {
    return jurisdictionUrl;
  }

  public void setJurisdictionUrl(String jurisdictionUrl) {
    this.jurisdictionUrl = jurisdictionUrl;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
