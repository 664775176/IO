package com.zhangchao.classLoader;

import sun.misc.Launcher;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Test
 * @description: TODO
 * @date 2018/11/28 11:12
 */
public class Test {

    public static void main(String args[]) throws Exception{

//        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls[i].toExternalForm());
//        }
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        Properties properties = System.getProperties();
//        properties.forEach((key, value) -> {
//            System.out.println("key:"+key + "-----value:"+value);
//        });


        Launcher launcher = new Launcher();

        ClassLoader c = Test.class.getClassLoader();
        System.out.println(c);
        ClassLoader c1 = Object.class.getClassLoader();
        System.out.println(c1);
        ClassLoader c2 = CurveDB.class.getClassLoader();
        System.out.println(c2);
        ClassLoader c3 = Test.class.getClassLoader();
        System.out.println(c3);
        ClassLoader c4 = launcher.getClassLoader();
        System.out.println(c4);
        ClassLoader c5 = launcher.getClassLoader();
        System.out.println(c5);
        ClassLoader c6 = Test.class.getClassLoader();
        try {
            new MyClassLoader().loadClass("com.zhangchao.classLoader.TestInit", true);
            System.out.println(TestInit.a);
//            new TestInit();
//            Class.forName("com.zhangchao.classLoader.TestInit", true, Test.class.getClassLoader());
//            Class.forName("com.zhangchao.classLoader.TestInit", true, Test.class.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class.forName("sun.reflect.CallerSensitive");
            Class.forName("com.mysql.jdbc.Driver");
//            getCallerClass();
            DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "aaa", "bbb");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    @CallerSensitive
   public static void getCallerClass(){
       System.out.println(Reflection.getCallerClass().getClassLoader());
   }

}
class MyClassLoader extends ClassLoader{

    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        return super.loadClass(name, true);
    }
}
