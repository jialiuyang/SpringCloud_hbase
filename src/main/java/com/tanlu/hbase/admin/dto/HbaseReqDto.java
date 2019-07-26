package com.tanlu.hbase.admin.dto;

import lombok.Data;

@Data
public class HbaseReqDto {

    String tableName;
    String key;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}