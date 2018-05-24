package com.zl.dagger2example.lyfdi;

import com.zl.dagger2example.bean.K1;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 */

public class NEWBean {

    /**
     * @Inject 一般情况下是标注成员属性和构造函数，标注的成员属性不能是private，Dagger 2 还支持方法注入，@Inject还可以标注方法。
     */
//    private String age;
    //    private int age2;
//    @Inject
//    public int age2;

    //带参数的构造方法，存在基本类型会报错
    //  java.lang.String cannot be provided without an @Inject constructor or from an @Provides-annotated method.
//    @Inject
//    public NEWBean(int age2) {
//    }

    /**
     * 使用@Inject标注构造函数来提供依赖的对象实例的方法，不是万能的，在以下几种场景中无法使用：
     * <p>1
     * 接口没有构造函数
     * <p>2
     * 第三方库的类不能被标注
     * <p>3
     *构造函数中的参数必须配置
     */

    /**
     * 如果带参数的构造方法，对象必须也要在构造方法添加Inject
     */
    @Inject
    public NEWBean(K1 k1) {

    }
}
