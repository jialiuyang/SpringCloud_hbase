package com.tanlu.hbase.admin.dto;

import lombok.Data;

@Data
public class FirstPushHbase {

    /**
     * 行键
     */
    private String row;
    /**
     * 基础信息
     */
    private BaseInfo baseInfo;




    public FirstPushHbase() {
    }

    public FirstPushHbase(String row, BaseInfo baseInfo) {
        this.row = row;
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "row='" + row + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    /**
     * 使用内部类表示 b 列簇 基础信息
     */
    public static class BaseInfo {
        /**
         * 名称
         */
        private String kfkPush;
        public BaseInfo(){

        }
        public BaseInfo(String kfkPush){
            this.kfkPush = kfkPush;
        }

        public String getKfkPush() {
            return kfkPush;
        }

        public void setKfkPush(String kfkPush) {
            this.kfkPush = kfkPush;
        }
    }

}