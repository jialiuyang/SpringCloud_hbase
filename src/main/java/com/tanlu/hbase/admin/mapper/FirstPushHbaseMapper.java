package com.tanlu.hbase.admin.mapper;

import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import com.tanlu.hbase.admin.dto.FirstPushHbase;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class FirstPushHbaseMapper implements RowMapper<FirstPushHbase>{

    private static byte[] FAMILY_PUSHDATA = "pushData".getBytes();
    private static byte[] FAMILY_PUSHDATA_FIRSTPUSH= "firstPush".getBytes();

    @Override
    public FirstPushHbase mapRow(Result result, int i) throws Exception {
        FirstPushHbase.BaseInfo baseInfo = new FirstPushHbase.BaseInfo(
                Bytes.toString(result.getValue(FAMILY_PUSHDATA, FAMILY_PUSHDATA_FIRSTPUSH)));
        return new FirstPushHbase(Bytes.toString(result.getRow()), baseInfo);
    }
}
