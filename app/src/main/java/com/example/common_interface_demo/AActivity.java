package com.example.common_interface_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.library.FunctionHasParamHasResult;
import com.example.library.FunctionHasParamNoResult;
import com.example.library.FunctionManager;
import com.example.library.FunctionNoParamHasResult;
import com.example.library.FunctionNoParamNoResult;

public class AActivity extends AppCompatActivity {

    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        this.tvShow = (TextView) findViewById(R.id.tvShow);
        initFunction();
    }

    private void initFunction() {
        FunctionManager.getInstance().addFunction(new FunctionNoParamNoResult(FunctionManager.FUNCTIONNOPARAMNORESULT) {
            @Override
            public void function() {
                tvShow.setText("调用了方法1,无参数无返回值类型方法");
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionNoParamHasResult<String>(FunctionManager.FUNCTIONNOPARAMHASRESULT) {
            @Override
            public String function() {
                String msg = "调用了方法2,无参数有返回值类型方法";
                tvShow.setText(msg);
                return msg;
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionHasParamNoResult<String>(FunctionManager.FUNCTIONHASPARAMNORESULT) {
            @Override
            public void function(String s) {
                tvShow.setText("调用了方法3,");
                tvShow.append(s);
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionHasParamHasResult<String, String>(FunctionManager.FUNCTIONHASPARAMHASRESULT) {
            @Override
            public String function(String s) {
                tvShow.setText("调用了方法4,");
                tvShow.setText(s);
                return s;
            }
        });
    }

    public void clickToBActivity(View view) {
        startActivity(new Intent(AActivity.this, BActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FunctionManager.getInstance().removeFunctionNoParamNoResult(FunctionManager.FUNCTIONNOPARAMNORESULT);
        FunctionManager.getInstance().removeFunctionNoParamHasResult(FunctionManager.FUNCTIONNOPARAMHASRESULT);
        FunctionManager.getInstance().removeFunctionHasParamNoResult(FunctionManager.FUNCTIONHASPARAMNORESULT);
        FunctionManager.getInstance().removeFunctionHasParamHasResult(FunctionManager.FUNCTIONHASPARAMHASRESULT);
    }
}
