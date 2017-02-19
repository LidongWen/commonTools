package com.wenld.commontools;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * <p/>
 * Author: 温利东 on 2017/2/6 9:53.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class ReflectUtil {

    /**
     * @param owner
     * @param fieldName
     * @param value
     * @throws Exception
     * @title: setField
     * @description: 设置某个成员遍历的值
     * @return: void
     */
    public static void setField(Object owner, String fieldName, Object value) throws Exception {
        Class<?> ownerClass = owner.getClass();
        Field field = ownerClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(owner, value);
    }

    /**
     * @param owner
     * @param fieldName
     * @param value
     * @throws Exception
     * @title: setFieldAll
     * @description: 可以设置父类的field的值
     * @return: void
     */
    public static void setFieldAll(Object owner, String fieldName, Object value) throws Exception {
        Class<?> ownerClass = owner.getClass();
        Field field = null;
        for (Class<?> clazz = ownerClass; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        field.setAccessible(true);
        field.set(owner, value);
    }

    /**
     * 得到某个对象的公共属性
     *
     * @param owner , fieldName
     * @return 该属性对象
     * @throws Exception
     */
    public static Object getField(Object owner, String fieldName) throws Exception {
        Class<?> ownerClass = owner.getClass();

        Field field = ownerClass.getField(fieldName);

        Object property = field.get(owner);

        return property;
    }

    /**
     * 得到某类的静态公共属性
     *
     * @param className 类名
     * @param fieldName 属性名
     * @return 该属性对象
     * @throws Exception
     */
    public static Object getStaticField(String className, String fieldName) throws Exception {
        Class<?> ownerClass = Class.forName(className);

        Field field = ownerClass.getField(fieldName);

        Object property = field.get(ownerClass);

        return property;
    }

    /**
     * 执行某对象方法
     *
     * @param owner      对象
     * @param methodName 方法名
     * @param args       参数
     * @return 方法返回值
     * @throws Exception
     */
    public static Object invokeMethod(Object owner, String methodName, Object... args) throws Exception {

        Class<?> ownerClass = owner.getClass();

        Class<?>[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            if (args[i].getClass() == Integer.class) { //一般的函数都是 int 而不是Integer
                argsClass[i] = int.class;
            } else if (args[i].getClass() == Float.class) { //一般的函数都是 int 而不是Integer
                argsClass[i] = float.class;
            } else if (args[i].getClass() == Double.class) { //一般的函数都是 int 而不是Integer
                argsClass[i] = double.class;
            } else {
                argsClass[i] = args[i].getClass();
            }
        }

        Method method = ownerClass.getDeclaredMethod(methodName, argsClass);
        method.setAccessible(true);
        return method.invoke(owner, args);
    }

    /**
     * @param owner
     * @param methodName
     * @param args
     * @return
     * @throws Exception
     * @title: invokeMethodAll
     * @description: 调用所有的函数, 包括父类的所有函数
     * @return: Object
     */
    public static Object invokeMethodAll(Object owner, String methodName, Object... args) throws Exception {

        Class<?> ownerClass = owner.getClass();

        Class<?>[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            if (args[i].getClass() == Integer.class) { //一般的函数都是 int 而不是Integer
                argsClass[i] = int.class;
            } else if (args[i].getClass() == Float.class) { //一般的函数都是 int 而不是Integer
                argsClass[i] = float.class;
            } else if (args[i].getClass() == Double.class) { //一般的函数都是 int 而不是Integer
                argsClass[i] = double.class;
            } else {
                argsClass[i] = args[i].getClass();
            }
        }
        Method method = null;

        for (Class<?> clazz = ownerClass; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, argsClass);
                return method;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        method.setAccessible(true);
        return method.invoke(owner, args);
    }

    /**
     * 执行某类的静态方法
     *
     * @param className  类名
     * @param methodName 方法名
     * @param args       参数数组
     * @return 执行方法返回的结果
     * @throws Exception
     */
    public static Object invokeStaticMethod(String className, String methodName, Object... args) throws Exception {
        Class<?> ownerClass = Class.forName(className);

        Class<?>[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }

        Method method = ownerClass.getMethod(methodName, argsClass);
        method.setAccessible(true);
        return method.invoke(null, args);
    }

    /**
     * 新建实例
     *
     * @param className 类名
     * @param args      构造函数的参数 如果无构造参数，args 填写为 null
     * @return 新建的实例
     * @throws Exception
     */
    public static Object newInstance(String className, Object[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return newInstance(className, args, null);

    }

    /**
     * 新建实例
     *
     * @param className 类名
     * @param args      构造函数的参数 如果无构造参数，args 填写为 null
     * @return 新建的实例
     * @throws Exception
     */
    public static Object newInstance(String className, Object[] args, Class<?>[] argsType) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> newoneClass = Class.forName(className);

        if (args == null) {
            return newoneClass.newInstance();

        } else {
            Constructor<?> cons;
            if (argsType == null) {
                Class<?>[] argsClass = new Class[args.length];

                for (int i = 0, j = args.length; i < j; i++) {
                    argsClass[i] = args[i].getClass();
                }

                cons = newoneClass.getConstructor(argsClass);
            } else {
                cons = newoneClass.getConstructor(argsType);
            }
            return cons.newInstance(args);
        }

    }

    /**
     * 是不是某个类的实例
     *
     * @param obj 实例
     * @param cls 类
     * @return 如果 obj 是此类的实例，则返回 true
     */
    public static boolean isInstance(Object obj, Class<?> cls) {
        return cls.isInstance(obj);
    }

    /**
     * 得到数组中的某个元素
     *
     * @param array 数组
     * @param index 索引
     * @return 返回指定数组对象中索引组件的值
     */
    public static Object getItemInArray(Object array, int index) {
        return Array.get(array, index);
    }

    /**
     * @param pPackage
     * @return
     * @title: GetClassListByPackage
     * @description: 获取包下的所有Class
     * @return: Class<?>
     */
    public static Class<?> getClassListByPackage(String pPackage) {
        Package _Package = Package.getPackage(pPackage);
        Class<?> _List = _Package.getClass();
        return _List;
    }
}