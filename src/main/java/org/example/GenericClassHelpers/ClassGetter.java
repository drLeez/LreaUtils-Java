package org.example.GenericClassHelpers;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public abstract class ClassGetter
{
    private final Class<?>[] genericClasses;

    public ClassGetter()
    {
        genericClasses = autoConstruct();
    }

    protected ClassGetter(Class<?>[] manual)
    {
        genericClasses = manual;
    }

    protected abstract Class<?>[] autoConstruct();

    public Class<?>[] getGenericClasses()
    {
        return Arrays.copyOf(genericClasses, genericClasses.length);
    }

    public static Type[] GetRawTypeArgs(Object obj)
    {
        var thisClass = obj.getClass();
        var superClass = thisClass.getGenericSuperclass();
        var parameterizedType = (ParameterizedType) superClass;
        return parameterizedType.getActualTypeArguments();
    }
}
