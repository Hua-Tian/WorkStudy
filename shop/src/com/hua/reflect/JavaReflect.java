package com.hua.reflect;

import com.description.dao.UserDao;



/**
 * Created by 10113513 on 2016/06/06.
 */
public class JavaReflect {
    public String animal;
    private int num;
    protected  boolean isOk;

    public JavaReflect(){

    }
    public JavaReflect(String a){
        System.out.println("do someThing");
    }


    /**
     * 动态加载类
     * @param className
     */
    public static void getClasses(String className) {
        Software software = null;
        try {
            Class c = Class.forName("com.hua.reflect." + className);// 获取类
            software = (Software) c.newInstance();                // 实例化类
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        software.show();

    }

    /**
     * 测试
     * @param str
     */
    public void test(String str) {
        System.out.println("这是全部大写的测试方法："+str.toUpperCase());
    }
    /**
     * 测试1
     */
    public void test1() {
        System.out.println("这是全部小写的测试方法："+"LIuBaoHua".toLowerCase());
    }


    public static void main(String[] args) {
        /*java 反射机制*/
        // 获取类的方法
        UserDao userDao = new UserDao();
        Class c = UserDao.class;      // 1、知道类名 .class
        Class d = userDao.getClass(); // 2、知道对象 .getClass()
        Class m = null;               // 3、知道类的路径直接 class.forName("");
        try {
            m = Class.forName("com.description.dao.UserDao"); // 动态加载类
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("c d是否相等 ： " + (c == d));
        System.out.println("c m是否相等 ： " + (c == m));
        System.out.println("打印类名称：\n" + c.getName() + "\n" + d.getName() + "\n" + m.getName());
        System.out.println("不包含包名的类名称：\n" + c.getSimpleName() + "\n" + d.getSimpleName()+ "\n" + m.getSimpleName());

        try {

            UserDao ud = (UserDao) c.newInstance(); // 通过反射实例化一个对象，前提是UserDao必须有一个默认的无参构造方法
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        /**
         * 1、编译加载类属于静态加载类，运行加载类属于动态加载类
         * 2、new 对象属于静态加载类,在编译时期就要加载所有可能用到的类。
         * 3、通过使用动态加载类，类在使用时加载，不使用不加载。
         * 4、void 等关键字都有类类型
         * 5、获取类类型后就能获取类的相关信息
         */
        JavaReflect.getClasses("Word");

        ClassUtil.classMessage(new JavaReflect());

        ClassUtil.getMethods(new JavaReflect());

        ClassUtil.getFiled(new JavaReflect());

        ClassUtil.getConstructor(new JavaReflect());

        // 参数列表
        Class[] parms = new Class[]{String.class};
        String[] strs = new String[]{"liubaohua"};
        // 测试有参数
        ClassUtil.getMethod(new JavaReflect(),"test",parms,strs);
        // 测试无参数
        ClassUtil.getMethod(new JavaReflect(),"test1",null,null);


        // 创建内部类实例
        JavaReflect jr = new JavaReflect();
        JavaReflect.Test test = jr.new Test();
        test.test();
        // 使用get方法获取
        Test test1 = jr.getTest(1,2);
        test.test();


    }

    /**
     * 内部类
     *
     */
    public class Test {

        public void test() {
            //内部类可以访问外围的成员变量和方法
//            animal = "test";
//            num = 2;
//            getClasses("JavaReflect");

        }
    }


    /**
     * 匿名内部类
     * 匿名内部类使用到的参数必须是final
     * @param in
     * @param x
     * @return
     */
    public Test getTest(final Integer in,int x) {
        return  new Test(){
            Integer x = in;
            public void getSome(){

            }
        };
    }



    }
