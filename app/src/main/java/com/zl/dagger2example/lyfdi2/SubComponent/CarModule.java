package com.zl.dagger2example.lyfdi2.SubComponent;

import com.zl.dagger2example.lyfdi2.bean.Car;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/5/24.
 *
 * @SubComponent的写法与@Component一样，只能标注接口或抽象类，与依赖关系一样，SubComponent 与 parent Component 的 Scope 不能相同，
 * 只是 SubComponent 表明它是继承扩展某 Component 的。怎么表明一个 SubComponent 是属于哪个 parent Component 的呢？
 * 只需要在 parent Component 依赖的 Module 中的subcomponents加上 SubComponent 的 class，
 * 然后就可以在 parent Component 中请求 SubComponent.Builder。
 */

@Module(subcomponents = SonComponent.class)
public class CarModule {
    @Provides
    @FatherScope
    static Car provideCar() {
        return new Car();
    }
}
