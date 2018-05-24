package com.zl.dagger2example.lyfdi2.Scope;

import com.zl.dagger2example.lyfdi2.bean.Car;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/5/24.
 */

@Module
public class CarModule {
    @Provides
//    @MyScope
    @Singleton
    static Car provideCar() {
        //这样生成的 Car 实例就与 ScopeComponent 绑定了。
        return new Car();
    }
}
