package team.ruike.cim.pojo;


import java.io.Serializable;

public class MaterielTypeLevelB implements Serializable {

  private static final long serialVersionUID = -3632127145415491654L;
  private Integer materielTypeLevelBId;
  private String materielTypeLevelBName;
  private Integer materielTypeLevelAId;
  private Integer status;


  public Integer getMaterielTypeLevelBId() {
    return materielTypeLevelBId;
  }

  public void setMaterielTypeLevelBId(Integer materielTypeLevelBId) {
    this.materielTypeLevelBId = materielTypeLevelBId;
  }


  public String getMaterielTypeLevelBName() {
    return materielTypeLevelBName;
  }

  public void setMaterielTypeLevelBName(String materielTypeLevelBName) {
    this.materielTypeLevelBName = materielTypeLevelBName;
  }


  public Integer getMaterielTypeLevelAId() {
    return materielTypeLevelAId;
  }

  public void setMaterielTypeLevelAId(Integer materielTypeLevelAId) {
    this.materielTypeLevelAId = materielTypeLevelAId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
