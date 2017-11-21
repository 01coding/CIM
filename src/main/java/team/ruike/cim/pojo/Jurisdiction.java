package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 权限
 *
 * @author 甄立
 * @version 1.0
 */
public class Jurisdiction implements Serializable {

    private static final long serialVersionUID = 4347802888183585718L;
    /**
     * 权限id
     */
    private Integer jurisdictionId;
    /**
     * 权限名称
     */
    private String jurisdictionName;
    /**
     * 权限url
     */
    private String jurisdictionUrl;
    /**
     * 删除状态
     */
    private Integer status;


    public Integer getJurisdictionId() {
        return jurisdictionId;
    }

    public void setJurisdictionId(Integer jurisdictionId) {
        this.jurisdictionId = jurisdictionId;
    }


    public String getJurisdictionName() {
        return jurisdictionName;
    }

    public void setJurisdictionName(String jurisdictionName) {
        this.jurisdictionName = jurisdictionName;
    }


    public String getJurisdictionUrl() {
        return jurisdictionUrl;
    }

    public void setJurisdictionUrl(String jurisdictionUrl) {
        this.jurisdictionUrl = jurisdictionUrl;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
