package com.xlccc.pojo;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Link.p
 * @date 2020/2/9 0:32
 */
@Data
public class Role {
    private Integer rid  ;
    private String rname ;
    private Set<User> users = new HashSet<>();
    private Set<Permission> permissions = new HashSet<>();
}
