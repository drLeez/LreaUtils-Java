package org.example.ReflectionHelpers;

import org.example.GenericClassHelpers.ClassGetterSingle;

public class Force<T, TF> extends ClassGetterSingle<T>
{
    @SuppressWarnings("unchecked")
    public TF get(T obj, String fieldName) throws NoSuchFieldException, IllegalAccessException
    {
        var pf = getGenericClasses()[0].getDeclaredField(fieldName);
        pf.setAccessible(true);
        var raw = pf.get(obj);
        return (TF) raw;
    }

    @SuppressWarnings("unchecked")
    public TF getOrDefault(T obj, String fieldName)
    {
        try
        {
            var pf = getGenericClasses()[0].getDeclaredField(fieldName);
            pf.setAccessible(true);
            var raw = pf.get(obj);
            return (TF) raw;
        }
        catch (NoSuchFieldException | IllegalAccessException e)
        {
            return null;
        }
    }

    public void set(T obj, String fieldName, TF value) throws NoSuchFieldException, IllegalAccessException
    {
        var pf = getGenericClasses()[0].getDeclaredField(fieldName);
        pf.setAccessible(true);
        pf.set(obj, value);
    }
}