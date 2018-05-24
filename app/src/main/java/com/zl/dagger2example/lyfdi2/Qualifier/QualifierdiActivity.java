package com.zl.dagger2example.lyfdi2.Qualifier;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zl.dagger2example.lyfdi2.bean.Car3;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class QualifierdiActivity extends AppCompatActivity {

    @Inject
    @Named("car1")
    Car3 car1;

    @Inject
    @Named("car2")
    Car3 car2;

    QualifierComponent qualifierComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        qualifierComponent = DaggerQualifierComponent.builder().build();
        qualifierComponent.inijstQualifier(this);

        String n1 = car1.getName();
        String n2 = car2.getName();
        Toast.makeText(this, n2 + n1, Toast.LENGTH_SHORT).show();
    }
}
