package team.ruike.cim.pojo;


import java.io.Serializable;

public class RoleJurisdiction implements Serializable {

  private static final long serialVersionUID = 3994098330391599594L;
  private Integer roleJurisdictionId;
  private Integer roleId;
  private Integer jurisdictionId;
  private Integer status;

  public Integer getRoleJurisdictionId() {
    return roleJurisdictionId;
  }

  public void setRoleJurisdictionId(Integer roleJurisdictionId) {
    this.roleJurisdictionId = roleJurisdictionId;
  }


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
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
