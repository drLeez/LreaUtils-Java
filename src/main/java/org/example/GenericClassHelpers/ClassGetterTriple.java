package org.example.GenericClassHelpers;

public class ClassGetterTriple<A, B, C> extends ClassGetter
{
    public ClassGetterTriple()
    {
        super();
    }

    protected ClassGetterTriple(Class<?>[] manual)
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
        var cClass = (Class<C>) typeArgs[2];
        return new Class[]{aClass, bClass, cClass};
    }
}
