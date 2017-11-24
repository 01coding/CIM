package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面业务控制器
 * @author 张振国
 * @version 1.0
 */
@Controller
public class IndexController {
    /**
     * 跳转主页
     * @return 主页jsp
     */
    @RequestMapping("/index.do")
    public String index(){
        return "index";
    }
}
