package com.example.library;

import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;


/**
 * author:  ycl
 * date:  2019/09/08 22:34
 * desc:
 */
public class FunctionManager {
    private static final String TAG = "FunctionManager";

    public static final String FUNCTIONNOPARAMNORESULT = "FunctionNoParamNoResult";
    public static final String FUNCTIONNOPARAMHASRESULT = "FunctionNoParamHasResult";
    public static final String FUNCTIONHASPARAMNORESULT = "FunctionHasParamNoResult";
    public static final String FUNCTIONHASPARAMHASRESULT = "FunctionHasParamHasResult";

    private volatile static FunctionManager sInstance;
    private Map<String, FunctionNoParamNoResult> mFunctionNoParamNoResultMap;
    private Map<String, FunctionNoParamHasResult> mFunctionNoParamHasResultMap;
    private Map<String, FunctionHasParamNoResult> mFunctionHasParamNoResultMap;
    private Map<String, FunctionHasParamHasResult> mFunctionHasParamHasResultMap;

    private FunctionManager() {
        mFunctionNoParamNoResultMap = new HashMap<>();
        mFunctionNoParamHasResultMap = new HashMap<>();
        mFunctionHasParamNoResultMap = new HashMap<>();
        mFunctionHasParamHasResultMap = new HashMap<>();
    }

    public static FunctionManager getInstance() {
        if (sInstance == null) {
            synchronized (FunctionManager.class) {
                if (sInstance == null) {
                    sInstance = new FunctionManager();
                }
            }
        }
        return sInstance;
    }

    public void addFunction(FunctionNoParamNoResult function) {
        mFunctionNoParamNoResultMap.put(function.functionName, function);
    }

    public void invokeFunction(String functionMame) {
        if (TextUtils.isEmpty(functionMame)) {
            return;
        }
        if (mFunctionNoParamNoResultMap != null) {
            FunctionNoParamNoResult f = mFunctionNoParamNoResultMap.get(functionMame);
            if (f != null) {
                f.function();
            } else {
                Log.i(TAG, "invorkFunction: 没有找到方法");
            }
        }
    }

    public void addFunction(FunctionNoParamHasResult function) {
        mFunctionNoParamHasResultMap.put(function.functionName, function);
    }

    public <T> T invokeFunction(String functionMame, Class<T> t) {
        if (TextUtils.isEmpty(functionMame)) {
            return null;
        }
        if (mFunctionNoParamHasResultMap != null) {
            FunctionNoParamHasResult f = mFunctionNoParamHasResultMap.get(functionMame);
            if (f != null) {
                if (t != null) {
                    return t.cast(f.function());
                }
            } else {
                Log.i(TAG, "invorkFunction: 没有找到方法");
            }
        }
        return null;
    }


    public void addFunction(FunctionHasParamNoResult function) {
        mFunctionHasParamNoResultMap.put(function.functionName, function);
    }

    public <P> void invokeFunction(String functionMame, P p) {
        if (TextUtils.isEmpty(functionMame)) {
            return;
        }
        if (mFunctionHasParamNoResultMap != null) {
            FunctionHasParamNoResult f = mFunctionHasParamNoResultMap.get(functionMame);
            if (f != null) {
                f.function(p);
            } else {
                Log.i(TAG, "invorkFunction: 没有找到方法");
            }
        }
    }

    public void addFunction(FunctionHasParamHasResult function) {
        mFunctionHasParamHasResultMap.put(function.functionName, function);
    }

    public <T, P> T invokeFunction(String functionMame, P p, Class<T> t) {
        if (TextUtils.isEmpty(functionMame)) {
            return null;
        }
        if (mFunctionHasParamHasResultMap != null) {
            FunctionHasParamHasResult f = mFunctionHasParamHasResultMap.get(functionMame);
            if (f != null) {
                if (t != null) {
                    return t.cast(f.function(p));
                }
            } else {
                Log.i(TAG, "invorkFunction: 没有找到方法");
            }
        }
        return null;
    }

    public void removeFunctionNoParamNoResult(String functionName) {
        mFunctionNoParamNoResultMap.remove(functionName);
    }

    public void removeFunctionNoParamHasResult(String functionName) {
        mFunctionNoParamHasResultMap.remove(functionName);
    }

    public void removeFunctionHasParamNoResult(String functionName) {
        mFunctionHasParamNoResultMap.remove(functionName);
    }

    public void removeFunctionHasParamHasResult(String functionName) {
        mFunctionHasParamHasResultMap.remove(functionName);
    }

    public void removeAll(String functionName) {
        mFunctionNoParamNoResultMap.remove(functionName);
        mFunctionNoParamHasResultMap.remove(functionName);
        mFunctionHasParamNoResultMap.remove(functionName);
        mFunctionHasParamHasResultMap.remove(functionName);
    }

    public void removeAll() {
        mFunctionNoParamNoResultMap.clear();
        mFunctionNoParamHasResultMap.clear();
        mFunctionHasParamNoResultMap.clear();
        mFunctionHasParamHasResultMap.clear();
    }
}
