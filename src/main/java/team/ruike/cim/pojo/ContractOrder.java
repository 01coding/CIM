package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 合同订单类
 *
 * @author 张振国
 * @version 1.0
 */
public class ContractOrder implements Serializable {

    private static final long serialVersionUID = 7490050891725847244L;
    /**
     * 合同订单id
     */
    private Integer contractOrderId;
    /**
     * 合同订单编号(自动生成)
     */
    private String contractOrderNo;
    /**
     * 合同订单交付时间
     */
    private Date contractOrderEndDate;
    /**
     * 合同订单交付状态(0:未交付,1:已交付)
     */
    private Integer contractOrderState;
    /**
     * 合同订单下单时间
     */
    private Date contractOrderStartDate;
    /**
     * 合同订单所属合同表id
     */
    private Integer orderContractId;
    /**
     * 添加次订单的用户id
     */
    private Integer userId;
    /**
     * 合同订单备注
     */
    private String contractOrderRemarks;
    /**
     * 删除状态
     */
    private Integer status;


    public Integer getContractOrderId() {
        return contractOrderId;
    }

    public void setContractOrderId(Integer contractOrderId) {
        this.contractOrderId = contractOrderId;
    }


    public String getContractOrderNo() {
        return contractOrderNo;
    }

    public void setContractOrderNo(String contractOrderNo) {
        this.contractOrderNo = contractOrderNo;
    }


    public Date getContractOrderEndDate() {
        return contractOrderEndDate;
    }

    public void setContractOrderEndDate(Date contractOrderEndDate) {
        this.contractOrderEndDate = contractOrderEndDate;
    }


    public Integer getContractOrderState() {
        return contractOrderState;
    }

    public void setContractOrderState(Integer contractOrderState) {
        this.contractOrderState = contractOrderState;
    }


    public Date getContractOrderStartDate() {
        return contractOrderStartDate;
    }

    public void setContractOrderStartDate(Date contractOrderStartDate) {
        this.contractOrderStartDate = contractOrderStartDate;
    }


    public Integer getOrderContractId() {
        return orderContractId;
    }

    public void setOrderContractId(Integer orderContractId) {
        this.orderContractId = orderContractId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getContractOrderRemarks() {
        return contractOrderRemarks;
    }

    public void setContractOrderRemarks(String contractOrderRemarks) {
        this.contractOrderRemarks = contractOrderRemarks;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
