package team.ruike.cim.pojo;


import java.io.Serializable;
/**
 *用户角色类
 * @author 王傲祥
 * @version 1.0
 */
public class Role implements Serializable {

  private static final long serialVersionUID = 9025386170720563666L;
  /**
   * 用户角色ID
   */
  private Integer roleId;
  /**
   *用户名称
   */
  private String roleName;
  /**
   * 删除状态
   */
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
