package org.example.GenericClassHelpers;

public abstract class ClassGetterSingle<A> implements ClassGetter
{
    private final Class<A> aClass;

    @SuppressWarnings("unchecked")
    public ClassGetterSingle()
    {
        var typeArgs = ClassGetter.GetRawTypeArgs(this);
        aClass = (Class<A>) typeArgs[0];
    }

    @Override
    public Class<?>[] getGenericClasses() {
        return new Class[]{aClass};
    }
}
