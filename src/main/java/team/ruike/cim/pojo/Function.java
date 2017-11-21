package team.ruike.cim.pojo;


import java.io.Serializable;

public class Function implements Serializable {

  private static final long serialVersionUID = 372370922270141132L;
  private Integer functionId;
  private String functionName;
  private String functionUrl;
  private Integer jurisdictionId;
  private Integer status;


  public Integer getFunctionId() {
    return functionId;
  }

  public void setFunctionId(Integer functionId) {
    this.functionId = functionId;
  }


  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }


  public String getFunctionUrl() {
    return functionUrl;
  }

  public void setFunctionUrl(String functionUrl) {
    this.functionUrl = functionUrl;
  }


  public Integer getJurisdictionId() {
    return jurisdictionId;
  }

  public void setJurisdictionId(Integer jurisdictionId) {
    this.jurisdictionId = jurisdictionId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
