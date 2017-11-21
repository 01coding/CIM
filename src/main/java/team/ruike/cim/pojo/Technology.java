package team.ruike.cim.pojo;


import java.io.Serializable;

public class Technology implements Serializable {

  private static final long serialVersionUID = 1121809937090228362L;
  private Integer technologyId;
  private String technologyName;
  private Integer workingId;
  private Integer status;


  public Integer getTechnologyId() {
    return technologyId;
  }

  public void setTechnologyId(Integer technologyId) {
    this.technologyId = technologyId;
  }


  public String getTechnologyName() {
    return technologyName;
  }

  public void setTechnologyName(String technologyName) {
    this.technologyName = technologyName;
  }


  public Integer getWorkingId() {
    return workingId;
  }

  public void setWorkingId(Integer workingId) {
    this.workingId = workingId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
