package org.example;

import org.example.GenericClassHelpers.ClassGetterDouble;
import org.example.GenericClassHelpers.ClassGetterSingle;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        // TODO: remove all this impromptu Main testing later...

        var test1 = new SingleExample<String>(){};
        System.out.println(String.join(", ", Arrays.stream(test1.genericClasses).map(Class::getName).toList()));

        var test2 = new DoubleExample<Integer, Character>(){};
        System.out.println(String.join(", ", Arrays.stream(test2.genericClasses).map(Class::getName).toList()));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private static class SingleExample<T> extends ClassGetterSingle<T>
    {}

    @SuppressWarnings("InnerClassMayBeStatic")
    private static class DoubleExample<T1, T2> extends ClassGetterDouble<T1, T2>
    {}
}