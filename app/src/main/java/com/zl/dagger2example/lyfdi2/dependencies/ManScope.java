package com.zl.dagger2example.lyfdi2.dependencies;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2018/5/24.
 */
@Documented
@Retention(RUNTIME)
@Scope
public @interface ManScope {
}
