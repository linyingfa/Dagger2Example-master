package com.zl.dagger2example.di.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by weilu on 2016/1/26.
 * @Qualifier： 限定符，当类的类型不足以鉴别一个依赖的时候会使用到。如果我们没有去区分，
 * 会报错：xxx cannot be provided without an @Provides-annotated method。
 * 例如上面的Person类，我们现在准备返回两个：小明与小关，返回的都是Person类，怎么区分依赖？
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface User {
}