package com.zl.dagger2example.lyfdi2.Qualifier;

import com.zl.dagger2example.lyfdi2.Provider.ProviderdiActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/24.
 */

@Component(modules = CarModule.class)
public interface QualifierComponent {
    void inijstQualifier(QualifierdiActivity qualifierdiActivity);
}


