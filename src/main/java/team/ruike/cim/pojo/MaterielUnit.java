package team.ruike.cim.pojo;


import java.io.Serializable;

public class MaterielUnit implements Serializable {

  private static final long serialVersionUID = -5578289551297900321L;
  private Integer materielUnitId;
  private String materielUnitName;
  private Integer status;


  public Integer getMaterielUnitId() {
    return materielUnitId;
  }

  public void setMaterielUnitId(Integer materielUnitId) {
    this.materielUnitId = materielUnitId;
  }


  public String getMaterielUnitName() {
    return materielUnitName;
  }

  public void setMaterielUnitName(String materielUnitName) {
    this.materielUnitName = materielUnitName;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
