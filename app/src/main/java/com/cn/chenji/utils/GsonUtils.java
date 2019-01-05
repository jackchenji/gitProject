package com.cn.chenji.utils;

import android.support.annotation.MainThread;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author Created by Simen.
 * @date 创建日期 2017/12/12 15:19
 * @modify 修改者 Simen
 */
public class GsonUtils {

    private static final Gson gson = new Gson();

    @MainThread
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    @MainThread
    public static <T> ArrayList<T> fromJsonList(String json, Class<T> clazz) {
        ArrayList<T> arrayList = new ArrayList<>();
        Type type = new TypeToken<ArrayList<JsonObject>>() {

        }.getType();
        ArrayList<JsonObject> jsonObjects = gson.fromJson(json, type);
        if (jsonObjects == null) {
            return arrayList;
        }
        for (JsonObject jsonObject : jsonObjects) {
            arrayList.add(gson.fromJson(jsonObject, clazz));
        }

        return arrayList;
    }

    public static <T> T fromJsonInThread(String json, Class<T> classOfT) throws
            JsonSyntaxException {
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }

    /**
     * 将对象转为JSON字符串
     *
     * @return
     */
    public static String toJSONString(Object object) {
        if (object == null) {
            return null;
        }
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    /**
     * 将对象转为JSON字符串(实体的属性为null时，序列化时保留该字符串)
     *
     * @return
     */
    public static String toJSONStringWithNull(Object object) {
        if (object == null) {
            return null;
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(object);
    }

    public static String getValue(String key, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            return jsonObject.optString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
