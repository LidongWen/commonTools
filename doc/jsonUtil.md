# FastJsonUtil & json处理
Json&对象转换
#### 类名：FastJsonUtil

#### 对象
```java
 <T> T getObject(String jsonString, Class<T> cls);
```
####  获取对象列表
```java
 <T> List<T> getListObjects(String jsonString, Class<T> cls);
```
#### 得到一个List<Map<String, Object>>
```java
 List<Map<String, Object>> getListMaps(String jsonString) ;
```
#### 将对象转成Json字符串
```java
String toJsonObject(Object obj);
```
#### 将对象转成Json字符串
```java
String toJsonObjectByGson(Object obj);
```

#Contact me

E-mail:wenld2014@163.com

blog: [wenld's blog](http://blog.csdn.net/sinat_15877283)
