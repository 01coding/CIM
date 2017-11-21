package team.ruike.cim.pojo;


import java.io.Serializable;

public class UserRole implements Serializable {

  private static final long serialVersionUID = -4091322812186412892L;
  private Integer userRoleId;
  private Integer roleId;
  private Integer userId;
  private Integer status;


  public Integer getUserRoleId() {
    return userRoleId;
  }

  public void setUserRoleId(Integer userRoleId) {
    this.userRoleId = userRoleId;
  }


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
