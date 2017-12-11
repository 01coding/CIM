package team.ruike.cim.service;

import team.ruike.cim.pojo.Function;
import team.ruike.cim.pojo.Jurisdiction;
import team.ruike.cim.pojo.Role;
import team.ruike.cim.util.Pager;

import java.util.List;

/**
 * 管理员业务接口
 * @author 张振国
 * @version 1.0
 */
public interface AdminService {
    /**
     * 获取角色列表
     * @param role 角色对象（参数）
     * @param pager 分页辅助类
     */
    void getRole(Role role, Pager<Role> pager);

    /**
     * 获取所有权限
     * @return 权限集合
     */
    List<Jurisdiction> getJurisdictions();

    /**
     * 获取所有功能集合
     * @return 功能集合
     */
    List<Function> getFunctions();

    /**
     * 新增角色
     * @param role 角色对象
     * @return 是否成功
     */
    boolean addRole(Role role);
}
