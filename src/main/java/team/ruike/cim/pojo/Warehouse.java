package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 仓库表
 *
 * @author 孙天奇
 * @version 1.0
 */
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 3925245141136426037L;
    /**
     * 仓库表id
     */
    private Integer warehouseId;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 仓库管理员用户表外键
     */
    private Integer userId;


    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
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


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
