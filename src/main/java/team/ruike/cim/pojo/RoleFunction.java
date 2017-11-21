package team.ruike.cim.pojo;


import java.io.Serializable;

public class RoleFunction implements Serializable {

  private static final long serialVersionUID = 2387468227803471501L;
  private Integer roleFunctionId;
  private Integer roleId;
  private Integer functionId;
  private Integer status;


  public Integer getRoleFunctionId() {
    return roleFunctionId;
  }

  public void setRoleFunctionId(Integer roleFunctionId) {
    this.roleFunctionId = roleFunctionId;
  }


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  public Integer getFunctionId() {
    return functionId;
  }

  public void setFunctionId(Integer functionId) {
    this.functionId = functionId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
