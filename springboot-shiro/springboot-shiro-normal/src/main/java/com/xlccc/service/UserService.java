package com.xlccc.service;

import com.xlccc.pojo.User;

import java.util.List;

/**
 * @author Link.p
 * @date 2020/2/9 0:48
 */
public interface UserService {
    User findUserByName(String name) ;

    User findUserJustByName(String name) ;

    List<String> selectPermissionByUserId(Integer id) ;

}
