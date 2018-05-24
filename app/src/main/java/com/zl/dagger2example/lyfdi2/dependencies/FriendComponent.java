package com.zl.dagger2example.lyfdi2.dependencies;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/24.
 */

//@FatherScope
//@Component(modules = CarModule.class)
//public interface SonComponent {
//
//}

@FriendScope
@Component(dependencies = ManComponent.class)
public interface FriendComponent {
    void inject(FriendActivity friend);
}