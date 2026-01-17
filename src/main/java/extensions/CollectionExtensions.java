package extensions;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Extension
public class CollectionExtensions {
    public static <E> Stream<E> where(@This Collection<E> collection, Predicate<? super E> predicate)
    {
        return collection.stream().filter(predicate);
    }

    public static <E> E first(@This Collection<E> collection) throws NoSuchElementException
    {
        for (E e : collection) return e;
        throw new NoSuchElementException();
    }
    public static <E> E first(@This Collection<E> collection, Predicate<? super E> predicate) throws NoSuchElementException
    {
        for (E e : collection) if (predicate.test(e)) return e;
        throw new NoSuchElementException();
    }
    public static <E> E firstOrDefault(@This Collection<E> collection, Predicate<? super E> predicate)
    {
        for (E e : collection) if (predicate.test(e)) return e;
        return null;
    }
    public static <E> E last(@This Collection<E> collection) throws NoSuchElementException
    {
        boolean pass = false;
        E ret = null;
        for (E e : collection) { ret = e; pass = true;}
        if (!pass) throw new NoSuchElementException();
        return ret;
    }
    public static <E> E last(@This Collection<E> collection, Predicate<? super E> predicate) throws NoSuchElementException
    {
        boolean pass = false;
        E ret = null;
        for (E e : collection) if (predicate.test(e)) { ret = e; pass = true;}
        if (!pass) throw new NoSuchElementException();
        return ret;
    }
    public static <E> E lastOrDefault(@This Collection<E> collection, Predicate<? super E> predicate)
    {
        E ret = null;
        for (E e : collection) if (predicate.test(e)) ret = e;
        return ret;
    }

    public static <E> boolean any(@This Collection<E> collection, Predicate<? super E> predicate)
    {
        return collection.stream().anyMatch(predicate);
    }
    public static <E> boolean all(@This Collection<E> collection, Predicate<? super E> predicate)
    {
        return collection.stream().allMatch(predicate);
    }

    public static <E, R> Stream<R> select(@This Collection<E> collection, Function<? super E, R> mapper) {
        return collection.stream().map(mapper);
    }

    public static <E> boolean isNullOrEmpty(@This Collection<E> collection)
    {
        if (collection == null) return true;
        return collection.isEmpty();
    }
}
