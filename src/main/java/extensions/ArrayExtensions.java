package extensions;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Extension
public class ArrayExtensions
{
    public static <E> Stream<E> where(@This E[] array, Predicate<? super E> predicate)
    {
        return array.stream().filter(predicate);
    }

    public static <E> E first(@This E[] array) throws NoSuchElementException
    {
        for (E e : array) return e;
        throw new NoSuchElementException();
    }
    public static <E> E first(@This E[] array, Predicate<? super E> predicate) throws NoSuchElementException
    {
        for (E e : array) if (predicate.test(e)) return e;
        throw new NoSuchElementException();
    }
    public static <E> E firstOrDefault(@This E[] array, Predicate<? super E> predicate)
    {
        for (E e : array) if (predicate.test(e)) return e;
        return null;
    }
    public static <E> E last(@This E[] array) throws NoSuchElementException
    {
        boolean pass = false;
        E ret = null;
        for (E e : array) { ret = e; pass = true;}
        if (!pass) throw new NoSuchElementException();
        return ret;
    }
    public static <E> E last(@This E[] array, Predicate<? super E> predicate) throws NoSuchElementException
    {
        boolean pass = false;
        E ret = null;
        for (E e : array) if (predicate.test(e)) { ret = e; pass = true;}
        if (!pass) throw new NoSuchElementException();
        return ret;
    }
    public static <E> E lastOrDefault(@This E[] array, Predicate<? super E> predicate)
    {
        E ret = null;
        for (E e : array) if (predicate.test(e)) ret = e;
        return ret;
    }

    public static <E> boolean any(@This E[] array, Predicate<? super E> predicate)
    {
        return array.stream().anyMatch(predicate);
    }
    public static <E> boolean all(@This E[] array, Predicate<? super E> predicate)
    {
        return array.stream().allMatch(predicate);
    }

    public static <E, R> Stream<R> select(@This E[] array, Function<? super E, R> mapper) {
        return array.stream().map(mapper);
    }

    public static <E> boolean isNullOrEmpty(@This E[] array)
    {
        if (array == null) return true;
        return array.isEmpty();
    }
}
