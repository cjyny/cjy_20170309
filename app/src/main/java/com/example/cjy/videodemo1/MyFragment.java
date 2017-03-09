package com.example.cjy.videodemo1;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFragment extends Fragment {
    @BindView(R.id.mBtn1)Button mBtn1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main,container,false);
        //控件绑定到自身，Fragment需要传布局
        ButterKnife.bind(this,view);
        return view;
    }
}
