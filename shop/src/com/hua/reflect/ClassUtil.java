package com.hua.reflect;

import java.lang.reflect.*;

/**
 * Created by 10113513 on 2016/06/06.
 */
public class ClassUtil {

    /**
     * 显示类的相关信息
     * @param obj
     */
    public static void classMessage(Object obj) {
        Class cs = obj.getClass();
        System.out.println("类的全名称----------->" + cs.getName());
        System.out.println("类的简写名称--------->" + cs.getSimpleName());
    }

    /**
     * 显示类中声明的方法
     * @param obj
     */
    public static void getMethods(Object obj){
        Class cs = obj.getClass();
        System.out.println("-------"+cs.getName()+"类中的方法");
        Method[] methods = cs.getDeclaredMethods();
        String show;
        for (Method md : methods) {
            show = md.getName() + md.getReturnType() + "(";
            Class[] paramType = md.getParameterTypes();
            for (Class c : paramType) {
                show += c.getSimpleName() + ",";
            }
            show +=")";
            System.out.println(show);
        }
    }

    /**
     * 获取类的成员变量
     * 只能获取公有的成员变量
     * @param obj
     */
    public static void getFiled(Object obj){
        Class cs = obj.getClass();
        System.out.println("-------"+cs.getName()+"类中的成员变量--------");
        Field[] fds = cs.getFields();
        for (Field fd:fds) {
            System.out.println(fd.getName());
        }
    }

    /**
     * 获取类中的构造函数
     * @param obj
     */
    public static void getConstructor(Object obj){
        Class cs = obj.getClass();
        System.out.println("-------"+cs.getName()+"类中的构造函数");
        Constructor[] ctrs = cs.getConstructors();
        String show = "";
        for (Constructor ctr:ctrs) {
            show += ctr.getName()+"(";
            Parameter[] pars = ctr.getParameters();
            for (Parameter par:pars) {
                show += par.getName()+",";
            }
            show +=")";
            System.out.println(show);
        }
    }

    /**
     * 获取特定的方法
     * @param obj 类
     * @param mdName 方法名
     * @param parms 参数列表
     * @param objs 传入参数
     */
    public static void getMethod(Object obj,String mdName,Class[] parms,Object[] objs){
        Class cs = obj.getClass();
        System.out.println("----------"+cs.getName()+"类中的具体方操作------------");
        try {
            JavaReflect ncs = (JavaReflect) cs.newInstance();
            // getDeclaredMethod(方法名,参数列表);
            Method md = null;
            if(parms == null){
                md = cs.getDeclaredMethod(mdName);
                // 调用方法
                md.invoke(ncs);
            }else{
                md = cs.getDeclaredMethod(mdName,parms);
                // 调用方法
                md.invoke(ncs,objs);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
