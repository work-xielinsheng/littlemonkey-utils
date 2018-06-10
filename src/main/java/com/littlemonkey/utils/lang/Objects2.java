package com.littlemonkey.utils.lang;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;

public class Objects2 {

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean nonNull(Object obj) {
        return obj != null;
    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null)
            throw new NullPointerException();
        return obj;
    }

    /**
     * <p>获取对象的注解实体</p>
     *
     * @param target
     * @param annotationClass
     * @param <A>
     * @return
     */
    public static <A extends Annotation> A getAnnotation(Object target, Class<A> annotationClass) {
        Objects2.requireNonNull(target);
        return target.getClass().getAnnotation(annotationClass);
    }

    /**
     * <p>判断是否是包装类或者基本类型以及String</p>
     *
     * @param object
     * @return
     */
    public static boolean isSimple(Object object) {
        Objects2.requireNonNull(object);
        Class tClass = object.getClass();
        try {
            return StringUtils.endsWithIgnoreCase(tClass.getTypeName(), String.class.getTypeName())
                    || ((Class) tClass.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return tClass.isPrimitive();
        }
    }


    /**
     * <p>判断字符串是否符合number类型</p>
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        return NumberUtils.isCreatable(str);
    }

    /**
     * <p>判断类class是否是number class</p>
     *
     * @param targetClass
     * @return
     */
    public static boolean isNumberClass(Class targetClass) {
        return int.class.equals(targetClass) || byte.class.equals(targetClass) || double.class.equals(targetClass) || short.class.equals(targetClass) || long.class.equals(targetClass) || float.class.equals(targetClass) ||
                Integer.class.equals(targetClass) || Double.class.equals(targetClass) || Byte.class.equals(targetClass) || Short.class.equals(targetClass) || Long.class.equals(targetClass) || Float.class.equals(targetClass);
    }

    /**
     * <p>将字符串转换成对应number类型数据</p>
     *
     * @param text        需要转换的字符串
     * @param targetClass 目标类型,支持基本类型和包装类
     * @param <T>
     * @return
     */
    public static <T> T parseNumber(String text, Class targetClass) {
        Class tClass = targetClass;
        if (int.class.equals(targetClass)) {
            tClass = Integer.class;
        } else if (byte.class.equals(targetClass)) {
            tClass = Byte.class;
        } else if (short.class.equals(targetClass)) {
            tClass = Short.class;
        } else if (long.class.equals(targetClass)) {
            tClass = Long.class;
        } else if (float.class.equals(targetClass)) {
            tClass = Float.class;
        }
        return (T) org.springframework.util.NumberUtils.parseNumber(text, tClass);
    }
}
