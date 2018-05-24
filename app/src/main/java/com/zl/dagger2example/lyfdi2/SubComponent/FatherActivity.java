package com.zl.dagger2example.lyfdi2.SubComponent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zl.dagger2example.lyfdi2.bean.Car;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class FatherActivity extends AppCompatActivity {
    @Inject
    Car car;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public void goWork() {
        car.getName();
    }
}
