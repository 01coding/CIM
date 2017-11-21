package team.ruike.cim.pojo;


import java.io.Serializable;

public class MaterielTypeLevelA implements Serializable {

  private static final long serialVersionUID = 5345629873510428301L;
  private Integer materielTypeLevelAId;
  private String materielTypeLevelAName;
  private Integer status;


  public Integer getMaterielTypeLevelAId() {
    return materielTypeLevelAId;
  }

  public void setMaterielTypeLevelAId(Integer materielTypeLevelAId) {
    this.materielTypeLevelAId = materielTypeLevelAId;
  }


  public String getMaterielTypeLevelAName() {
    return materielTypeLevelAName;
  }

  public void setMaterielTypeLevelAName(String materielTypeLevelAName) {
    this.materielTypeLevelAName = materielTypeLevelAName;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
