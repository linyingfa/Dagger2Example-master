package com.zl.dagger2example;

import android.app.Application;
import android.widget.Toast;

import com.zl.dagger2example.bean.Person;
import com.zl.dagger2example.bean.Stud;
import com.zl.dagger2example.di.components.AppComponent;
import com.zl.dagger2example.di.components.DaggerAppComponent;
import com.zl.dagger2example.di.modules.AppModule;
import com.zl.dagger2example.di.modules.StorageModule;
import com.zl.dagger2example.lyfdi2.Scope.MyScope2;

import javax.inject.Inject;

import dagger.releasablereferences.ForReleasableReferences;
import dagger.releasablereferences.ReleasableReferenceManager;

/**
 * Created by weilu on 2016/1/26.
 * 用法，当界面的对象或者变量或者方法有Inject标记的时候
 * 告诉Dagger这个类或者字段需要依赖注入，
 */
public class MyApplication extends Application {
    @Inject
    Stud stud = null;
    //@Inject：在需要依赖的地方使用这个注解，告诉Dagger这个类或者字段需要依赖注入，这样Dagger会构造一个这个类实例来满足依赖。
    //这样就不用手动new了，，如果需要多个的话，就要自定义
    @Inject
    Person person;
    private AppComponent mAppComponent;//是@Inject和@Module的桥梁,需要列出所有的@Modules以组成该组件。

//    @Inject //在内存不足时调用releaseStrongReferences()方法把 Component 间接持有的强引用变为弱引用。
//    @ForReleasableReferences(MyScope2.class)
//    ReleasableReferenceManager myScopeReferences;

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        /**
         * 这样在内存不足时，DaggerManComponent 间接持有的 Car 实例为弱引用，如果没有其他对象使用的话就可以被回收。
         */
//        myScopeReferences.releaseStrongReferences();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()//调用构建类，，如果有多个modeld的情况下，就需要手动添加了
                .appModule(new AppModule(this)) //传入Module
                .storageModule(new StorageModule(this)) //传入Module
                .build();//生成实例
//		//TODO Tisp：上面的build是生成XXXXXComponent,Component是@Inject和@Module的桥梁,需要列出所有的@Modules以组成该组件。
//		mAppComponent.inject(this);//我们还需要定义一个方法，把需要注入的类设置进去，列如：inject（）方法，方面名随便写
        mAppComponent.aaa(this);
        mAppComponent.getSharedPreferences();//我们也可以定义在Component内部注入，也可以
        String str = mAppComponent.getAAA().getStr();
        Toast.makeText(this, stud.getAge() + str + person.getName(), Toast.LENGTH_SHORT).show();
        /**
         * Module
         使用@Inject标注构造函数来提供依赖的对象实例的方法，不是万能的，在以下几种场景中无法使用：

         接口没有构造函数

         第三方库的类不能被标注

         构造函数中的参数必须配置

         这时，就可以用@Provides标注的方法来提供依赖实例，方法的返回值就是依赖的对象实例，
         @Provides 方法必须在Module中，Module 即用@Module标注的类。所以 Module 是提供依赖的对象实例的另一种方式。
         */
/*
         @Module
		 public class CarModule {
		 @Provides
		 static Car provideCar() {
		    return new Car();
		    }
		 }*/
//		 约定俗成的是@Provides方法一般以provide为前缀，Moudle 类以Module为后缀，一个 Module 类中可以有多个@Provides方法。
//
//		 接下来，需要把可以提供依赖实例的 Module 告诉 Component：
//
//		 @Component(modules = CarModule.class)
//		 public interface ScopeComponent {
//		 void injectMan(FatherActivity man);  // 注入 man 所需要的依赖
//		 }
//		 build之后，Module 和 Component 生成的类为：
        //TODO ************************************************
//		总结
//		现在再来看 Dagger 2 最核心的三个部分：
//		需要注入依赖的目标类，需要注入的实例属性由@Inject标注。
//
//		提供依赖对象实例的工厂，用@Inject标注构造函数或定义Module这两种方式都能提供依赖实例，
//      Dagger 2 的注解处理器会在编译时生成相应的工厂类。Module的优先级比@Inject标注构造函数的高，
//      意味着 Dagger 2 会先从 Module 寻找依赖实例。
//
//		把依赖实例工厂创建的实例注入到目标类中的 Component。
//
//		下面再讲述上面提到的在 Dagger 2 种几个注解的用法：
//
//		@Inject 一般情况下是标注成员属性和构造函数，标注的成员属性不能是private，Dagger 2 还支持方法注入，@Inject还可以标注方法。
//
//		@Provides 只能标注方法，必须在 Module 中。
//
//		@Module 用来标注 Module 类
//
//		@Component 只能标注接口或抽象类，声明的注入接口的参数类型必须和目标类一致。
    }

//	public AppComponent getAppComponent() {
//		return mAppComponent;
//	}
}