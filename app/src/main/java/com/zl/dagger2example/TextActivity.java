package com.zl.dagger2example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class TextActivity extends AppCompatActivity {

    @Inject
    TextBean textBean;
    TextC textC;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textC =DaggerTextC.builder().build();
        textC.inids(this);
    }
}
