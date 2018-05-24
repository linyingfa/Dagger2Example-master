package com.zl.dagger2example.lyfdi2.Scope;

import android.app.Activity;

import com.zl.dagger2example.di.scopes.ActivityScope;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/5/24.
 * 在 Android 中使用 Dagger 2 时，activity 实例经常也需要作为依赖实例用以注入，在之前只能使用 Module：
 */
@Module
public final class HomeActivityModule {


//    private final HomeActivity activity;

    @Inject
    public Activity activity;

//    public HomeActivityModule(HomeActivity activity) {
//        this.activity = activity;
//    }

    @Provides
    @ActivityScope
// 自定义作用域
    Activity provideActivity() {
        return activity;
    }
}
