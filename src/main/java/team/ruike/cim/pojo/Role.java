package team.ruike.cim.pojo;


import java.io.Serializable;

public class Role implements Serializable {

  private static final long serialVersionUID = 9025386170720563666L;
  private Integer roleId;
  private String roleName;
  private Integer status;


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
