package com.leaf.classAbout;

import org.junit.Test;

import java.lang.reflect.*;


/**
 * Created by pekall on 17-2-21.
 * java反射
 *
 * 1、反射机制是什么
 * 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息
 * 以及动态调用对象的方法的功能称为java语言的反射机制。
 *
 * 2、反射机制能做什么
 * 反射机制主要提供了以下功能：
 * 在运行时判断任意一个对象所属的类；
 * 在运行时构造任意一个类的对象；
 * 在运行时判断任意一个类所具有的成员变量和方法；
 * 在运行时调用任意一个对象的方法；
 * 生成动态代理。
 */
public class TestClass {

    /**
     * 反射机制的相关API
     * 通过一个对象获得完整的包名和类名
     */
    @Test
    public void test1(){
        TestClass tc = new TestClass();
        System.out.println(tc.getClass().getName());
    }

    /**
     * 实例化Class类对象
     * @throws ClassNotFoundException
     */
    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        // 一般采用这种形式
        class1 = Class.forName("com.leaf.classAbout.TestClass");
        class2 = new TestClass().getClass();
        class3 = TestClass.class;
        System.out.println("类名称   " + class1.getName());
        System.out.println("类名称   " + class2.getName());
        System.out.println("类名称   " + class3.getName());
    }

    /**
     * 获取一个对象的父类与实现的接口
     * @throws ClassNotFoundException
     */
    @Test
    public void test3() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        // 取得父类
        Class<?> parentClass = clazz.getSuperclass();
        System.out.println("clazz的父类为：" + parentClass.getName());
        // clazz的父类为： java.lang.Object
        // 获取所有的接口
        Class<?> intes[] = clazz.getInterfaces();
        System.out.println("clazz实现的接口有：");
        for (int i = 0; i < intes.length; i++) {
            System.out.println((i + 1) + "：" + intes[i].getName());
        }
    }

    /**
     * 获取某个类中的全部构造函数
     * 通过反射机制实例化一个类的对象
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    @Test
    public void test4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> class1 = null;
        class1 = Class.forName("com.leaf.classAbout.TestClass.User");
        // 第一种方法，实例化默认构造方法，调用set赋值
        User user = (User) class1.newInstance();
        user.setAge(20);
        user.setName("Rollen");
        System.out.println(user);
        // 结果 User [age=20, name=Rollen]
        // 第二种方法 取得全部的构造函数 使用构造函数赋值
        Constructor<?> cons[] = class1.getConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.print("cons[" + i + "] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }
        // 结果
        // cons[0] (java.lang.String)
        // cons[1] (int,java.lang.String)
        // cons[2] ()
        user = (User) cons[0].newInstance("Rollen");
        System.out.println(user);
        // 结果 User [age=0, name=Rollen]
        user = (User) cons[1].newInstance(20, "Rollen");
        System.out.println(user);
        // 结果 User [age=20, name=Rollen]
    }

    /**
     * 获取某个类的全部属性
     * @throws ClassNotFoundException
     */
    @Test
    public void test5() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        System.out.println("===============ArrayList类属性===============");
        // 取得本类的全部属性
        Field[] field = clazz.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }

        System.out.println("==========实现的接口或者父类的属性==========");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }
    }

    /**
     * 获取某个类的全部方法
     * @throws ClassNotFoundException
     */
    @Test
    public void test6() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        Method method[] = clazz.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }
    }

    /**
     * 通过反射机制调用某个类的方法
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    @Test
    public void test7() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.leaf.classAbout.TestClass");
        // 调用TestReflect类中的reflect1方法
        Method method = clazz.getMethod("reflect1");
        method.invoke(clazz.newInstance());
        // Java 反射机制 - 调用某个类的方法1.
        // 调用TestReflect的reflect2方法
        method = clazz.getMethod("reflect2", int.class, String.class);
        method.invoke(clazz.newInstance(), 20, "张三");
        // Java 反射机制 - 调用某个类的方法2.
        // age -> 20. name -> 张三
    }

    /**
     * 通过反射机制操作某个类的属性
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    @Test
    public void test8() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> clazz = Class.forName("com.leaf.classAbout.TestClass");
        Object obj = clazz.newInstance();
        // 可以直接对 private 的属性赋值
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java反射机制");
        System.out.println(field.get(obj));
    }

    /**
     * 反射机制的动态代理
     */
    /**
     * 在java中有三种类类加载器。
     *
     * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
     *
     * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jrelibext目录中的类
     *
     * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
     *
     * 如果想要完成动态代理，首先需要定义一个InvocationHandler接口的子类，已完成代理的具体操作。
     *
     * @author xsoftlab.net
     *
     */
    @Test
    public void test9(){
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new RealSubject());
        String info = sub.say("Rollen", 20);
        System.out.println(info);
    }

    /******************************************************************************************************************/

    private String proprety = null;

    public void reflect1() {
        System.out.println("Java 反射机制 - 调用某个类的方法1.");
    }
    public void reflect2(int age, String name) {
        System.out.println("Java 反射机制 - 调用某个类的方法2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }

    class User {
        private int age;
        private String name;

        public User() {
            super();
        }

        public User(String name) {
            super();
            this.name = name;
        }

        public User(int age, String name) {
            super();
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User [age=" + age + ", name=" + name + "]";
        }
    }



    //定义项目接口
    interface Subject {
        public String say(String name, int age);
    }
    // 定义真实项目
    class RealSubject implements Subject {
        public String say(String name, int age) {
            return name + "  " + age;
        }
    }
    class MyInvocationHandler implements InvocationHandler {
        private Object obj = null;
        public Object bind(Object obj) {
            this.obj = obj;
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object temp = method.invoke(this.obj, args);
            return temp;
        }
    }
}
