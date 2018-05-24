package com.zl.dagger2example.lyfdi;


import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/24.
 */
//@Component(modules = NEWAcMode.class)//单个model情况下
@Singleton
@Component(modules = {NEWAcMode.class, NEWAcMode2.class,})
public interface NEWACConpont2 {

    void inject(NewDagger2Activity newDagger2Activity);

    NEWBean4 getNeB4();
}
