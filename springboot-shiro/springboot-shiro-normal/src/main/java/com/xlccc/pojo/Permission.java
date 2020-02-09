package com.xlccc.pojo;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Link.p
 * @date 2020/2/9 0:28
 */
@Data
public class Permission {
    private Integer pid ;
    private String permission;
    private Set<Role> roles = new HashSet<>();
}
