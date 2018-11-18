package com.zakj.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName：ResultCode
 * Description：统一返回结果代码
 *
 * @author ryh
 * @date 2018/6/23 9:39
 **/
public class ResultCode {

    public static final int SUCCESS = 0;

    public static final int PARAMS_MISSING = 101;
    public static final int PARAMS_ERROR = 102;

    public static final int DB_CONNECTION_ERROR = 201;
    public static final int DB_QUERY_NULL = 202;
    public static final int DB_INVALID_RESULT = 203;
    public static final int DB_CREATE_ERROR = 204;
    public static final int DB_UPDATE_ERROR = 205;
    public static final int DB_OPERATE_ERROR = 206;

    public static final int NOSQL_CONNECTION_ERROR = 301;
    public static final int NOSQL_QUERY_ERROR = 302;
    public static final int NOSQL_QUERY_NULL = 303;
    public static final int NOSQL_INVALID_RESULT = 304;
    public static final int NOSQL_OPT_FAILURE = 305;

    public static final int MQ_CONNECTION_ERROR = 401;
    public static final int MQ_PUSH_MSG_ERROR = 402;
    public static final int MQ_RECEIVE_MSG_ERROR = 403;

    public static final int FILE_NOT_FOUND_ERROR = 501;
    public static final int FILE_READ_ERROR = 502;
    public static final int FILE_WRITE_ERROR = 503;

    public static final int INSIDE_INVOKE_ERROR = 601;
    public static final int INSIDE_INVOKE_RESULT_ERROR = 602;

    public static final int INVALID_TOKEN = 701;
    public static final int AUTHORIZED_ACCESS_ERROR = 702;
    public static final int DATA_ACCESS_ERROR = 703;

    public static final int BUSINESS_LOGICAL = 801;
    public static final int SYSTEM_ERROR = 802;
    public static final int UNKNOWN_ERROR = 803;//系统繁忙，请稍后再试....
    public static final int SERVICE_ERROR = 804;//服务器异常！！


    public static Map<Integer, String> resultCode;
    
    static {
        if (resultCode == null) {
            resultCode = new HashMap<Integer, String>();
        }
        resultCode.put(SUCCESS, "OK");
        resultCode.put(PARAMS_MISSING, "缺少必须参数");
        resultCode.put(PARAMS_ERROR, "参数不合法");
        resultCode.put(DB_CONNECTION_ERROR, "数据库异常");
        resultCode.put(DB_QUERY_NULL, "没有查询到数据");
        resultCode.put(DB_INVALID_RESULT, "不合法的查询结果");
        resultCode.put(DB_CREATE_ERROR, "新增数据失败");
        resultCode.put(DB_UPDATE_ERROR, "更新数据失败");
        resultCode.put(DB_OPERATE_ERROR,"操作错误");
        resultCode.put(NOSQL_CONNECTION_ERROR, "nosql数据库连接失败");
        resultCode.put(NOSQL_QUERY_ERROR, "nosql数据查询异常");
        resultCode.put(NOSQL_QUERY_NULL, "nosql没有查询到数据");
        resultCode.put(NOSQL_INVALID_RESULT, "nosql不合法的查询结果");
        resultCode.put(NOSQL_OPT_FAILURE, "nosql数据操作失败");
        resultCode.put(MQ_CONNECTION_ERROR, "消息总线连接异常");
        resultCode.put(MQ_PUSH_MSG_ERROR, "推送消息失败");
        resultCode.put(MQ_RECEIVE_MSG_ERROR, "接收消息失败");
        resultCode.put(FILE_NOT_FOUND_ERROR, "文件未找到");
        resultCode.put(FILE_READ_ERROR, "读取文件异常");
        resultCode.put(FILE_WRITE_ERROR, "写入文件异常");
        resultCode.put(INSIDE_INVOKE_ERROR, "内部组件调用异常");
        resultCode.put(INSIDE_INVOKE_RESULT_ERROR, "内部组件返回错误");
        resultCode.put(AUTHORIZED_ACCESS_ERROR, "访问权限异常");
        resultCode.put(DATA_ACCESS_ERROR, "数据权限异常");
        resultCode.put(INVALID_TOKEN, "无效令牌");
        resultCode.put(BUSINESS_LOGICAL, "业务逻辑异常");
        resultCode.put(SYSTEM_ERROR, "内部异常");
        resultCode.put(UNKNOWN_ERROR, "系统繁忙，请稍后再试....");
        resultCode.put(SERVICE_ERROR, "服务异常，请稍后再试....");
    }

    public static String getValue(int code) {
        return resultCode.get(code);
    }
}