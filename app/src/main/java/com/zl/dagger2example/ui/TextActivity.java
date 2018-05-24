package com.zl.dagger2example.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.zl.dagger2example.bean.K1;
import com.zl.dagger2example.di.components.TexConponent;


import javax.inject.Inject;

/**
 * Created by xiaolin on 2018/5/10.
 */
public class TextActivity extends AppCompatActivity {
//    @Inject
//    Person person;
//    //
//    @Inject
//    AA aa;
//    //
//    @Inject
//    Login login;
//    //
//    @Inject
//    Stud stud;

//    A a;//注射器

    @Inject
    K1 k1;
//    @Inject
//    K2 k2;
//    @Inject
//    K3 k3;
//    @Inject
//    K4 k4;

//    TextConmponent textConmponent;
    TexConponent texConponent;
    /**
     * 如果通过Inject 来注解一个对象或者方法，不管怎样注入都好，必须有一个Component和model，即是是空的也可以
     * 具体看源码
     * Error:(10, 43) 错误: 找不到符号
     * 符号:   类 DaggerA
     * 位置: 程序包 com.zl.dagger2example.di.components
     * Error:(13, 43) 错误: 找不到符号
     * 符号:   类 DaggerTextConmponent
     * 位置: 程序包 com.zl.dagger2example.di.components
     * Error:(12, 43) 错误: 找不到符号
     * 符号:   类 DaggerTextConmponent
     * 位置: 程序包 com.zl.dagger2example.di.components
     * Error:(16, 43) 错误: 找不到符号
     * 符号:   类 DaggerTextConmponent
     * 位置: 程序包 com.zl.dagger2example.di.components
     *
     * @param savedInstanceState Error:(13, 43) 错误: 找不到符号
     *                           符号:   类 DaggerTextConmponent
     *                           位置: 程序包 com.zl.dagger2example.di.components
     */
    /**
     * Error:(12, 43) 错误: 找不到符号
     符号:   类 DaggerTexConponent
     位置: 程序包 com.zl.dagger2example.di.components
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 通过Inject来注入，1.定义一个注射器，定义一个被注入的对象，构造器必须声明Inject，并且需要注入的对象中，声明该变量不能是私有的
//        texConponent= DaggerTexConponent.builder().build();
//        texConponent.abs(this);
        Toast.makeText(this, k1.toString(), Toast.LENGTH_SHORT).show();
//        a = DaggerA.builder().build();
//        a.init(this);.textModel(new TextC())
//        textConmponent = DaggerTextConmponent
//                .builder()
//                .textModel(new TextC())
//                .build();
//        textConmponent.inject(this);
//        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();

//        Toast.makeText(this, k1.toString() + k2.toString() + k3.toString() + k4.toString()
//                , Toast.LENGTH_SHORT).show();
    }


}
