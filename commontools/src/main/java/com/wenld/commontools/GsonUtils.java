package com.wenld.commontools;

/**
 * GsonUtils.java
 * Gson解析json的工具类，用于解析json字符串，或把bean转化为json字符串
 * Created by Vamoose on 2015/12/1.
 */

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class GsonUtils {
    /**
     * 按章节点得到相应的内容
     *
     * @param jsonString json字符串
     * @param note       节点
     * @return 节点对应的内容
     */
    public static String getNoteJsonString(String jsonString, String note) {
        if (TextUtils.isEmpty(jsonString)) {
            throw new RuntimeException("json字符串不能为空");
        }
        if (TextUtils.isEmpty(note)) {
            throw new RuntimeException("note标签不能为空");
        }
        JsonElement element = new JsonParser().parse(jsonString);
        if (element.isJsonNull()) {
            throw new RuntimeException("得到的jsonElement对象为空");
        }
        return element.getAsJsonObject().get(note).toString();
    }

    /**
     * 按照节点得到节点内容，然后传化为相对应的bean数组
     *
     * @param jsonString 原json字符串
     * @param note       节点标签
     * @param beanClazz  要转化成的bean class
     * @return 返回bean的数组
     */
    public static <T> List<T> parserJsonToListObjects(String jsonString, String note, Class<T> beanClazz) {
        String noteJsonString = getNoteJsonString(jsonString, note);
        return parserJsonToListObjects(noteJsonString, beanClazz);
    }

    /**
     * 按照节点得到节点内容，转化为一个数组
     *
     * @param jsonString json字符串
     * @param beanClazz  集合里存入的数据对象
     * @return 含有目标对象的集合
     */
    public static <T> List<T> parserJsonToListObjects(String jsonString, Class<T> beanClazz) {
        if (TextUtils.isEmpty(jsonString)) {
            throw new RuntimeException("json字符串为空");
        }
        JsonElement jsonElement = new JsonParser().parse(jsonString);
        if (jsonElement.isJsonNull()) {
            throw new RuntimeException("得到的jsonElement对象为空");
        }
        if (!jsonElement.isJsonArray()) {
            throw new RuntimeException("json字符不是一个数组对象集合");
        }
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        List<T> beans = new ArrayList<T>();
        for (JsonElement jsonElement2 : jsonArray) {
                T bean = new Gson().fromJson(jsonElement2, beanClazz);
            beans.add(bean);
        }
        return beans;
    }

    /**
     * 把相对应节点的内容封装为对象
     *
     * @param jsonString json字符串
     * @param clazzBean  要封装成的目标对象
     * @return 目标对象
     */
    public static <T> T parserJsonToObject(String jsonString, Class<T> clazzBean) {
        if (TextUtils.isEmpty(jsonString)) {
            throw new RuntimeException("json字符串为空");
        }
        JsonElement jsonElement = new JsonParser().parse(jsonString);
        if (jsonElement.isJsonNull()) {
            throw new RuntimeException("json字符串为空");
        }
        if (!jsonElement.isJsonObject()) {
            throw new RuntimeException("json不是一个对象");
        }
        return new Gson().fromJson(jsonElement, clazzBean);
    }

    /**
     * 按照节点得到节点内容，转化为一个数组
     *
     * @param jsonString json字符串
     * @param note       json标签
     * @param clazzBean  集合里存入的数据对象
     * @return 含有目标对象的集合
     */
    public static <T> T parserJsonToObject(String jsonString, String note, Class<T> clazzBean) {
        String noteJsonString = getNoteJsonString(jsonString, note);
        return parserJsonToObject(noteJsonString, clazzBean);
    }

    /**
     * 把bean对象转化为json字符串
     *
     * @param obj bean对象
     * @return 返回的是json字符串
     */
    public static String toJsonString(Object obj) {
        if (obj != null) {
            return new Gson().toJson(obj);
        } else {
            throw new RuntimeException("对象不能为空");
        }
    }

    /**
     * 把bean对象转化为json字符串
     * 主要解决：Json包含特殊字符的
     * @param obj
     * @return
     */
    public static String toJsonStringUnHtmlEscape(Object obj){
        Gson gs = new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();
        if (obj != null) {
            return gs.toJson(obj);
        } else {
            throw new RuntimeException("对象不能为空");
        }
    }
}

