package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 供应商合同表
 *
 * @author 孙天奇
 * @version 1.0
 */
public class SupplierContract implements Serializable {

    private static final long serialVersionUID = -3915708383686678545L;
    /**
     * 供应商合同表id
     */
    private Integer supplierContractId;
    /**
     * 合同名称
     */
    private String supplierContractName;
    /**
     * 签订时间
     */
    private Date supplierContractDate;
    /**
     * 合同图片路径
     */
    private String supplierContractImage;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 供应商外键
     */
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
