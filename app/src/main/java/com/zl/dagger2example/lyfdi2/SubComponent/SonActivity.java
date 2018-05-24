package com.zl.dagger2example.lyfdi2.SubComponent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zl.dagger2example.lyfdi2.bean.Car;
import com.zl.dagger2example.lyfdi2.dependencies.DaggerFriendComponent;
import com.zl.dagger2example.lyfdi2.dependencies.DaggerManComponent;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class SonActivity extends AppCompatActivity {


    @Inject
    Car car;

    @Inject
    Bike bike;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Son 可以开他爸爸 Man 的车 car，也可以骑自己的自行车 bike。依赖关系图：
        FatherComponent manComponent = DaggerFatherComponent.builder().build();
        SonComponent sonComponent = manComponent.sonComponent()
                .build();
        sonComponent.inject(this);
        car.setName("car");
        bike.setBikename("bike");
        goWork();
        /**

         继承关系和依赖关系最大的区别就是：继承关系中不用显式地提供依赖实例的接口，SubComponent 继承 parent Component 的所有依赖。

         依赖关系 vs 继承关系

         相同点：
         两者都能复用其他 Component 的依赖
         有依赖关系和继承关系的 Component 不能有相同的 Scope

         区别：
         依赖关系中被依赖的 Component 必须显式地提供公开依赖实例的接口，而 SubComponent 默认继承 parent Component 的依赖。
         依赖关系会生成两个独立的 DaggerXXComponent 类，而 SubComponent 不会生成 独立的 DaggerXXComponent 类。
         在 Android 开发中，Activity 是 App 运行中组件，Fragment 又是 Activity 一部分，这种组件化思想适合继承关系，
         所以在 Android 中一般使用 SubComponent。


         总结
         Component 之间共用相同依赖，可以有两种组织关系：依赖关系与继承关系。
         在 Android 开发中，一般使用继承关系，以 AppComponent 作为 root Component，
         AppComponent 一般还会使用 @Singleton 作用域，而 ActivityComponent 为 SubComponent。
         */
    }


    public void goWork() {
        String s = car.getName();
        Toast.makeText(this, s + bike.getBikename(), Toast.LENGTH_SHORT).show();
    }
}
