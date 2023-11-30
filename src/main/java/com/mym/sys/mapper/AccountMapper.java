package com.mym.sys.mapper;

import org.apache.ibatis.annotations.Param;


public interface AccountMapper {

    //转入方法
    public void transferIn(@Param("name") String name, @Param("money") double money);

    //转出方法
    public void transferOut(@Param("name") String name, @Param("money") double money);
}
