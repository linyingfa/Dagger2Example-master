package com.zl.dagger2example.lyfdi2.SubComponent;

import com.zl.dagger2example.lyfdi2.bean.Car;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/24.
 */


@FatherScope
@Component(modules = CarModule.class)
public interface FatherComponent {

    void inject(FatherActivity man);//// 继承关系中不用显式地提供暴露依赖实例的接口

//    Car car();  //必须向外提供 car 依赖实例的接口，表明 Man 可以借 car 给别人

    //SubComponent 编译时不会生成 DaggerXXComponent，需要通过 parent Component 的获取 SubComponent.Builder 方法获取 SubComponent 实例。

    SonComponent.Builder sonComponent();    // 用来创建 Subcomponent
}
