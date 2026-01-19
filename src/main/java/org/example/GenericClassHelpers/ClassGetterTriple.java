package org.example.GenericClassHelpers;

public class ClassGetterTriple<A, B, C> implements ClassGetter
{
    private final Class<A> aClass;
    private final Class<B> bClass;
    private final Class<C> cClass;

    @SuppressWarnings("unchecked")
    public ClassGetterTriple()
    {
        var typeArgs = ClassGetter.GetRawTypeArgs(this);
        aClass = (Class<A>) typeArgs[0];
        bClass = (Class<B>) typeArgs[1];
        cClass = (Class<C>) typeArgs[2];
    }

    @Override
    public Class<?>[] getGenericClasses()
    {
        return new Class[]{aClass, bClass, cClass};
    }
}
