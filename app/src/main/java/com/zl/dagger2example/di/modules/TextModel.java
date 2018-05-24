package com.zl.dagger2example.di.modules;

import com.zl.dagger2example.bean.AA;
import com.zl.dagger2example.bean.K1;
import com.zl.dagger2example.bean.K2;
import com.zl.dagger2example.bean.K3;
import com.zl.dagger2example.bean.K4;
import com.zl.dagger2example.bean.Login;
import com.zl.dagger2example.bean.Person;
import com.zl.dagger2example.bean.Stud;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/5/24.
 */

@Module
public class TextModel {//TODO 一般这种提供是第三方的库下创建的对象

    @Singleton
    @Provides
    K1 provideK1() {
        return new K1();
    }

    @Singleton
    @Provides
    K2 provideK2() {
        return new K2();
    }

    @Singleton
    @Provides
    K3 provideK3() {
        return new K3();
    }

    @Singleton
    @Provides
    K4 provideK4() {
        return new K4();
    }
}
