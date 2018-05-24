package com.zl.dagger2example.lyfdi;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/24.
 * Error:(11, 10) 错误: java.lang.String cannot be provided without an @Inject constructor or from an @Provides-annotated method.
 java.lang.String is injected at
 com.zl.dagger2example.lyfdi.NEWBean.<init>(age)
 com.zl.dagger2example.lyfdi.NEWBean is injected at
 com.zl.dagger2example.lyfdi.NewDagger2Activity.newBean
 com.zl.dagger2example.lyfdi.NewDagger2Activity is injected at
 com.zl.dagger2example.lyfdi.NEWACConpont.inject(newDagger2Activity)
 */
@Component
public interface NEWACConpont {

//    void aa(NewDagger2Activity newDagger2Activity);
}
