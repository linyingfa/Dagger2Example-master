package com.zl.dagger2example.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zl.dagger2example.bean.Person;
import com.zl.dagger2example.di.components.A;
import com.zl.dagger2example.di.components.DaggerA;

import javax.inject.Inject;

/**
 * Created by xiaolin on 2018/5/10.
 */
public class Text extends AppCompatActivity {
	@Inject
	Person person;
	A a;

	/**
	 * 如果通过Inject 来注解一个对象或者方法，不管怎样注入都好，必须有一个Component和model，即是是空的也可以
	 * 具体看源码
	 *
	 * @param savedInstanceState
	 */
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		a = DaggerA.builder().build();
		a.init(this);
		Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
	}
}
