package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.ruike.cim.pojo.Role;
import team.ruike.cim.service.AdminService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 管理员业务控制器
 * @author 张振国
 * @version 1.0
 */
@Controller()
@RequestMapping("admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @RequestMapping("roles.do")
    public String role(Role role, Pager<Role> pager, HttpServletRequest request){
        pager.setPageSize(5);
        adminService.getRole(role,pager);
        request.setAttribute("pager",pager);
        request.setAttribute("jur",adminService.getJurisdictions());
        request.setAttribute("fun",adminService.getFunctions());
        return "admin/role";
    }
    @ResponseBody
    @RequestMapping("addRole.do")
    public String addRole(Role role){
        return adminService.addRole(role)+"";
    }

    /**
     * 修改角色权限
     * @return 成功标识
     */
    @ResponseBody
    @RequestMapping("updateRoleJurisdiction.do")
    public String updateRoleJurisdiction(Integer[] jurisdictionIds,Integer[] functionIds,Integer roleId){
        boolean flag=false;
        try {
            adminService.updateRoleJurisdiction(jurisdictionIds,functionIds,roleId);
            flag=true;
        }finally {
            return flag+"";
        }
    }
}
