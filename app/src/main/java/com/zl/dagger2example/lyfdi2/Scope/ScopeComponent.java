package com.zl.dagger2example.lyfdi2.Scope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/24.
 */

//@MyScope
@Singleton
@Component(modules = CarModule.class)
public interface ScopeComponent {
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
    void injectScopediActivity(ScopediActivity scopediActivity);
    void injectScopediActivity2(ScopediActivity2 scopediActivity);
}
