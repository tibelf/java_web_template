package com.jd.jdda_collector.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-15
 * Time: 下午1:41
 * To change this template use File | Settings | File Templates.
 */
public abstract class ClassType<T> {
    private Type parameterizedType;
    public ClassType() {
        System.out.println(getClass().getName());
        System.out.println(getClass().getSuperclass().getName());
        System.out.println(getClass().getGenericSuperclass());
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) {
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        parameterizedType = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public Type getParameterizedType() {
        return parameterizedType;
    }
}
