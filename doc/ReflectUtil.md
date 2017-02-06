# FastJsonUtil & json处理
Json&对象转换
#### 类名：FastJsonUtil

| name        | void name           | direction  |
| ------------- | ------------- | :-----:|
| 设置某个成员的值      | setField(Object owner, String fieldName, Object value) | |
| 可以设置父类的field的值      |  setFieldAll(Object owner, String fieldName, Object value) |  |
| 得到某个对象的公共属性 | Object getField(Object owner, String fieldName) |    |
| 得到某类的静态公共属性 | Object getStaticField(String className, String fieldName)   |     |
| 执行某对象方法 | Object invokeMethod(Object owner, String methodName, Object... args) |  args:参数  |
| 调用所有的函数, 包括父类的所有函数| Object invokeMethodAll(Object owner, String methodName, Object... args)   |   args:参数   |
| 执行某类的静态方法 | Object invokeStaticMethod(String className, String methodName, Object... args) |   args:参数  |
| 新建实例 | Object newInstance(String className, Object[] args)   |     |
| 新建实例 | Object newInstance(String className, Object[] args, Class<?>[] argsType) |   args:参数  |
| 是不是某个类的实例 | boolean isInstance(Object obj, Class<?> cls) |     |
| 得到数组中的某个元素 | Object getItemInArray(Object array, int index) |    |
| 获取包下的所有Class |  Class<?> getClassListByPackage(String pPackage) |

#Contact me

E-mail:wenld2014@163.com

github: [https://github.com/LidongWen](https://github.com/LidongWen)

blog: [wenld's blog](http://blog.csdn.net/sinat_15877283)
