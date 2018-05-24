package com.zl.dagger2example.lyfdi2.Scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2018/5/24.
 * Scope（作用域）
 * Scope 是用来确定注入的实例的生命周期的，如果没有使用 Scope 注解，
 * Component 每次调用 Module 中的 provide 方法或 Inject 构造函数生成的工厂时都会创建一个新的实例，
 * 而使用 Scope 后可以复用之前的依赖实例。下面先介绍 Scope 的基本概念与原理，再分析 Singleton、Reusable 等作用域。
 */

@Documented
@Retention(RUNTIME)
@Scope
public @interface MyScope {

    /**
     * MyScope 就是一个 Scope 注解，Scope 注解只能标注目标类、@provide 方法和 Component。
     * Scope 注解要生效的话，需要同时标注在 Component 和提供依赖实例的 Module 或目标类上。
     * Module 中 provide 方法中的 Scope 注解必须和 与之绑定的 Component 的 Scope 注解一样，否则作用域不同会导致编译时会报错。
     * 例如：
     * CarModule 中 provide 方法的 Scope 是MyScope 的话，
     * ScopeComponent 的 Scope 必须是 是 MyScope 这样作用域才会生效，
     * 而且不能是@Singleton或其他 Scope 注解，不然编译时 Dagger 2 会报错（亲自测试过）。
     * /////////////////////////////////////////////////////////////////////////
     * 那么 Scope 注解又是如何产生作用的呢，怎么保证生成的依赖实例的生命周期呢？
     * 当Component 与 Module、目标类（需要被注入依赖）使用 Scope 注解绑定时，
     * 意味着 Component 对象【持有】绑定的依赖实例的一个引用直到 Component 对象本身被回收。
     * 也就是作用域的原理，其实是让生成的依赖实例的生命周期与 Component 绑定，
     * Scope 注解并不能保证生命周期，要想保证赖实例的生命周期，需要确保 Component 的生命周期。
     */
}
