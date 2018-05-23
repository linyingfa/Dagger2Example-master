package com.zl.dagger2example.di.components;

import com.zl.dagger2example.di.modules.AModule;
import com.zl.dagger2example.ui.Text;

import dagger.Component;

/**
 * Created by xiaolin on 2018/5/10.
 */
@Component(modules = {AModule.class})
public interface A {
	void init(Text text);
}
