package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
