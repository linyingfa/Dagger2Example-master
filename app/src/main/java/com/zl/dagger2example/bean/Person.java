package com.zl.dagger2example.bean;

import javax.inject.Inject;

/**
 * Created by weilu on 2016/1/27.
 * 写了一个简单的Demo，下面根据Demo进行介绍。Dagger2要理解必须看Dagger 2自动生成的代码，
 * Build后代码在项目-->app-->build-->generated-->source-->apt-->debug目录下。
 */
public class Person {
	private String name = "Jack";
	private int age = 15;

	/**
	 * @Inject： 在需要依赖的地方使用这个注解，告诉Dagger这个类或者字段需要依赖注入，
	 * 这样Dagger会构造一个这个类实例来满足依赖。
	 * Tisp:这个的局限性是我们不能给这个类中的多个构造器作@Inject注解。
	 */
	@Inject
	public Person() {
	}

	/**
	 * Error:Execution failed for task ':app:compileDebugJavaWithJavac'.
	 * > java.lang.IllegalStateException: Found multiple @Inject constructors: [Person(), Person(java.lang.String)]
	 *
	 * @param s
	 */
//	@Inject
	public Person(String s) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
