package com.mym.sys.service;

import com.mym.sys.domain.User;
import com.mym.sys.domain.UserVo;
import com.mym.sys.utils.DataGridView;


public interface IUserService {
    User login(UserVo userVo);

    DataGridView queryAllUser(UserVo userVo);

    void addUser(UserVo userVo);

    void updateUser(UserVo userVo);

    void deleteUser(Integer userid);

    void deleteBatchUser(UserVo userVo);

    void resetUserPwd(Integer userid);

    DataGridView queryUserRole(Integer userid);

    void saveUserRole(UserVo userVo);
}
