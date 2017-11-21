package team.ruike.cim.pojo;


import java.io.Serializable;

public class ProductionLine implements Serializable {

  private static final long serialVersionUID = -4399658117392350475L;
  private Integer productionLineId;
  private Integer productionLineNo;
  private Integer productionLineState;
  private String remarks;
  private Integer status;


  public Integer getProductionLineId() {
    return productionLineId;
  }

  public void setProductionLineId(Integer productionLineId) {
    this.productionLineId = productionLineId;
  }


  public Integer getProductionLineNo() {
    return productionLineNo;
  }

  public void setProductionLineNo(Integer productionLineNo) {
    this.productionLineNo = productionLineNo;
  }


  public Integer getProductionLineState() {
    return productionLineState;
  }

  public void setProductionLineState(Integer productionLineState) {
    this.productionLineState = productionLineState;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
