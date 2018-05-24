package com.zl.dagger2example.lyfdi2.Scope;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zl.dagger2example.lyfdi2.bean.Car;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ScopediActivity2 extends AppCompatActivity {

    @Inject
    Car car;

    @Inject
    Car car2;

    ScopeComponent manComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manComponent = DaggerScopeComponent.builder().build();
        manComponent.injectScopediActivity2(this);
        if (car.getName() == null || car.getName().isEmpty()) {
            Toast.makeText(this, "1111111", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, car.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
