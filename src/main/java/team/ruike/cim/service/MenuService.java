package team.ruike.cim.service;

import team.ruike.cim.pojo.Menu;

import java.util.List;

/**
 * 菜谱业务接口
 * @author 张振国
 * @version 1.0
 * @see #getMenuList(Menu)
 */
public interface MenuService {
    /**
     * 获取菜谱列表
     * @param menu 查询条件
     * @return 菜谱集合
     */
    List<Menu> getMenuList(Menu menu);

}
