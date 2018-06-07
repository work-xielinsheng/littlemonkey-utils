package com.littlemonkey.utils.lang;

import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.Objects;

public class Objects2 {

    public static <A extends Annotation> A getAnnotation(Object target, Class<A> annotationClass) {
        Objects.requireNonNull(target);
        return target.getClass().getAnnotation(annotationClass);
    }

    /**
     * <p>判断是否是包装类或者基本类型以及String</p>
     *
     * @param object
     * @return
     */
    public static boolean isSimple(Object object) {
        Objects.requireNonNull(object);
        Class tClass = object.getClass();
        try {
            return StringUtils.endsWithIgnoreCase(tClass.getTypeName(), String.class.getTypeName())
                    || ((Class) tClass.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return tClass.isPrimitive();
        }
    }
}
