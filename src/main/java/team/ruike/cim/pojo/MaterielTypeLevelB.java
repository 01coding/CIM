package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 物料二级类别
 *
 * @author 甄立
 * @version 1.0
 */
public class MaterielTypeLevelB implements Serializable {

    private static final long serialVersionUID = -3632127145415491654L;
    /**
     * 物料二级类别
     */
    private Integer materielTypeLevelBId;
    /**
     * 名称
     */
    private String materielTypeLevelBName;
    /**
     * 一级分类id
     */
    private Integer materielTypeLevelAId;
    private Integer status;


    public Integer getMaterielTypeLevelBId() {
        return materielTypeLevelBId;
    }

    public void setMaterielTypeLevelBId(Integer materielTypeLevelBId) {
        this.materielTypeLevelBId = materielTypeLevelBId;
    }


    public String getMaterielTypeLevelBName() {
        return materielTypeLevelBName;
    }

    public void setMaterielTypeLevelBName(String materielTypeLevelBName) {
        this.materielTypeLevelBName = materielTypeLevelBName;
    }


    public Integer getMaterielTypeLevelAId() {
        return materielTypeLevelAId;
    }

    public void setMaterielTypeLevelAId(Integer materielTypeLevelAId) {
        this.materielTypeLevelAId = materielTypeLevelAId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
