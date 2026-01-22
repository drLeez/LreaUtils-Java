package org.example.extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

@Extension
public class StringExtensions
{
    public static boolean isNullOrWhitespace(@This String string)
    {
        return string == null || string.trim().isEmpty();
    }
}
