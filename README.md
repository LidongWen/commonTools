# Android 工具类收集
这份资料主要是收集一些通用的开发工具类，帮助Anroid开发者快速开发，节省开发时间，减少开发所耗费的精力。
这样
这份资料我会不断的更新完善, 同时也欢迎更多具有丰富经验的Android开发者将自己常用的工具类分享上来, 我将定期筛选合并, 该份资料有不足的地方, 也请指出, 我会谦虚接受改正, 希望我能与大家一起来成长, 谢谢.

- [AppUtils ____ App相关辅助类](https://github.com/LidongWen/commonTools//blob/master/doc/appUtils.md)
- [ScreenUtils ____ 屏幕辅助类](https://github.com/LidongWen/commonTools//blob/master/doc/screenUtils.md)
- [Json解析](https://github.com/LidongWen/commonTools//blob/master/doc/jsonUtil.md)
- [SharedPreferencesx  工具](https://github.com/LidongWen/commonTools//blob/master/doc/spUtil.md)
- [String类型辅助工具类](https://github.com/LidongWen/commonTools//blob/master/doc/stringUtil.md)
- [复制黏贴 剪切板工具类](https://github.com/LidongWen/commonTools//blob/master/doc/clipboardUtil.md)
- [软键盘工具类](https://github.com/LidongWen/commonTools//blob/master/doc/keyboardUtil.md)
- [网络工具类](https://github.com/LidongWen/commonTools//blob/master/doc/netUtil.md)
- [bitmap 工具类](https://github.com/LidongWen/commonTools//blob/master/doc/bitmapUtil.md)

## 引用
```groovy
// 项目引用
dependencies {
    compile 'com.github.LidongWen:commonTools:1.0.1'
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
