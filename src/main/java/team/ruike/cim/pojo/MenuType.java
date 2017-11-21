package team.ruike.cim.pojo;


import java.io.Serializable;

public class MenuType implements Serializable {

  private static final long serialVersionUID = 2647922421561759648L;
  private Integer menuTypeId;
  private String menuTypeName;
  private String menuTypeNo;
  private Integer status;


  public Integer getMenuTypeId() {
    return menuTypeId;
  }

  public void setMenuTypeId(Integer menuTypeId) {
    this.menuTypeId = menuTypeId;
  }


  public String getMenuTypeName() {
    return menuTypeName;
  }

  public void setMenuTypeName(String menuTypeName) {
    this.menuTypeName = menuTypeName;
  }


  public String getMenuTypeNo() {
    return menuTypeNo;
  }

  public void setMenuTypeNo(String menuTypeNo) {
    this.menuTypeNo = menuTypeNo;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
