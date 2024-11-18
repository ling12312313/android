package com.example.wechat_ac;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 加载 Fragment 的布局文件
        View view = inflater.inflate(R.layout.fragment_, container, false);
        return view;
    }
}