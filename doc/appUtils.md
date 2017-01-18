# AppUtils_  &ensp;&ensp;&ensp;  App相关辅助类
### 版本相关
#### 获取版本号
```java
AppUtils.getVerCode(mContext);
```
- 版本信息
```java
AppUtils.getVerName(mContext);
```
- 获取程序应用名
```java
AppUtils.getAppName(mContext);
```
- 获取应用签名
```java
String getSign(Context context, String pkgName);
```
- 获取手机系统SDK版本
```java
int getSDKVersion();
```

- 是否Dalvik模式
```java
boolean isDalvik();
```
- 是否ART模式
```java
int getDeviceUsableMemory(Context context);
```
- 检测当前应用是否是Debug模式
```java
boolean isDebuggable(Context ctx);
```

### APK操作
- 安装APK
```java
AppUtils.installApk(Context context, File file) ;
```
- 卸载APK
```java
AppUtils.uninstallApk(Context context, String packageName);
```
- 获取系统中所有的应用
```java
List<PackageInfo> getAllApps(Context context);
```
### 进程 & 服务
- 检测服务是否运行
```java
boolean isServiceRunning(Context context, String className);
```
- 停止运行服务
```java
boolean stopRunningService(Context context, String className);
```
- 得到CPU核心数
```java
int getNumCores();
```
- 判断进程是否在运行
```java
boolean isRunningbyNamedProcess(Context context, String processName);
```

- 获取设备的可用内存大小
```java
int getDeviceUsableMemory(Context context);
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
