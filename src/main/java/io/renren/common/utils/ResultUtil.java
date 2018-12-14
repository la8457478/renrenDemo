package io.renren.common.utils;

public class ResultUtil {
    public static final String SUCCESS_MSG = "查询成功";
    //错误
    public static final int ERROR_CODE = 5;
    //成功返回
    public static final int OK_CODE = 0;
    //有空数据
    public static final int NULL_CODE = 4;

    public static Result returnFail(String msg, Object data) {
        Result result = new Result();
        result.setData(data);
        result.setCode(ERROR_CODE);
        result.setResult(msg);
        result.setSuccess(false);
        return result;
    }

    public static Result returnFail(String msg) {
        return returnFail(msg, null);
    }

    public static Result returnSuccess(String msg, Object data) {
        Result result = new Result();
        result.setResult(msg);
        result.setCode(OK_CODE);
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public static Result returnSuccess(String msg) {
        return returnSuccess(msg, null);

    }

    public static Result returnQuery(Object data) {
        return returnSuccess(SUCCESS_MSG, data);
    }

    public static Result returnNull(Boolean success, String msg, Object data) {
        Result result = new Result();
        result.setData(data);
        result.setResult(msg);
        result.setSuccess(success);
        return result;
    }

    /**
     * 业务流程出错的空查询
     *
     * @return
     */
    public static Result returnNullEx() {
        return returnNull(false, "业务异常:传入数据为空!", null);
    }

    /**
     * 业务流程出错的空查询
     *
     * @return
     */
    public static Result returnNullEx(Object data) {
        return returnNull(true, "暂无数据", data);
    }
}
