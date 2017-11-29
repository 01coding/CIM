package team.ruike.cim.service;

import team.ruike.cim.pojo.Menu;
import team.ruike.cim.pojo.MenuState;
import team.ruike.cim.pojo.MenuType;
import team.ruike.cim.util.Pager;

import java.util.List;

/**
 * 菜谱业务接口
 * @author 张振国
 * @version 1.0
 * @see #getMenuList(Menu, Pager)
 * @see #getMenuStateList()
 * @see #getMenuTypeList()
 */
public interface MenuService {
    /**
     * 获取菜谱列表
     * @param menu 查询条件
     * @param pager 分页辅助类
     */
    void getMenuList(Menu menu, Pager<Menu> pager);

    /**
     * 获取所有状态集合
     * @return 状态集合
     */
    List<MenuState> getMenuStateList();

    /**
     * 获取菜品类型集合
     * @return 类型集合
     */
    List<MenuType> getMenuTypeList();
}
