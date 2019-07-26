package com.tanlu.hbase.admin.dto;

import lombok.Data;

@Data
public class ResultDto {

    private boolean success;

    private String code;

    private Object data;

    private String message;


    public static ResultDto success() {
        ResultDto result = new ResultDto();
        result.setSuccess(true);
        result.setCode("200");
        return result;
    }

    public static ResultDto success(Object data) {
        ResultDto result = new ResultDto();
        result.setSuccess(true);
        result.setCode("200");
        result.setData(data);
        return result;
    }

    public static ResultDto fail(String message) {
        ResultDto result = new ResultDto();
        result.setSuccess(false);
        result.setCode("9999");
        result.setMessage(message);
        return result;
    }
}