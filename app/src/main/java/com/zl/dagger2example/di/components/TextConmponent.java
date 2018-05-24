package com.zl.dagger2example.di.components;


import com.zl.dagger2example.di.modules.TextModel;
import com.zl.dagger2example.ui.TextActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/24.
 */

@Singleton
@Component(modules = {TextModel.class})
public interface TextConmponent {

    void inject(TextActivity text);
}
