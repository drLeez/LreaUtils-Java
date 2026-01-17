package org.example.GenericClassHelpers;

import manifold.ext.props.rt.api.val;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

import static org.example.ThreadUtils.CallerInfo.GetFilePath;

public interface ClassGetter
{
    @val
    public Class<?>[] genericClasses;

    static Type[] GetRawTypeArgs(Object obj)
    {
        var thisClass = obj.getClass();
        var superClass = thisClass.getGenericSuperclass();
        var parameterizedType = (ParameterizedType) superClass;
        return parameterizedType.getActualTypeArguments();
    }
}
