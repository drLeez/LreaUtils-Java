package org.example.GenericClassHelpers;

import manifold.ext.props.rt.api.val;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public interface ClassGetter
{
    @val
    public Class<?>[] GenericClasses;

    static Type[] GetRawTypeArgs(Object obj)
    {
        var thisClass = obj.getClass();
        var superClass = thisClass.getGenericSuperclass();
        var parameterizedType = (ParameterizedType) superClass;
        return parameterizedType.getActualTypeArguments();
    }
}

class SingleTest<T> extends ClassGetterSingle<T>
{
    public SingleTest()
    {
        var types = String.join(", ", Arrays.stream(genericClasses).map(Class::getName).toList());
        System.out.println("New ${CallerFilePath} of type(s): [${types}]");
    }
}
