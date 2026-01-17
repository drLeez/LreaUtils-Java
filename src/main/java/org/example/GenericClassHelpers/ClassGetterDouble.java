package org.example.GenericClassHelpers;

public abstract class ClassGetterDouble<A, B> implements ClassGetter
{
    private final Class<A> aClass;
    private final Class<B> bClass;

    @SuppressWarnings("unchecked")
    public ClassGetterDouble()
    {
        var typeArgs = ClassGetter.GetRawTypeArgs(this);
        aClass = (Class<A>) typeArgs[0];
        bClass = (Class<B>) typeArgs[1];
    }

    @Override
    public Class<?>[] getGenericClasses()
    {
        return new Class[]{aClass, bClass};
    }
}
