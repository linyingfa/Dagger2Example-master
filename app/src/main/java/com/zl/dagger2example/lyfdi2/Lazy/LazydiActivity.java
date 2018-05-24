package com.zl.dagger2example.lyfdi2.Lazy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zl.dagger2example.lyfdi2.bean.Car;


import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by Administrator on 2018/5/24.
 * Lazy （延迟注入）
 * Error:(12, 36) 错误: 找不到符号
 符号:   类 DaggerLazydiConpatr
 位置: 程序包 com.zl.dagger2example.lyfdi2
 */

public class LazydiActivity extends AppCompatActivity {

    @Inject
    Lazy<Car> lazyCar;
    LazydiConpatr lyfdiConpatr;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lyfdiConpatr = DaggerLazydiConpatr.builder().build();
        lyfdiConpatr.inijst(this);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goWork();
            }
        }, 2000);

    }

    public void goWork() {
        // lazyCar.get() 返回 Car 实例
        lazyCar.get().setName("car1");
        Toast.makeText(this, lazyCar.get().getName(), Toast.LENGTH_SHORT).show();
    }
}
