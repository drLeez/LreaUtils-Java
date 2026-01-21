package org.example.GenericClassHelpers;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface ClassGetter
{
    Class<?>[] getGenericClasses();

    static Type[] GetRawTypeArgs(Object obj)
    {
        var thisClass = obj.getClass();
        var superClass = thisClass.getGenericSuperclass();
        var parameterizedType = (ParameterizedType) superClass;
        return parameterizedType.getActualTypeArguments();
    }
}
