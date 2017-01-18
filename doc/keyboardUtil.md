# KeyboardUtils &  软键盘工具

- 类名：KeyboardUtils

- 隐藏软键盘
```java
 hideSoftKeyboard(Context context, View view) ;
```
-  隐藏虚拟键盘
```java
HideKeyboard(View v) ;
```
-  显示虚拟键盘
```java
ShowKeyboard(View v) ;
```

- 强制显示或者关闭系统键盘
```java
KeyBoard(final EditText txtSearchKey, final String status) ;
```

-  通过定时器强制隐藏虚拟键盘
```java
TimerHideKeyboard(final View v);
```
-  输入法是否显示着
```java
boolean KeyBoard(EditText edittext);
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
