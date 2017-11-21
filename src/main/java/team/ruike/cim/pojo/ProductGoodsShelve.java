package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 成品货架表
 *
 * @author 甄立
 * @version 1.0
 */
public class ProductGoodsShelve implements Serializable {

    private static final long serialVersionUID = -5419830913202750841L;
    /**
     * 成品货架 id
     */
    private Integer productGoodsShelveId;
    /**
     * 货架编号
     */
    private String productGoodsShelveNo;
    /**
     * 当前所放菜品外键
     */
    private Integer menuId;
    /**
     * 当前数量
     */
    private Integer menuNumber;
    /**
     * 到期时间
     */
    private Date materielShelfLifeEndDate;
    /**
     * 删除状态
     */
    private Integer status;
    /**
     * 成品仓库区域表外键
     */
    private Integer productWarehouseRegionId;


    public Integer getProductGoodsShelveId() {
        return productGoodsShelveId;
    }

    public void setProductGoodsShelveId(Integer productGoodsShelveId) {
        this.productGoodsShelveId = productGoodsShelveId;
    }


    public String getProductGoodsShelveNo() {
        return productGoodsShelveNo;
    }

    public void setProductGoodsShelveNo(String productGoodsShelveNo) {
        this.productGoodsShelveNo = productGoodsShelveNo;
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


    public Integer getProductWarehouseRegionId() {
        return productWarehouseRegionId;
    }

    public void setProductWarehouseRegionId(Integer productWarehouseRegionId) {
        this.productWarehouseRegionId = productWarehouseRegionId;
    }

}
