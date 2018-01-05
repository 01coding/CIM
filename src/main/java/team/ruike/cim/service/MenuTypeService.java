package team.ruike.cim.service;

import team.ruike.cim.pojo.MenuType;

import java.util.List;

/**
 * 菜谱类型
 *
 * @author 甄立
 * @version 1.0
 */
public interface MenuTypeService {

    /**
     * 获取所有菜谱类型
     *
     * @return 菜谱集合
     */
    List<MenuType> selectAllMenuType();

}
