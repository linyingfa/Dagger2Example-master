package com.zl.dagger2example.lyfdi2.Scope;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.zl.dagger2example.lyfdi2.bean.Car;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class ScopediActivity extends AppCompatActivity {

    @Inject
    Car car;

    @Inject
    Car car2;

    ScopeComponent manComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manComponent = DaggerScopeComponent.builder().build();
        manComponent.injectScopediActivity(this);
        if (car == car2) {
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        }
        car.setName("lyf");
        /**
         * Scope 作用域的本质：Component 间接持有依赖实例的引用，把实例的作用域与 Component 绑定，它们不是同年同月同日生，但是同年同月死。
         *
         * @param scopediActivity
         * @MyScope换成@Singleton，发现生成的 DaggerManComponent 和其他类没有变化。也只是用DoubleCheck包装了工厂而已，
         * 并没有什么特殊实现。所以 Singleton 作用域可以保证【一个】Component 中的单例，
         * 【但是如果产生多个 Component 实例，那么实例的单例就无法保证了。】
         * <p>
         * 在网上一些例子中，有看到AppComponent使用 Singleton 作用域，保证绑定的依赖实例的单例。
         * 它生效的原因是AppComponent只会在 Application 中创建一次，由AppComponent的单例来保证绑定的依赖实例的单例。
         */
        //TODO 注意：Component 可以同时被多个 Scope 标记。即 Component 可以和多个 Scope 的 Moudle 或目标类绑定。
        Intent intent = new Intent(this, ScopediActivity2.class);
        startActivity(intent);
        /**
         *
         *Reusable Scope
         上文中的自定义的@MyScope和@Singleton都可以使得绑定的 Component 缓存依赖的实例，
         但是与之绑定 Component 必须有相同的 Scope 标记。假如我只想单纯缓存依赖的实例，
         可以复用之前的实例，不想关心与之绑定是什么 Component，应该怎么办呢？。

         这时就可以使用@Reusable作用域，Reusable 作用域不关心绑定的 Component，
         Reusable 作用域只需要标记目标类或 provide 方法，不用标记 Component。
         利用到 Reusable 实例的 Component 会间接持有实例的引用。但是这里是用SingleCheck而不是DoubleCheck，
         在多线程情况下可能会生成多个实例，关于这个有疑问推荐阅读 Java 设计模式之单例模式中双重检查锁定的部分。
         因为@Reusable作用域目的只是可以复用之前的实例，并不需要严格地保证实例的唯一，所以使用 SingleCheck 就足够了。
         */
    }
}
