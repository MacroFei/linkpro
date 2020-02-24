package com.xlccc.common.enums;

public enum ResponseCode {
    FAILED(400, "请求失败"),
    ERROR(500, "应用服务不知名错误"),


    RESOURCE_NOT_EXIST(1001, "资源不存在"),
    INSUFFICIENT_RESOURCE(1002, "资源不符合规范"),
    DUPLICATEKEY_ERROR_CODE(1003, "数据库中已存在该记录"),


    PARAM_ERROR_CODE(2001, "参数不合规"),
    NETWORK_ERROR(9999, "网络错误，待会重试");;


    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
