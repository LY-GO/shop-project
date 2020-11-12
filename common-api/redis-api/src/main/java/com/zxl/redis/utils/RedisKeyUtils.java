package com.zxl.redis.utils;

/**
 * 表名:主键名:值:列名:
 * Redis Key的生成工具类
 *
 * @author zhangwei
 */
public class RedisKeyUtils {

    public static String getKeyWithColumn(String name, String pkName, String pkValue, String column) {
        return name
                + ":"
                + pkName
                + ":"
                + pkValue
                + ":"
                + column;
    }

    public static String getKeyWithColumn(String name, String pkValue, String column) {
        return name
                + ":"
                + pkValue
                + ":"
                + column;
    }

    public static String getKeyWithColumn(String name, String column) {
        return name
                + ":"
                + column;
    }
}
