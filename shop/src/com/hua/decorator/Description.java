package com.hua.decorator;

import java.lang.annotation.*;

/**
 * Created by 10113513 on 2016/06/03.
 */
@Target({ElementType.METHOD,ElementType.TYPE}) // 作用域
@Retention(RetentionPolicy.RUNTIME) //生命周期
@Inherited // 允许子类继承
@Documented // 生成javadoc时会包含注解的信息
public @interface Description {

    String value() default "刘宝华";

}
