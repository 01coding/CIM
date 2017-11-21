package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 临时订单
 *
 * @author 孙天奇
 * @version 1.0
 */
public class TemporaryOrder implements Serializable {

    private static final long serialVersionUID = 2570650295657728928L;
    /**
     * 临时订单id
     */
    private Integer temporaryOrderId;
    /**
     * 订单号(自动生成)
     */
    private String temporaryOrderNo;
    /**
     * 交付时间
     */
    private Date temporaryOrderEndDate;
    /**
     * 状态id外键
     */
    private Integer temporaryOrderStateId;
    /**
     * 下单时间
     */
    private Date temporaryOrderStartDate;
    /**
     * 备注
     */
    private String temporaryOrderRemarks;
    /**
     * 门店用户id外键
     */
    private Integer storeId;
    /**
     * 用户表id(确认人)
     */
    private Integer userId;
    /**
     * 状态
     */
    private Integer status;


    public Integer getTemporaryOrderId() {
        return temporaryOrderId;
    }

    public void setTemporaryOrderId(Integer temporaryOrderId) {
        this.temporaryOrderId = temporaryOrderId;
    }


    public String getTemporaryOrderNo() {
        return temporaryOrderNo;
    }

    public void setTemporaryOrderNo(String temporaryOrderNo) {
        this.temporaryOrderNo = temporaryOrderNo;
    }


    public Date getTemporaryOrderEndDate() {
        return temporaryOrderEndDate;
    }

    public void setTemporaryOrderEndDate(Date temporaryOrderEndDate) {
        this.temporaryOrderEndDate = temporaryOrderEndDate;
    }


    public Integer getTemporaryOrderStateId() {
        return temporaryOrderStateId;
    }

    public void setTemporaryOrderStateId(Integer temporaryOrderStateId) {
        this.temporaryOrderStateId = temporaryOrderStateId;
    }


    public Date getTemporaryOrderStartDate() {
        return temporaryOrderStartDate;
    }

    public void setTemporaryOrderStartDate(Date temporaryOrderStartDate) {
        this.temporaryOrderStartDate = temporaryOrderStartDate;
    }


    public String getTemporaryOrderRemarks() {
        return temporaryOrderRemarks;
    }

    public void setTemporaryOrderRemarks(String temporaryOrderRemarks) {
        this.temporaryOrderRemarks = temporaryOrderRemarks;
    }


    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
