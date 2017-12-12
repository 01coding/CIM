package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.*;
import team.ruike.cim.pojo.*;
import team.ruike.cim.service.AdminService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员业务实现类
 * @author 张振国
 * @version 1.0
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private RoleDao roleDao;
    @Resource
    private JurisdictionDao jurisdictionDao;
    @Resource
    private FunctionDao functionDao;
    @Resource
    private RoleFunctionDao roleFunctionDao;
    @Resource
    private RoleJurisdictionDao roleJurisdictionDao;
    /**
     * 获取角色列表
     * @param role 角色对象（参数）
     * @param pager 分页辅助类
     */
    @Override
    public void getRole(Role role, Pager<Role> pager) {
        pager.setTotalRecord(roleDao.selectCount(role));
        List<Role> roles = roleDao.select(role, (pager.getCurrentPage() - 1) * pager.getPageSize(), pager.getPageSize());
        pager.setList(roles);
    }

    /**
     * 获取所有权限
     * @return 权限集合
     */
    @Override
    public List<Jurisdiction> getJurisdictions() {
        return jurisdictionDao.select(new Jurisdiction(),0,99);
    }
    /**
     * 获取所有功能集合
     * @return 功能集合
     */
    @Override
    public List<Function> getFunctions() {
        return functionDao.select(new Function(),0,99);
    }

    /**
     * 新增角色
     * @param role 角色对象
     * @return 是否成功
     */
    @Override
    public boolean addRole(Role role) {
        return roleDao.add(role)==1;
    }

    /**
     * 更新角色权限
     * @param jurisdictionIds 权限id数组
     * @param functionIds 功能id数组
     * @param roleId 角色id
     * @return 是否成功
     */
    @Override
    public boolean updateRoleJurisdiction(Integer[] jurisdictionIds, Integer[] functionIds, Integer roleId) {
        roleFunctionDao.delete(roleId);
        roleJurisdictionDao.delete(roleId);
        for (Integer jurisdictionId : jurisdictionIds) {
            roleJurisdictionDao.add(new RoleJurisdiction(roleId,jurisdictionId));
        }
        for (Integer functionId : functionIds) {
            roleFunctionDao.add(new RoleFunction(roleId,functionId));
        }
        return true;
    }
}
