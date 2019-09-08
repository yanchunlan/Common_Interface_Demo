package com.example.library;

/**
 * author:  ycl
 * date:  2019/09/08 22:32
 * desc:
 */
public abstract class FunctionNoParamHasResult<T> extends Function {

    public FunctionNoParamHasResult(String functionName) {
        super(functionName);
    }

    public abstract T function();
}
