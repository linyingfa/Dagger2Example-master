package com.zl.dagger2example.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import com.zl.dagger2example.MyApplication;
import com.zl.dagger2example.bean.AA;
import com.zl.dagger2example.di.modules.AppModule;
import com.zl.dagger2example.di.modules.StorageModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by weilu on 2016/1/27.
 *
 * @Component： 是@Inject和@Module的桥梁,需要列出所有的@Modules以组成该组件。
 */
@Singleton
@Component(modules = {AppModule.class, StorageModule.class,})
public interface AppComponent {
	Context getAppContext();

	SharedPreferences getSharedPreferences();

	//	void inject(MyApplication myApplication);
	void aaa(MyApplication myApplication);

	AA getAAA();
}
