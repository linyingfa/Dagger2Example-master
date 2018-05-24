package com.zl.dagger2example.lyfdi2.Provider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zl.dagger2example.lyfdi2.bean.Car;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Administrator on 2018/5/24.
 * Provider 注入
 * 有时候不仅仅是注入单个实例，我们需要多个实例，这时可以使用注入Provider<T>，
 * 每次调用它的 get() 方法都会调用到 @Inject 构造函数创建新实例或者 Module 的 provide 方法返回实例。
 */

public class ProviderdiActivity extends AppCompatActivity {


    @Inject
    Provider<Car> carProvider;
    ProviderConpatr providerConpatr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        providerConpatr = DaggerProviderConpatr.builder().build();
        providerConpatr.inijstProvider(this);
        List<Car> carList = makeCar(5);
        Toast.makeText(this, "" + carList.size(), Toast.LENGTH_SHORT).show();
    }

    public List<Car> makeCar(int num) {
        List<Car> carList = new ArrayList<Car>(num);
        for (int i = 0; i < num; i++) {
            carList.add(carProvider.get());
        }
        return carList;
    }
}
