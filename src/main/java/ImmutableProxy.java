import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ImmutableProxy implements InvocationHandler {

    private final Object target;

    public ImmutableProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("set")) throw new RuntimeException("Cannot use setter in immutable objects");
        return method.invoke(target, args);
    }
}
