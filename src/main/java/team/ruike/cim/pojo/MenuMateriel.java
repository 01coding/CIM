package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 菜谱物料关系
 *
 * @author 甄立
 * @version 1.0
 */
public class MenuMateriel implements Serializable {

    private static final long serialVersionUID = -977872690889448044L;
    /**
     * 菜谱物料关系id
     */
    private Integer menuMaterielId;
    /**
     * 菜谱id
     */
    private Integer menuId;
    /**
     * 物料id
     */
    private Integer materielId;
    /**
     * 类别(0-3)主,辅,配,耗材
     */
    private Integer menuMaterielType;
    /**
     * 删除状态
     */
    private Integer status;


    public Integer getMenuMaterielId() {
        return menuMaterielId;
    }

    public void setMenuMaterielId(Integer menuMaterielId) {
        this.menuMaterielId = menuMaterielId;
    }


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }


    public Integer getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Integer materielId) {
        this.materielId = materielId;
    }


    public Integer getMenuMaterielType() {
        return menuMaterielType;
    }

    public void setMenuMaterielType(Integer menuMaterielType) {
        this.menuMaterielType = menuMaterielType;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
