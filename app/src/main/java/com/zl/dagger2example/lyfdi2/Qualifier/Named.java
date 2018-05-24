package com.zl.dagger2example.lyfdi2.Qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2018/5/24.
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Named {
    String value() default "";
}
