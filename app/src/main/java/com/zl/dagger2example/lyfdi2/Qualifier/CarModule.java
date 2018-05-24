package com.zl.dagger2example.lyfdi2.Qualifier;

import com.zl.dagger2example.lyfdi2.bean.Car;
import com.zl.dagger2example.lyfdi2.bean.Car1;
import com.zl.dagger2example.lyfdi2.bean.Car2;
import com.zl.dagger2example.lyfdi2.bean.Car3;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/5/24.
 * 这时 Dagger 2 不知道使用provideCar1还是provideCar2提供的实例，在编译时就会报错，
 * 这种情况也可以叫依赖迷失（网上看到的叫法）。而@Qualifier注解就是用来解决这个问题，使用注解来确定使用哪种 provide 方法。
 */

@Module
public class CarModule {
    // Car1 和 Car2 是 Car 的两个子类
    @Provides
    @Named("car1")
    static Car3 provideCar1() {
        return new Car1("car1");
    }

    @Provides
    @Named("car2")
    static Car3 provideCar2() {
        return new Car2("car2");
    }

}
