package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 菜品制作流程
 *
 * @author 甄立
 * @version 1.0
 */
public class MenuFlow implements Serializable {

    private static final long serialVersionUID = 8303793683156656287L;
    /**
     * 菜品制作流程 id
     */
    private Integer menuFlowId;
    /**
     * 菜物关系表id外键
     */
    private Integer menuMaterielId;
    /**
     * 工序表id外键
     */
    private Integer workingId;
    /**
     * 工艺表id外键
     */
    private Integer technologyId;
    /**
     * 描述
     */
    private String menuFlowDescribe;
    /**
     * 耗时(H)
     */
    private Integer menuFlowHour;
    /**
     * 图片路径
     */
    private String menuFlowImage;
    /**
     * 删除状态
     */
    private Integer status;


    public Integer getMenuFlowId() {
        return menuFlowId;
    }

    public void setMenuFlowId(Integer menuFlowId) {
        this.menuFlowId = menuFlowId;
    }


    public Integer getMenuMaterielId() {
        return menuMaterielId;
    }

    public void setMenuMaterielId(Integer menuMaterielId) {
        this.menuMaterielId = menuMaterielId;
    }


    public Integer getWorkingId() {
        return workingId;
    }

    public void setWorkingId(Integer workingId) {
        this.workingId = workingId;
    }


    public Integer getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Integer technologyId) {
        this.technologyId = technologyId;
    }


    public String getMenuFlowDescribe() {
        return menuFlowDescribe;
    }

    public void setMenuFlowDescribe(String menuFlowDescribe) {
        this.menuFlowDescribe = menuFlowDescribe;
    }


    public Integer getMenuFlowHour() {
        return menuFlowHour;
    }

    public void setMenuFlowHour(Integer menuFlowHour) {
        this.menuFlowHour = menuFlowHour;
    }


    public String getMenuFlowImage() {
        return menuFlowImage;
    }

    public void setMenuFlowImage(String menuFlowImage) {
        this.menuFlowImage = menuFlowImage;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
