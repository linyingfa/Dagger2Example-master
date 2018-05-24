package com.zl.dagger2example.lyfdi2.dependencies;

import com.zl.dagger2example.lyfdi2.bean.Car;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/24.
 */

//@FatherScope
//@Component(modules = CarModule.class)
//public interface FatherComponent {
//
//}

/**
 * 注：因为 SonComponent 和 FatherComponent 是依赖关系，如果其中一个声明了作用域的话，
 * 另外一个也必须声明，而且它们的 Scope 不能相同，FatherComponent 的生命周期 >= SonComponent 的。
 * 【SonComponent 的 Scope 不能是 @Singleton，因为 Dagger 2 中 @Singleton 的 Component 不能依赖其他的 Component。】
 */

@ManScope
@Component(modules = CarModule.class)
public interface ManComponent {

    void inject(ManActivity man);

    Car car();  //必须向外提供 car 依赖实例的接口，表明 Man 可以借 car 给别人
}
