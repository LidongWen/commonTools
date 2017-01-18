# SharedPreferences 操作处理类
简化SharedPreferences的使用
API 简单好用、 支持加密保存
#### 类名：SPUtils

#### 保存数据的方法，拿到保存数据的具体类型，然后根据类型调用不同的保存方法
```java
put(Context context, String FILE_NAME, String key, Object object);
```
####  获取对象
```java
Object get(Context context, String FILE_NAME, String key, Object defaultObject);
```
#### 移除某个key值已经对应的值
```java
void remove(Context context, String FILE_NAME, String key);
```
#### 清除所有数据
```java
clear(Context context, String FILE_NAME);
```
#### 查询某个key是否已经存在
```java
boolean contains(Context context, String FILE_NAME, String key);
```
#### 返回所有的键值对
```java
Map<String, ?> getAll(Context context, String FILE_NAME);
```
#### 加密保存
```java
saveEncode(Context context, String FILE_NAME, String key, String object);
```
#### 解密读取
```java
String getDecode(Context context, String FILE_NAME, String key) ;
```

## 引用
```groovy
// 项目引用
dependencies {
    compile 'com.github.LidongWen:commonTools:1.0.0'
}

// 根目录下引用
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.1.0'
        classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url "https://www.jitpack.io" }
    }
}
```

#Contact me

E-mail:wenld2014@163.com

blog: [wenld's blog](http://blog.csdn.net/sinat_15877283)
