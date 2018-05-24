package com.zl.dagger2example.lyfdi2.dependencies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zl.dagger2example.lyfdi2.bean.Car;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ManActivity extends AppCompatActivity {
    @Inject
    Car car;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // @FatherScope 和 @SonScope 都是自定义的作用域
//        这种做法是最简单的，把 Component 需要的依赖都在modules属性中声明，但是这样有两个问题：
//        （1）有时依赖实例需要共享，例如上面场景中，SonActivity 的 car 是向 Man 借的，所以 FriendComponent应该使用ManComponent中的 car 实例。
//        （2）Scope 作用域容易失效，例如 CarModule 的provideCar()使用 @Singleton 作用域，
//             FriendComponent和ManComponent也要用 Singleton 标注，但它们都会持有一个car 实例。
//             所以 SonComponent 需要依赖 FatherComponent 提供的 car 实例，这就是 Component 组织关系中的一种。
//        这个场景FriendComponent和ManComponent是依赖关系。


        /**
         * Component 的组织关系
         Component 管理着依赖实例，根据依赖实例之间的关系就能确定 Component 的关系。
         这些关系可以用object graph描述，我称之为依赖关系图。在 Dagger 2 中 Component 的组织关系分为两种：
         1.依赖关系，一个 Component 依赖其他 Compoent 公开的依赖实例，用 Component 中的dependencies声明。
         2.继承关系，一个 Component 继承（也可以叫扩展）某 Component 提供更多的依赖，SubComponent 就是继承关系的体现。
         */

    }


    public void goWork() {
        car.getName();
    }
}
