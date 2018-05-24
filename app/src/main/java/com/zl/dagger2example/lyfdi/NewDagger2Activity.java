package com.zl.dagger2example.lyfdi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;



import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/24.
 * Error:(8, 29) 错误: 找不到符号
 符号:   类 DaggerNEWACConpont2
 位置: 程序包 com.zl.dagger2example
 */

public class NewDagger2Activity extends AppCompatActivity {

    //TODO 第一种创建方式：@Inject 对象构造方法，@Component注射器
//    @Inject
//    NEWBean newBean;
//    NEWACConpont conpont;
    //TODO 第二种创建方式：
    NEWACConpont2 conpont2;
    @Inject
    NEWBean2 newBean2;
    @Inject
    NEWBean3 newBean3;
    @Inject
    NEWBean4 newBean4;

    /**
     * 注意：同一个界面不能有2个Component注射器，否则会有冲突
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 第一种创建方式：@Inject 对象构造方法，@Component注射器
//        conpont = DaggerNEWACConpont.builder().build();
//        conpont.inject(this);
//        Toast.makeText(this, newBean.toString(), Toast.LENGTH_SHORT).show();
        //TODO 第二种创建方式：通过Module+Provides+Inject+Component。。
        conpont2 = DaggerNEWACConpont2.builder()
                //TODO 如果Model有构造方法，需要穿参，就需要手动addModel
                .nEWAcMode(new NEWAcMode(getApplication()))
                .build();
        conpont2.inject(this);
        newBean4 = conpont2.getNeB4();
        Toast.makeText(this, newBean2.toString() + newBean3.toString() + newBean4.toString(), Toast.LENGTH_SHORT).show();
    }
}
