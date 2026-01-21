package org.example.GenericClassHelpers;

public abstract class ClassGetterSingle<A> extends ClassGetter
{
    public ClassGetterSingle()
    {
        super();
    }

    protected ClassGetterSingle(Class<?>[] manual)
    {
        super(manual);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<?>[] autoConstruct()
    {
        var typeArgs = ClassGetter.GetRawTypeArgs(this);
        var aClass = (Class<A>) typeArgs[0];
        return new Class[]{aClass};
    }
}
