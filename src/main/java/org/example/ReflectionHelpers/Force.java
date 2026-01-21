package org.example.ReflectionHelpers;

import org.example.General.HashMapHelper;
import org.example.GenericClassHelpers.ClassGetterSingle;

import java.util.HashMap;

public class Force<T, TF> extends ClassGetterSingle<T>
{
    private static final HashMap<Class<?>, Force<?, ?>> MAP = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <E, EF> EF Get(E obj, String fieldName) throws NoSuchFieldException, IllegalAccessException
    {
        var myClass = (Class<E>) obj.getClass();
        var find = (Force<E, EF>) HashMapHelper.GetOrMake(MAP, myClass, () -> new Force<E, EF>(myClass){});
        return find.get(obj, fieldName);
    }

    @SuppressWarnings("unchecked")
    public static <E, EF> EF GetOrDefault(E obj, String fieldName)
    {
        var myClass = (Class<E>) obj.getClass();
        var find = (Force<E, EF>) HashMapHelper.GetOrMake(MAP, myClass, () -> new Force<E, EF>(myClass){});
        return find.getOrDefault(obj, fieldName);
    }

    @SuppressWarnings("unchecked")
    public static <E, EF> void Set(E obj, String fieldName, EF value) throws NoSuchFieldException, IllegalAccessException
    {
        var myClass = (Class<E>) obj.getClass();
        var find = (Force<E, EF>) HashMapHelper.GetOrMake(MAP, myClass, () -> new Force<E, EF>(myClass){});
        find.set(obj, fieldName, value);
    }

    public Force()
    {}

    private Force(Class<T> tClass)
    {
        super(new Class[]{tClass});

    }

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