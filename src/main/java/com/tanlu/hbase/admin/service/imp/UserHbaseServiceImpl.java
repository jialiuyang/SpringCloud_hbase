package com.tanlu.hbase.admin.service.imp;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.tanlu.hbase.admin.dto.FirstPushHbase;
import com.tanlu.hbase.admin.mapper.FirstPushHbaseMapper;
import com.tanlu.hbase.admin.service.HbaseService;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <br>
 * 标题: 用户服务<br>
 * 描述: 用户服务<br>
 */
@Service
public class UserHbaseServiceImpl implements HbaseService<FirstPushHbase> {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Override
    public String findByRow(String tableName, String row) {
        FirstPushHbase user =     hbaseTemplate.get(tableName, row, new FirstPushHbaseMapper());
        String  data = null;
        if(user!=null ){
            FirstPushHbase.BaseInfo baseInfo = user.getBaseInfo();
            data = baseInfo.getKfkPush();
        }
        return data;
    }

    @Override
    public List<FirstPushHbase> findByStartEndRow(String tableName, String startRow, String endRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(endRow));
        return hbaseTemplate.find(tableName, scan,new  FirstPushHbaseMapper());
    }

    @Override
    public List<Mutation> saveOrUpdate(String tableName, List<Mutation> datas) {
        hbaseTemplate.saveOrUpdates(tableName, datas);
        return datas;
    }
}