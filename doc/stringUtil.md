# StringUtils & 字符串处理
Json&对象转换
- 类名：StringUtils

- isNull
```java
 boolean isEmpty(CharSequence str);
```
- 字符串是否为空（包括"Null"字符串）
```java
 boolean isEmptyWithNullStr(CharSequence str);
```
- 处理字符串，返回非空对象字符串
```java
String processNullStr(String str);
```
- 取得字符串长度
```java
int length(CharSequence str);
```
- 首字母大写
```java
String capitalizeFirstLetter(String str);
```
- utf-8编码
```java
String utf8Encode(String str) ;
```
- utf-8编码
```java
 String utf8Encode(String str, String defultReturn);
```
- get innerHtml from href
```java
String getHrefInnerHtml(String href);
```

- html特殊字符处理转换
```java
String htmlEscapeCharsToString(String source);
```
-  半角转全角
```java
String fullWidthToHalfWidth(String s);
```
- 全角转半角
```java
String halfWidthToFullWidth(String s);
```

- 检测是否有emoji表情
```java
boolean containsEmoji(String source);
```
-  判断是否是Emoji
```java
boolean isEmojiCharacter(char codePoint);
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
