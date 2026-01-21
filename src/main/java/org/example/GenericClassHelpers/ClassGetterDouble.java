package org.example.GenericClassHelpers;

public abstract class ClassGetterDouble<A, B> extends ClassGetter
{
    public ClassGetterDouble()
    {
        super();
    }

    protected ClassGetterDouble(Class<?>[] manual)
    {
        super(manual);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    protected Class<?>[] autoConstruct()
    {
        var typeArgs = ClassGetter.GetRawTypeArgs(this);
        var aClass = (Class<A>) typeArgs[0];
        var bClass = (Class<B>) typeArgs[1];
        return new Class[]{aClass, bClass};
    }
}
