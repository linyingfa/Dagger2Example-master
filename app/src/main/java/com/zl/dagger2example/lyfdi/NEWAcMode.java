package com.zl.dagger2example.lyfdi;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/5/24.
 */
@Module
public class NEWAcMode {

    private Application application;

    public NEWAcMode(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }

    @Provides
    public NEWBean2 provideNEWBean2() {
        return new NEWBean2("sfad");
    }

    @Provides
    public NEWBean3 provideNEWBean3() {
        return new NEWBean3("sfad");
    }
}
