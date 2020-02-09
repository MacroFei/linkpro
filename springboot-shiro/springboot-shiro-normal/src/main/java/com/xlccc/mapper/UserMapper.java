package com.xlccc.mapper;

import com.xlccc.pojo.User;

import java.util.List;

/**
 * @author Link.p
 * @date 2020/2/9 0:45
 */

public interface UserMapper {
    User findUserByName(String name) ;

    User findUserJustByName(String name) ;

    List<String> selectPermissionByUserId(Integer id) ;
}
