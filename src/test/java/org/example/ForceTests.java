package org.example;

import org.example.ReflectionHelpers.Force;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForceTests
{
    @Test
    public void Get_Success() throws NoSuchFieldException, IllegalAccessException
    {
        var dummy = new Dummy();
        String value = Force.Get(dummy, "_name");
        assertEquals("defaultName", value);
    }

    @Test
    public void GetOrDefault_Success()
    {
        var dummy = new Dummy();
        String value = Force.GetOrDefault(dummy, "_name");
        assertEquals("defaultName", value);
    }

    @Test
    public void Set_Success() throws NoSuchFieldException, IllegalAccessException
    {
        var dummy = new Dummy();
        Force.Set(dummy, "_name", "newName");
        assertEquals("newName", Force.GetOrDefault(dummy, "_name"));
    }

    @Test
    public void get_Success() throws NoSuchFieldException, IllegalAccessException
    {
        var dummy = new Dummy();
        var force = new Force<Dummy, String>(){};
        var value = force.get(dummy, "_name");
        assertEquals("defaultName", value);
    }

    @Test
    public void get_Failure_NoSuchFieldException()
    {
        var dummy = new Dummy();
        var ex = assertThrows(
                NoSuchFieldException.class,
                () -> new Force<Dummy, String>(){}.get(dummy, "_somethingRandom")
        );
        assertTrue(ex.getMessage().contains("_somethingRandom"));
    }

    @Test
    public void getOrDefault_Success()
    {
        var dummy = new Dummy();
        var value = new Force<Dummy, String>(){}.getOrDefault(dummy, "_name");
        assertEquals("defaultName", value);
    }

    @Test
    public void getOrDefault_Success_NULL()
    {
        var dummy = new Dummy();
        var value = new Force<Dummy, String>(){}.getOrDefault(dummy, "_somethingRandom");
        assertNull(value);
    }

    @Test
    public void set_success() throws NoSuchFieldException, IllegalAccessException
    {
        var dummy = new Dummy();
        var force = new Force<Dummy, String>(){};
        force.set(dummy, "_name", "newName");
        var value = force.getOrDefault(dummy, "_name");
        assertEquals("newName", value);
    }

    class Dummy
    {
        private String _name = "defaultName";
        private final int _id = 1;
    }
}