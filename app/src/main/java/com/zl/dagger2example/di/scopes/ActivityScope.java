package com.zl.dagger2example.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by weilu on 2016/1/26.
 *
 * @Scope： 注解作用域，通过自定义注解限定对象的作用范围。它是JSR-330标准的一部分，其实@Singleton就是一种@Scope。
 * 在Dagger 2中，@Scope被用于标记自定义的scope注解。
 * 简单说它们可以类似单例地标记依赖。被作注解的依赖会变成单例，
 * 但是这会与component的生命周期（不是整个应用）关联。
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
