package GenericClassUtils;

import org.example.GenericClassHelpers.ClassGetterDouble;
import org.example.GenericClassHelpers.ClassGetterSingle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClassGetterTests
{
    @Test
    public void SingleTest_Simple()
    {
        var test = new SingleExample<String>(){};
        assertEquals(1, test.getGenericClasses().length);
        assertEquals(String.class, test.getGenericClasses()[0]);
    }

    @Test
    public void DoubleTest_Simple()
    {
        var test = new DoubleExample<Integer, Character>(){};
        assertEquals(2, test.getGenericClasses().length);
        assertEquals(Integer.class, test.getGenericClasses()[0]);
        assertEquals(Character.class, test.getGenericClasses()[1]);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class SingleExample<T> extends ClassGetterSingle<T>
    {}

    @SuppressWarnings("InnerClassMayBeStatic")
    private class DoubleExample<T1, T2> extends ClassGetterDouble<T1, T2>
    {}
}