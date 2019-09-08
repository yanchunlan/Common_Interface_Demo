package com.example.library;

/**
 * author:  ycl
 * date:  2019/09/08 22:32
 * desc:
 */
public abstract class FunctionHasParamNoResult<P> extends Function {

    public FunctionHasParamNoResult(String functionName) {
        super(functionName);
    }

    public abstract void function(P p);
}
