package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 合同订单项
 *
 * @author 张振国
 * @version 1.0
 */
public class ContractOrderTerm implements Serializable {
    private static final long serialVersionUID = 5130589157821751599L;
    /**
     * 合同订单项id
     */
    private Integer contractOrderTermId;
    /**
     * 菜品id
     */
    private Integer menuId;
    /**
     * 菜品数量
     */
    private Integer menuNumber;
    /**
     * 完成数量
     */
    private Integer completeNumber;
    /**
     * 完成状态(0:未,1:已)
     */
    private Integer contractOrderTermState;
    /**
     * 产品批次(自动生成)
     */
    private String productBatch;
    /**
     * 合同订单Id
     */
    private Integer contractOrderId;
    /**
     * 删除状态
     */
    private Integer status;


    public Integer getContractOrderTermId() {
        return contractOrderTermId;
    }

    public void setContractOrderTermId(Integer contractOrderTermId) {
        this.contractOrderTermId = contractOrderTermId;
    }


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }


    public Integer getMenuNumber() {
        return menuNumber;
    }

    public void setMenuNumber(Integer menuNumber) {
        this.menuNumber = menuNumber;
    }


    public Integer getCompleteNumber() {
        return completeNumber;
    }

    public void setCompleteNumber(Integer completeNumber) {
        this.completeNumber = completeNumber;
    }


    public Integer getContractOrderTermState() {
        return contractOrderTermState;
    }

    public void setContractOrderTermState(Integer contractOrderTermState) {
        this.contractOrderTermState = contractOrderTermState;
    }


    public String getProductBatch() {
        return productBatch;
    }

    public void setProductBatch(String productBatch) {
        this.productBatch = productBatch;
    }


    public Integer getContractOrderId() {
        return contractOrderId;
    }

    public void setContractOrderId(Integer contractOrderId) {
        this.contractOrderId = contractOrderId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
