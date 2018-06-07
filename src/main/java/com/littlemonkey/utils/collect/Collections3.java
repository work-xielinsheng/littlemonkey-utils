package com.littlemonkey.utils.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;


public class Collections3 extends CollectionUtils {

    /**
     * <p>过滤集合</p>
     *
     * @param unfiltered
     * @param predicate
     * @param <E>
     * @return
     */
    public static <E> Collection<E> filter(Collection<E> unfiltered, Predicate<? super E> predicate) {
        return Collections2.filter(unfiltered, predicate);
    }

    /**
     * <p>判断数组是否是null 或 length = 0</p>
     *
     * @param objects
     * @return
     */
    public static boolean isEmpty(Object[] objects) {
        return (objects == null || objects.length == 0);
    }

    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }


    /**
     * <p>通过对象的class来判断对象是否是Collection 或Array</p>
     *
     * @param object
     * @return
     */
    public static boolean isContainer(Object object) {
        Objects.requireNonNull(object);
        Class targetClass = object.getClass();
        return Collection.class.isAssignableFrom(targetClass) || targetClass.isArray();
    }

    public static boolean isNotContainer(Object object) {
        return !isContainer(object);
    }

    /**
     * <p>通过对象的class来判断对象是否是Map</p>
     *
     * @param targetClass
     * @return
     */
    public static boolean isMap(Class targetClass) {
        return Map.class.isAssignableFrom(targetClass);
    }


    public static boolean isNotEmpty(Map targetMap) {
        return !isEmpty(targetMap);
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

}
