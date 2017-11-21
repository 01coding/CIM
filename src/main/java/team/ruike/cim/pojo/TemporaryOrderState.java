package team.ruike.cim.pojo;


import java.io.Serializable;

public class TemporaryOrderState implements Serializable {
  private static final long serialVersionUID = -358147864562847230L;
  private Integer temporaryOrderStateId;
  private String temporaryOrderStateName;
  private Integer status;


  public Integer getTemporaryOrderStateId() {
    return temporaryOrderStateId;
  }

  public void setTemporaryOrderStateId(Integer temporaryOrderStateId) {
    this.temporaryOrderStateId = temporaryOrderStateId;
  }


  public String getTemporaryOrderStateName() {
    return temporaryOrderStateName;
  }

  public void setTemporaryOrderStateName(String temporaryOrderStateName) {
    this.temporaryOrderStateName = temporaryOrderStateName;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
