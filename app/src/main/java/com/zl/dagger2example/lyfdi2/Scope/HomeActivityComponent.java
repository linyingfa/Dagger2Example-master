package com.zl.dagger2example.lyfdi2.Scope;

import android.app.Activity;

import com.zl.dagger2example.di.scopes.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;

/**
 * Created by Administrator on 2018/5/24.
 * 注意在调用build()创建 Component 之前，所有@BindsInstance方法必须先调用。
 * 上面例子中 HomeActivityComponent 还可以注入 Activity 类型的依赖，
 * 但是不能注入 HomeActivity，因为 Dagger 2 是使用具体类型作为依据的
 * （也就是只能使用@Inject Activity activity而不是@Inject HomeActivity activity）。
 * <p>
 * 如果@BindsInstance方法的参数可能为 null，需要再用@Nullable标记，
 * 同时标注 Inject 的地方也需要用@Nullable标记。这时 Builder 也可以不调用@BindsInstance方法，
 * 这样 Component 会默认设置 instance 为 null。
 */

@ActivityScope
@Component(modules = HomeActivityModule.class)
public interface HomeActivityComponent {


    //在 Android 中使用 Dagger 2 时，activity 实例经常也需要作为依赖实例用以注入，在之前只能使用 Module：HomeActivityModule
    //而使用@BindsInstance的话会更加简单：
    //优先使用@BindsInstance方法，相对于写一个带有构造函数带有参数的 Module。
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder activity(Activity activity);

        HomeActivityComponent build();
    }

    void inijest(HomeActivity homeActivity);
}
