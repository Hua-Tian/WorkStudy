package com.hua.controller;

import com.hua.decorator.Description;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.NoUrlPara;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Created by 10113513 on 2016/06/02.
 */
@Description("this is description class")
public class CDecorator extends Controller {

    @Before(NoUrlPara.class)
    public void index() {
        setAttr("test", "test").renderJson();
    }

    public void test() {
        setAttr("test", "test").renderJson();
    }

    @Target({ElementType.METHOD, ElementType.TYPE}) // 作用域
    @Retention(RetentionPolicy.RUNTIME) //生命周期
    @Inherited // 允许子类继承
    @Documented // 生成javadoc时会包含注解的信息
    public @interface test1 {
        //        int age() default 18;
        String value();
    }

    @Description("this is a description method")
    public void testZhuJie() {

    }

    public static void main(String[] args) {

        try {
            Class c = Class.forName("com.hua.controller.CDecorator");
            boolean isExist = c.isAnnotationPresent(Description.class);
            if (isExist) {
                Description de = (Description) c.getAnnotation(Description.class);
                System.out.println("class = [" + de.value() + "]");
            }
            Method[] ms = c.getMethods();
            for (Method m : ms) {
                boolean isExistM = m.isAnnotationPresent(Description.class);
                if (isExistM) {
                    Description de = (Description) m.getAnnotation(Description.class);
                    System.out.println("method = [" +de.value() +"]");
                }

            }
            // 法二
            for (Method m : ms){
                Annotation[] as = m.getAnnotations();
                for (Annotation a : as) {
                    Description d = (Description) a;
                    if (a instanceof Description) {
                        System.out.println("args = [" + d.value() + "]");
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
