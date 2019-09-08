package com.example.library;

/**
 * author:  ycl
 * date:  2019/09/08 22:32
 * desc:
 */
public abstract class FunctionHasParamHasResult<T,P> extends Function {

    public FunctionHasParamHasResult(String functionName) {
        super(functionName);
    }

    public abstract T function(P p);
}
