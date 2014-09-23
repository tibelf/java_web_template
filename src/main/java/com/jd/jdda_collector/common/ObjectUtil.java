package com.jd.jdda_collector.common;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-16
 * Time: 上午10:03
 * 操作对象
 */
public class ObjectUtil {
    public static Object getFieldValue(Object instance, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Field field = getField(instance.getClass(), fieldName, false);
        field.setAccessible(true);
        return field.get(instance);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void setFieldValue(Object instance, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Field field = getField(instance.getClass(), fieldName, false);
        field.setAccessible(true);

        Class fieldType = field.getType();
        Object setValue = value;
        if(Enum.class.isAssignableFrom(fieldType) && (value instanceof String)){
            setValue = Enum.valueOf((Class<Enum>)fieldType, (String)value);
        }else if(Date.class.isAssignableFrom(fieldType) && (value instanceof Long)){
            setValue = new Date((Long)value);
        }

        field.set(instance, setValue);
    }

    public static Field getField(Class<?> instanceClass, String fieldName, boolean onlyPublic) throws NoSuchFieldException, SecurityException{
        if(onlyPublic)
            return instanceClass.getField(fieldName);

        Field field = doGetField(instanceClass, fieldName);
        if(null == field)
            throw new NoSuchFieldException(fieldName);

        return field;
    }

    private static Field doGetField(Class<?> instanceClass, String fieldName){
        Field[] fields = instanceClass.getDeclaredFields();
        for (Field field : fields) {
            if(fieldName.equals(field.getName()))
                return field;
        }

        try {
            Field field = instanceClass.getDeclaredField(fieldName);
            if(null != field)
                return field;
        } catch (Exception e) {}

        Class<?> superClass = instanceClass.getSuperclass();
        if(null != superClass)
            return doGetField(superClass, fieldName);

        return null;
    }

    /**
     * 返回父类所带的泛型的具体类型
     * @param instance
     * @param gecSuperClass
     * @return
     */
    public static Class<?>[] getGenericType(Object instance, Class<?> gecSuperClass){
        Class<?> superClass = instance.getClass().getSuperclass();
        while(null != superClass
                && (superClass != Object.class)){

            if(superClass.getSuperclass() == gecSuperClass)
                break;

            superClass = superClass.getSuperclass();
        }

        ParameterizedType type = (ParameterizedType) superClass.getGenericSuperclass();
        Type[] argTypes = type.getActualTypeArguments();
        List<Class<?>> result = new ArrayList<Class<?>>();
        for (Type argType : argTypes) {
            if (argType instanceof Class<?>) {
                result.add((Class<?>) argType);
            }
        }

        return result.toArray(new Class<?>[result.size()]);
    }

    public static Method getMethod(Class<?> objectClass, String methodName, boolean onlyPublic, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException{
        if(onlyPublic)
            return objectClass.getMethod(methodName, parameterTypes);

        Method method = doGetMethod(objectClass, methodName, parameterTypes);
        if(null == method)
            throw new NoSuchMethodException(objectClass.getName() + "." + methodName + argumentTypesToString(parameterTypes));

        return method;
    }

    private static Method doGetMethod(Class<?> objectClass, String methodName, Class<?>... parameterTypes){
        try {
            Method method = objectClass.getDeclaredMethod(methodName, parameterTypes);
            if(null != method)
                return method;
        } catch (Exception e) {}

        Class<?> superClass = objectClass.getSuperclass();
        if(null != superClass && !superClass.isInterface())
            return doGetMethod(superClass, methodName, parameterTypes);

        return null;
    }

    private static void check(Object instance, String propertyName) {
        if(null == instance)
            throw new RuntimeException("instance is null.");

        if(StringUtil.isEmpty(propertyName))
            throw new PropertyException("propertyName is null");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void setValue(Object instance, String propertyName, Object value){
        check(instance, propertyName);

        if (instance instanceof Map) {
            Map map = (Map) instance;
            map.put(propertyName, value);
        }else{
            try {
                String setMethodName = "set"+Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
                String getMethodName = "get"+Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
                Method getMethod = null;
                Class<?> returnType = null;
                try {
                    getMethod = getMethod(instance.getClass(), getMethodName, true);
                } catch (Exception e) {}
                if(null == getMethod){
                    getMethodName = "is"+Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
                    getMethod = getMethod(instance.getClass(), getMethodName, true);
                }

                if(null == getMethod){
                    throw new NoSuchMethodException("not found method "+getMethodName);
                }

                returnType = getMethod.getReturnType();
                Method setMethod = getMethod(instance.getClass(), setMethodName, true, returnType);

                Object setValue = value;
                if(Enum.class.isAssignableFrom(returnType) && (value instanceof String)){
                    setValue = Enum.valueOf((Class<Enum>)returnType, (String)value);
                }

                setMethod.invoke(instance, setValue);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressWarnings({ "rawtypes" })
    public static Object getValue(Object instance, String propertyName){
        check(instance, propertyName);
        if (instance instanceof Map) {
            Map map = (Map) instance;
            return map.get(propertyName);
        }else{
            try {
                Method getMethod = null;
                String getMethodName = "get"+Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
                try {
                    getMethod = getMethod(instance.getClass(), getMethodName, true);
                } catch (Exception e) {}
                if(null == getMethod){
                    getMethodName = "is"+Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
                    getMethod = getMethod(instance.getClass(), getMethodName, true);
                }

                if(null == getMethod){
                    throw new NoSuchMethodException("not found method "+getMethodName);
                }
                return getMethod.invoke(instance);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String argumentTypesToString(Class<?>[] argTypes) {
        StringBuilder buf = new StringBuilder();
        buf.append("(");
        if (argTypes != null) {
            for (int i = 0; i < argTypes.length; i++) {
                if (i > 0) {
                    buf.append(", ");
                }
                Class<?> c = argTypes[i];
                buf.append((c == null) ? "null" : c.getName());
            }
        }
        buf.append(")");
        return buf.toString();
    }

    public static void copyProperties(Object source, Object target, Map<String, String> properties){
        Set<String> keySet = properties.keySet();
        for (String key : keySet) {
            String propertyName = key;
            String mapKey = properties.get(key);
            if(null != mapKey)
                propertyName = mapKey;

            Object value = getValue(source, key);
            setValue(target, propertyName, value);
        }
    }

    @SuppressWarnings("rawtypes")
    public static <T> T createInstanceFromMap(Class<T> instanceClass, Map map, CreateType createType) throws Exception {
        return createInstanceFromMap(instanceClass, map, null, false, createType);
    }

    @SuppressWarnings("rawtypes")
    public static <T> T createInstanceFromMap(Class<T> instanceClass, Map map, boolean ignoreFaildFields, CreateType createType) throws Exception {
        return createInstanceFromMap(instanceClass, map, null, ignoreFaildFields, createType);
    }

    @SuppressWarnings("rawtypes")
    public static Class getPropertyClass(Class instanceClass, String propertyName, CreateType createType) throws Exception{
        if(Map.class.isAssignableFrom(instanceClass))
            return null;

        switch (createType) {
            case METHOD:
            {
                Method getMethod = null;
                String getMethodName = "get"+Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
                try {
                    getMethod = getMethod(instanceClass, getMethodName, true);
                } catch (Exception e) {}
                if(null == getMethod){
                    getMethodName = "is"+Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
                    getMethod = getMethod(instanceClass, getMethodName, true);
                }
                return getMethod.getReturnType();
            }
            case FIELD:
            {
                Field field = getField(instanceClass, propertyName, false);
                return field.getType();
            }
            default:
                return null;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> T createInstanceFromMap(Class<T> instanceClass, Map map, Map<String, String> propertyMap, boolean ignoreFaildFields, CreateType createType) throws Exception {
        T instance = instanceClass.newInstance();

        Set<Map.Entry> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            Object keyObject = entry.getKey();

            if (!(keyObject instanceof String)) {
                continue;
            }

            String propertyName = (String) keyObject;
            if(null != propertyMap && propertyMap.containsKey(propertyName)){
                propertyName = propertyMap.get(propertyName);
            }

            Object propertyValue = entry.getValue();
            if(null == propertyValue)
                continue;

            Class propertyClass = getPropertyClass(instanceClass, propertyName, createType);
            if(propertyClass.isArray()){
                Object[] propValues = null;
                if(propertyValue.getClass().isArray()){
                    propValues = (Object[]) propertyValue;
                }else if(propertyValue instanceof Collection){
                    propValues = ((Collection)propertyValue).toArray();
                }

                Class propClass = propertyClass.getComponentType();
                //只支持基本类型、String、枚举
                if(!propClass.isPrimitive() && propClass != String.class && !Enum.class.isAssignableFrom(propClass))
                    continue;

                Object arrayValue = Array.newInstance(propClass, propValues.length);
                for (int i = 0; i < propValues.length; i++) {
                    Array.set(arrayValue, i, propValues[i]);
                }

                propertyValue = arrayValue;
            }else if(!propertyClass.isPrimitive() && propertyClass != String.class && !Enum.class.isAssignableFrom(propertyClass)) {
                continue;
            }

            try {
                switch (createType) {
                    case METHOD:{
                        setValue(instance, propertyName, propertyValue);
                    }
                    break;
                    case FIELD:
                    default:{
                        setFieldValue(instance, propertyName, propertyValue);
                    }
                }
            } catch (Exception e) {
                if(!ignoreFaildFields)
                    throw e;
            }
        }

        return instance;
    }

    @SuppressWarnings("rawtypes")
    public static <T> void initPropertyFromMap(T instance, Map map, Map<String, String> propertyMap){
        Set keySet = map.keySet();
        for (Object keyObject : keySet) {
            if (keyObject instanceof String) {
                String propertyName = (String) keyObject;
                if(null != propertyMap && propertyMap.containsKey(propertyName)){
                    propertyName = propertyMap.get(propertyName);
                }

                Object propertyValue = map.get(propertyName);

                setValue(instance, propertyName, propertyValue);
            }
        }
    }
}
