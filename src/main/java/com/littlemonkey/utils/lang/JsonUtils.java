package com.littlemonkey.utils.lang;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

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
}
