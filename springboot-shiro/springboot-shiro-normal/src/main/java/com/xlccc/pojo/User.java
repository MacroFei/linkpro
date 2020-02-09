package com.xlccc.pojo;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Link.p
 * @date 2020/2/9 0:30
 */
@Data
public class User {
    private Integer uid ;
    private String uname ;
    private String upwd ;
    private String salt ;
    private Set<Role> roles = new HashSet<>();
}
