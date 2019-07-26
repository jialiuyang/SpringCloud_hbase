package com.tanlu.hbase.admin.controller;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.tanlu.hbase.admin.mapper.FirstPushHbaseMapper;
import com.tanlu.hbase.admin.mapper.SecondPushHbaseMapper;
import com.tanlu.hbase.admin.service.HbaseService;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api")
public class HbaseTestController {

    private static Logger logger = LoggerFactory.getLogger(HbaseTestController.class);

    ExecutorService executorService = Executors.newFixedThreadPool(100);

    @Autowired
    private HbaseService hbaseService;

    private String tableName = "secondtable";

@Autowired
private HbaseTemplate hbaseTemplate;
    @PostMapping("/hbaseTest")
    public String  hbaseTest() {
        logger.info("进入测试+++");
        logger.info("进入测试+++{}"+ "111");
     System.out.println("22222begin"  );
     String key = "102019022214371506841824";
//        String key = "201903071210252975";
        List<Mutation> datas = new ArrayList<>();
        Put put = new Put(Bytes.toBytes(key));//主键不同 row_key
        String className = "secondPush";
        String properties = "pushData";
       StringBuffer sb = new StringBuffer("222111111111151651651222");
         put.addColumn(Bytes.toBytes(className), Bytes.toBytes(properties), Bytes.toBytes(sb.toString()));
        //put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("age"), Bytes.toBytes("19"));
        datas.add(put);
        List<Mutation> results = hbaseService.saveOrUpdate(tableName, datas);
        System.out.println("11111111111" + results);
       System.out.println("11111111" + hbaseTemplate.get(tableName, key, new FirstPushHbaseMapper()).getBaseInfo().getKfkPush());
        System.out.println("2222222222" + hbaseTemplate.get(tableName, key, new SecondPushHbaseMapper()).getBaseInfo().getKfkPush());

        System.out.println("2222222222" + hbaseTemplate.get(tableName, key, new SecondPushHbaseMapper()).getBaseInfo().getKfkPush());

        return   "SUCCESS";
    }
}