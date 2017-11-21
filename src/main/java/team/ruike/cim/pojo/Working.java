package team.ruike.cim.pojo;


import java.io.Serializable;

public class Working implements Serializable {

  private static final long serialVersionUID = 6073877080532606188L;
  private Integer workingId;
  private String workingName;
  private Integer status;


  public Integer getWorkingId() {
    return workingId;
  }

  public void setWorkingId(Integer workingId) {
    this.workingId = workingId;
  }


  public String getWorkingName() {
    return workingName;
  }

  public void setWorkingName(String workingName) {
    this.workingName = workingName;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
