package com.zl.dagger2example.lyfdi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/5/24.
 */
@Module
public class NEWAcMode2 {


    @Provides
    public NEWBean4 provideNEWBean4() {
        return new NEWBean4("sfad");
    }


}
