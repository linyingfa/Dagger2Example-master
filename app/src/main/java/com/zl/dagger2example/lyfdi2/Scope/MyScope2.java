package com.zl.dagger2example.lyfdi2.Scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import dagger.releasablereferences.CanReleaseReferences;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2018/5/24.
 */
@Documented
@Retention(RUNTIME)
@CanReleaseReferences
@Scope
public @interface MyScope2 {

    /**
     * Releasable references（可释放引用）
     使用 Scope 注解时，Component 会间接持有绑定的依赖实例的引用，
     也就是说实例在 Component 还存活时无法被回收。而在 Android 中，应该尽量减少内存占用，
     把没有使用的对象释放，这时可以用@CanReleaseReferences标记 Scope 注解：

     然后在 Application 中注入ReleasableReferenceManager对象，
     在内存不足时调用releaseStrongReferences()方法把 Component 间接持有的强引用变为弱引用。
     */
}
