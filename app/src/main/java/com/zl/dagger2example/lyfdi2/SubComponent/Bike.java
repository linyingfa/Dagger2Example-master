package com.zl.dagger2example.lyfdi2.SubComponent;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class Bike {

    public String bikename;

    public String getBikename() {
        return bikename;
    }

    public void setBikename(String bikename) {
        this.bikename = bikename;
    }

    @Inject
    public Bike() {
    }
}
