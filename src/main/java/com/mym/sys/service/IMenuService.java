package com.mym.sys.service;

import com.mym.sys.domain.Menu;
import com.mym.sys.domain.MenuVo;
import com.mym.sys.utils.DataGridView;

import java.util.List;


public interface IMenuService {
    List<Menu> queryAllMenuForList(MenuVo menuVo);

    DataGridView queryAllMenu(MenuVo menuVo);

    void addMenu(MenuVo menuVo);

    void updateMenu(MenuVo menuVo);

    Integer queryMenuByPid(Integer id);

    void deleteMenu(MenuVo menuVo);
}
