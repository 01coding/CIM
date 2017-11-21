package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class SupplierContract implements Serializable {

  private static final long serialVersionUID = -3915708383686678545L;
  private Integer supplierContractId;
  private String supplierContractName;
  private Date supplierContractDate;
  private String supplierContractImage;
  private Integer status;
  private Integer supplierId;


  public Integer getSupplierContractId() {
    return supplierContractId;
  }

  public void setSupplierContractId(Integer supplierContractId) {
    this.supplierContractId = supplierContractId;
  }


  public String getSupplierContractName() {
    return supplierContractName;
  }

  public void setSupplierContractName(String supplierContractName) {
    this.supplierContractName = supplierContractName;
  }


  public Date getSupplierContractDate() {
    return supplierContractDate;
  }

  public void setSupplierContractDate(Date supplierContractDate) {
    this.supplierContractDate = supplierContractDate;
  }


  public String getSupplierContractImage() {
    return supplierContractImage;
  }

  public void setSupplierContractImage(String supplierContractImage) {
    this.supplierContractImage = supplierContractImage;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }

}
