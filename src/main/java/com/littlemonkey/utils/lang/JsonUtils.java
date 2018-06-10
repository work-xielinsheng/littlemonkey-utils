package com.littlemonkey.utils.lang;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.littlemonkey.utils.collect.Collections3;

import java.util.Collection;
import java.util.Objects;

public class JsonUtils {

    /**
     * <p>将object转json,当属性值为null时,不会丢失字段</p>
     *
     * @param object
     * @return
     */
    public static String toJSONString(Object object) {
        return JSONObject.toJSONString(object, SerializerFeature.WriteMapNullValue);
    }

    public static JSONObject toJSONObject(Object object) {
        Objects2.requireNonNull(object);
        if (Collections3.isContainer(object.getClass()) || Objects2.isSimple(object)) {
            throw new IllegalArgumentException();
        }
        return (JSONObject) JSONObject.toJSON(object);
    }

    public static JSONArray toJSONArray(Collection collection) {
        Objects2.requireNonNull(collection);
        return (JSONArray) JSONArray.toJSON(collection);
    }

}
