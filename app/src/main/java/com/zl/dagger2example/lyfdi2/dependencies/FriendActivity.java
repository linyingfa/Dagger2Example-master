package com.zl.dagger2example.lyfdi2.dependencies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zl.dagger2example.lyfdi2.bean.Car;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class FriendActivity extends AppCompatActivity {

    @Inject
    Car car;  // 车是向 FatherActivity 借的
    FriendComponent friendComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 编译时生成的代码中 DaggerFriendComponent 的 Provider<Car>实现中会用到manComponent.car()来提供 car 实例，
         * 如果 FatherComponent 没有向外提供 car 实例的接口的话，DaggerFriendComponent 就会注入失败。
         * FatherActivity 有一辆车，SonActivity 没有车，但是他可以借 FatherActivity 的车出去游玩下，
         * 提供 Car 实例的CarModule不变，那么我们应该怎么设计 Component 呢？
         */

        ManComponent manComponent = DaggerManComponent.builder().build();
        friendComponent = DaggerFriendComponent.builder()
                .manComponent(manComponent)
                .build();
        friendComponent.inject(this);
        goWork();
        /**
         *
         依赖关系就跟生活中的朋友关系相当，注意事项如下：
         被依赖的 Component 需要把暴露的依赖实例用显式的接口声明，如上面的Car car()，我们只能使用朋友愿意分享的东西。
         依赖关系中的 Component 的 Scope 不能相同，因为它们的生命周期不同。
         */
    }


    public void goWork() {
        String s = car.getName();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
