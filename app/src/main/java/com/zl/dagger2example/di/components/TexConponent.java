package com.zl.dagger2example.di.components;

import com.zl.dagger2example.ui.TextActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/24.
 */
@Component
public interface TexConponent {
    void abs(TextActivity textActivity);
}
