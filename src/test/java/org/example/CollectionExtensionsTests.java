package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionExtensionsTests
{
    @Test
    public void where()
    {
        var before = List.of("a", "b", "c");
        var after = before.where(x -> x.equals("a")).toList();
        assertEquals(1, after.length);
        assertEquals("a", after.get(0));
    }
}
