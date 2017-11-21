package team.ruike.cim.pojo;


import java.io.Serializable;
/**
 *用户功能类
 * @author 王傲祥
 * @version 1.0
 */
public class RoleFunction implements Serializable {

  private static final long serialVersionUID = 2387468227803471501L;
  /**
   * 用户功能ID
   */
  private Integer roleFunctionId;
  /**
   * 用户ID
   */
  private Integer roleId;
  /**
   * 功能ID
   */
  private Integer functionId;
  /**
   * 删除状态
   */
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
