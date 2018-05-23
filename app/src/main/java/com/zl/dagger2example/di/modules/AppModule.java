package com.zl.dagger2example.di.modules;

import android.app.Application;
import android.content.Context;

import com.zl.dagger2example.bean.AA;
import com.zl.dagger2example.bean.Stud;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by weilu on 2016/1/27.
 * 2.Module
 *
 * @Module： 用来修饰类，表示此类的方法是用来提供依赖的，它告诉Dagger在哪里可以找到依赖。
 */
@Module
public class AppModule {
	private Application application;

	public AppModule(Application application) {
		this.application = application;
	}

	@Provides
	@Singleton
	Context provideContext() {
		return application;
	}

	@Provides
	Stud provideStud() {
		return new Stud();
	}

	@Provides
	AA getAA() {
		return new AA();
	}
}
