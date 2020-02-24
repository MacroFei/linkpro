package com.xlccc.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 2944177482362464703L;

    private static final Integer SUCCESS_CODE = 0;

    private T data;

    private int code;

    private String msg;

    private boolean status = true;

    public ResponseResult() {
        this.code = SUCCESS_CODE;
        this.msg = "REQUEST SUCCESS";
    }

    public ResponseResult(boolean status, int code) {
        this();
        this.status = status;
        this.code = code;
    }

    public ResponseResult(int code, String msg, boolean status) {
        this();
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public ResponseResult(T data, int code, String msg, boolean status) {
        this();
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public ResponseResult(T data) {
        this();
        this.data = data;
    }
}
