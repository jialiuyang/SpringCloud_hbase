package com.tanlu.hbase.admin.mapper;

import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import com.tanlu.hbase.admin.dto.SecondPushHbase;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class SecondPushHbaseMapper implements RowMapper<SecondPushHbase>{

    private static byte[] FAMILY_PUSHDATA = "pushData".getBytes();
    private static byte[] FAMILY_PUSHDATA_FIRSTPUSH= "secondPush".getBytes();

    @Override
    public SecondPushHbase mapRow(Result result, int i) throws Exception {
        SecondPushHbase.BaseInfo baseInfo = new SecondPushHbase.BaseInfo(
                Bytes.toString(result.getValue(FAMILY_PUSHDATA, FAMILY_PUSHDATA_FIRSTPUSH)));
        return new SecondPushHbase(Bytes.toString(result.getRow()), baseInfo);
    }
}
