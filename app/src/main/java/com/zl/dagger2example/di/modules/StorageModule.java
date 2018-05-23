package com.zl.dagger2example.di.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by weilu on 2016/1/26.
 */
@Module
public class StorageModule {
	private Application application;

	public StorageModule(Application application) {
		this.application = application;
	}

	/**
	 * @return
	 * @Provides： 在@Module 中使用，我们定义的方法用这个注解，用于告诉 Dagger 我们需要构造实例并提供依赖。
	 * 为什么要使用@Provides，因为默认情况下，Dagger满足依赖关系是通过调用构造方法得到的实例，
	 * 比如上面的Person类使用。但是有时因为@Inject 的局限性，我们不能使用@Inject。
	 * 比如构造方法有多个、三方库中的类我们不知道他是怎么实现的等等。例如下面代码中的SharedPreferences，
	 * 我们使用@Provides 返回一个创建好的实例，这样做也显得灵活不是吗？
	 */
	//@Singleton 单例，使用@Singleton注解之后，对象只会被初始化一次，
	// 之后的每次都会被直接注入相同的对象。@Singleton就是一个内置的作用域。
	@Provides
	@Singleton
	SharedPreferences provideSharedPreferences() {
		return PreferenceManager.getDefaultSharedPreferences(application);
	}
}
