package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 货架表
 *
 * @author 甄立
 * @version 1.0
 */
public class GoodsShelve implements Serializable {

    private static final long serialVersionUID = 5857865848760569834L;
    /**
     * 货架表id
     */
    private Integer goodsShelveId;
    /**
     * 货架编号
     */
    private String goodsShelveNo;
    /**
     * 当前所放物料外键
     */
    private Integer materielId;
    /**
     * 当前数量
     */
    private Integer materielNumber;
    /**
     * 到期时间
     */
    private Date materielShelfLifeEndDate;
    /**
     * 删除状态
     */
    private Integer status;
    /**
     * 仓库区域表外键
     */
    private Integer warehouseRegionId;


    public Integer getGoodsShelveId() {
        return goodsShelveId;
    }

    public void setGoodsShelveId(Integer goodsShelveId) {
        this.goodsShelveId = goodsShelveId;
    }


    public String getGoodsShelveNo() {
        return goodsShelveNo;
    }

    public void setGoodsShelveNo(String goodsShelveNo) {
        this.goodsShelveNo = goodsShelveNo;
    }


    public Integer getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Integer materielId) {
        this.materielId = materielId;
    }


    public Integer getMaterielNumber() {
        return materielNumber;
    }

    public void setMaterielNumber(Integer materielNumber) {
        this.materielNumber = materielNumber;
    }


    public Date getMaterielShelfLifeEndDate() {
        return materielShelfLifeEndDate;
    }

    public void setMaterielShelfLifeEndDate(Date materielShelfLifeEndDate) {
        this.materielShelfLifeEndDate = materielShelfLifeEndDate;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getWarehouseRegionId() {
        return warehouseRegionId;
    }

    public void setWarehouseRegionId(Integer warehouseRegionId) {
        this.warehouseRegionId = warehouseRegionId;
    }

}
