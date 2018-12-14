package io.renren.common.utils;


import lombok.Data;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Data
public class Result<T> implements Serializable {
    protected boolean success = false;
    protected int code;
    protected String result;
    protected T data;
    protected final List<String> errors = new ArrayList(0);
    protected final List<String> messages = new ArrayList(0);
    protected Exception exception = null;

    public Result() {
        this.success = true;
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String result) {
        this.success = success;
        this.result = result;
    }

    public Result(boolean success, String result, T data) {
        this.success = success;
        this.result = result;
        this.data = data;
    }


    public String getException() {
        try {
            if (this.exception == null) {
                return null;
            } else {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                this.exception.printStackTrace(pw);
                return sw.toString();
            }
        } catch (Exception var3) {
            return "bad getErrorInfoFromException";
        }
    }
}