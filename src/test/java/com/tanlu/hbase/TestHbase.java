package com.tanlu.hbase;


import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.tanlu.hbase.admin.service.HbaseService;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TestHbase {
    @Autowired
    HbaseService hbaseService;
    @Autowired
    private HbaseTemplate hbaseTemplate;
    private String tableName = "testTable2";
    @Test
    public void test(){
        System.out.println("22222beg" );
        List<Mutation> datas = new ArrayList<>();
        Put put = new Put(Bytes.toBytes("root"));
        put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("name"), Bytes.toBytes("imooc"));
        put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("age"), Bytes.toBytes("18"));
        put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("sex"), Bytes.toBytes("m"));
        put.addColumn(Bytes.toBytes("o"), Bytes.toBytes("phone"), Bytes.toBytes("123456789"));
        put.addColumn(Bytes.toBytes("o"), Bytes.toBytes("address"), Bytes.toBytes("北京市朝阳区"));
        datas.add(put);
        List<Mutation> results = hbaseService.saveOrUpdate(tableName, datas);
       // hbaseTemplate.saveOrUpdates(tableName,datas);
        System.out.println("11111111111" + datas);
//        System.out.println("!!!!!!!!!!!" + .toJSONString(hbaseService.findByRow("xjbtfirstpush","xjbt190108116463")));
    }
}
