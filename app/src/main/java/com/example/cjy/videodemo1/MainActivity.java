package com.example.cjy.videodemo1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private Unbinder unbinder;
    @BindView(R.id.mBtn1)Button mBtn1;
    @BindView(R.id.mBtn2)Button mBtn2;
    @BindView(R.id.mBtn3)Button mBtn3;
    @BindViews({R.id.mBtn1,R.id.mBtn2,R.id.mBtn3})List<Button>buttons;
    @BindString(R.string.app_name)String app_name;
    @OnClick({R.id.mBtn1,R.id.mBtn2,R.id.mBtn3})
    public void aaa(View view){
        switch (view.getId()){
            case R.id.mBtn1:
                Toast.makeText(this, "btn1111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mBtn2:
                Toast.makeText(this, "btn2222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mBtn3:
                Toast.makeText(this, "btn3333", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);//绑定到Activity身上
        mBtn1.setText(app_name);
        mBtn2.setText("面对疾风吧！");
        mBtn3.setText("面对疾风吧！");
        ButterKnife.apply(buttons, new ButterKnife.Action<Button>() {
            @Override
            public void apply(@NonNull Button view, int index) {
                view.setText(app_name);
            }
        });
        ButterKnife.apply(buttons, new ButterKnife.Setter<Button, String>() {
            @Override
            public void set(@NonNull Button view, String value, int index) {
                view.setText(value);
            }
        },"呵呵");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();//视图销毁时，解绑
    }
}
