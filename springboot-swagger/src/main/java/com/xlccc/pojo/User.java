package com.xlccc.pojo;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "用户实体")
public class User {

    private Long Id ;
    private String name ;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
