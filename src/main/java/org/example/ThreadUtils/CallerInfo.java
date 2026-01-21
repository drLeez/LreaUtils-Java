package org.example.ThreadUtils;

import java.lang.StackWalker.StackFrame;

public class CallerInfo
{
    public static String GetFilePath()
    {
        return StackWalker.getInstance()
            .walk(frames -> frames
                .skip(1)
                .findFirst()
                .map(StackFrame::getFileName)
                .orElse(null)
            );
    }

    public static String GetMethodName()
    {
        return StackWalker.getInstance()
            .walk(frames -> frames
                .skip(1)
                .findFirst()
                .map(StackFrame::getMethodName)
                .orElse(null)
            );
    }
}
