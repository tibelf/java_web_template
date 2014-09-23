package com.jd.jdda_collector.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-15
 * Time: 下午1:37
 * To change this template use File | Settings | File Templates.
 */
public class JsonUtil {
    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private final static ObjectMapper mapper = new ObjectMapper();

    private static JavaType getJavaType(Type type, Class<?> contextClass) {
        return (contextClass != null) ?
                mapper.getTypeFactory().constructType(type, contextClass) :
                mapper.constructType(type);
    }

    public static <T> T convertJsonToClass(String jsonString, Class<T> targetClass) {
        if (jsonString != null) {
            try {
                return mapper.readValue(jsonString, getJavaType(targetClass, null));
            } catch (IOException e) {
                logger.warn("Error while reading Java Map from JSON response: " + jsonString, e);
            }
        }
        return null;
    }

    public static String convertToJson(Object value) {
        StringWriter writer = new StringWriter();
        if (mapper.canSerialize(value.getClass())) {
            try {
                JsonGenerator jsonGenerator = mapper.getFactory().createGenerator(writer);
                mapper.writeValue(jsonGenerator, value);
                String jsonString = writer.toString();
                return jsonString;
            } catch (IOException e) {
                logger.warn("Error while serializing " + value + " to JSON", e);
                return null;
            }
        }
        else {
            throw new IllegalArgumentException("Value of type " + value.getClass().getName() + " can not be serialized to JSON.");
        }
    }

    public static <T> T convertJsonToClass(String jsonString, ClassType<T> classType) {
        if (jsonString != null) {
            try {
                return mapper.readValue(jsonString, getJavaType(classType.getParameterizedType(), null));
            } catch (IOException e) {
                logger.warn("Error while reading Java Map from JSON response: " + jsonString, e);
            }
        }
        return null;
    }

    class B{
        int a;
    }
    static class A<T>{
        T value;
    }
    public static void main(String[] args) {
//        A<B> a = new A<B>();
        convertJsonToClass("{1:2}", new ClassType<A<B>>() {});
    }
}
