package com.zl.dagger2example.lyfdi2.bean;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class Car1 extends Car3 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Inject
    public Car1(String name) {
        this.name = name;
    }
}
