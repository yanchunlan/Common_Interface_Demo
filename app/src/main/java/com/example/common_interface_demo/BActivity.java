package com.example.common_interface_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.library.FunctionManager;

public class BActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFuncton01;
    private Button btnFuncton02;
    private Button btnFuncton03;
    private Button btnFuncton04;
    private Button btnCloseB;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        initView();
    }

    private void initView() {
        btnFuncton01 = (Button) findViewById(R.id.btnFuncton01);
        btnFuncton02 = (Button) findViewById(R.id.btnFuncton02);
        btnFuncton03 = (Button) findViewById(R.id.btnFuncton03);
        btnFuncton04 = (Button) findViewById(R.id.btnFuncton04);
        btnCloseB = (Button) findViewById(R.id.btnCloseB);
        tvShow = (TextView) findViewById(R.id.tvShow);

        btnFuncton01.setOnClickListener(this);
        btnFuncton02.setOnClickListener(this);
        btnFuncton03.setOnClickListener(this);
        btnFuncton04.setOnClickListener(this);
        btnCloseB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFuncton01:
                FunctionManager.getInstance().invokeFunction(FunctionManager.FUNCTIONNOPARAMNORESULT);
                tvShow.setText("调用了方法1");
                break;
            case R.id.btnFuncton02:
                FunctionManager.getInstance().invokeFunction(FunctionManager.FUNCTIONNOPARAMHASRESULT, String.class);
                tvShow.setText("调用了方法2");
                break;
            case R.id.btnFuncton03:
                FunctionManager.getInstance().invokeFunction(FunctionManager.FUNCTIONHASPARAMNORESULT, "调用了方法3,有参数无返回值类型方法");
                tvShow.setText("调用了方法3");
                break;
            case R.id.btnFuncton04:
                FunctionManager.getInstance().invokeFunction(FunctionManager.FUNCTIONHASPARAMHASRESULT, "调用了方法4,有参数有返回值类型方法", String.class);
                tvShow.setText("调用了方法4");
                break;
            case R.id.btnCloseB:
                finish();
                break;
        }
    }
}
