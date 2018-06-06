package com.littlemonkey.utils.lang;

import java.lang.annotation.Annotation;
import java.util.Objects;

public class Objects2 {

    public static  <A extends Annotation> A getAnnotation(Object target, Class<A> annotationClass) {
        Objects.requireNonNull(target);
        return target.getClass().getAnnotation(annotationClass) ;
    }
}
