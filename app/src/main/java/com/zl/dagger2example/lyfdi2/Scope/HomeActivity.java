package com.zl.dagger2example.lyfdi2.Scope;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class HomeActivity extends AppCompatActivity {



    HomeActivityComponent homeActivityComponent;

    /**
     * 总结
     * Qualifier 限定符用来解决依赖迷失问题，可以依赖实例起个别名用来区分。
     * <p>
     * Scope 作用域的本质是 Component 会持有与之绑定的依赖实例的引用，要想确保实例的生命周期，关键在于控制 Component 的生命周期。
     * <p>
     * 优先使用@BindsInstance方法，相对于写一个带有构造函数带有参数的 Module。
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeActivityComponent = DaggerHomeActivityComponent.builder().activity(this).build();
        homeActivityComponent.inijest(this);
    }
}
