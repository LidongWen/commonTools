# NetUtils &  网络工具类

- 类名：NetUtils

- 判断网络是否连接
```java
 boolean isConnected(Context context);
```
- 判断是否是wifi连接
```java
boolean isWifi(Context context);
```

- 拼凑域名端口
```java
String Judgeurl(String weburl, String Host);
```
- 拼凑域名端口
```java
String Judgeurl(String weburl);
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
