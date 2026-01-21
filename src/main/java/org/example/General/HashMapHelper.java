package org.example.General;

import java.util.HashMap;
import java.util.function.Supplier;

public class HashMapHelper
{
    public static <K, V> V GetOrMake(HashMap<K, V> map, K key, Supplier<V> generate)
    {
        var find = map.get(key);
        if (find == null)
        {
            find = generate.get();
            map.put(key, find);
        }
        return find;
    }
}
