# BitmapUtil &  图片处理

#### 类名：BitmapUtil

#### 读取图片地址，转换成Bitmap
```java
Bitmap decodeFileToBitmap(String iamgePath);
```
####  读取图片地址，转换成Bitmap
```java
Bitmap getBitmapFromFile(File dst, int width, int height) ;
```
#### 动态计算缩放大小比例
```java
int computeSampleSize(BitmapFactory.Options options,
                                        int minSideLength, int maxNumOfPixels);
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
