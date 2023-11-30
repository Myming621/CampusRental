package com.mym.sys.service;

import com.mym.sys.domain.RoleVo;
import com.mym.sys.utils.DataGridView;


public interface IRoleService {
    DataGridView queryAllRole(RoleVo roleVo);

    void addRole(RoleVo roleVo);

    void updateRole(RoleVo roleVo);

    void deleteRole(Integer roleid);

    void deleteBatchRole(Integer[] ids);

    DataGridView initRoleMenuTreeJson(Integer roleid);

    void saveRoleMenu(RoleVo roleVo);
}
