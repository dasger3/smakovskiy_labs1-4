import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ReflectionService {

    public ReflectionService () {}

    public void checkIfShouldInvoke(Object object) {
        System.out.println("\n----" + object.getClass().getName()+ "----");
        try {
            Class<?> clazz = object.getClass();
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ShouldInvoke.class)) {
                    method.setAccessible(true);
                    int parameterCount = method.getParameterCount();
                    if(parameterCount > 0) {
                        System.out.println("Invoked " + method.getName() + ": " + method.invoke(object, new Object[parameterCount]));
                    }
                    else {
                        System.out.println("Invoked " + method.getName() + ": " + method.invoke(object));
                    }
                }
            }
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public void showConstructorList(Object object) {
        Class<?> clazz = object.getClass();
        System.out.println("\nConstructors list:");
        Arrays.stream(clazz.getConstructors()).forEach(x -> System.out.println(x.toString()));
        System.out.println();
    }

    public void showAccessModifiersInformation(Object object) {
        Class<?> clazz = object.getClass();
        String result;
        switch (clazz.getModifiers()) {
            case 1 ->  result = "public";
            case 2 ->  result = "protected";
            case 3 ->  result = "private";
            case 4 ->  result = "final";
            case 5 ->  result = "static";
            case 6 ->  result = "abstract";
            case 7 ->  result = "interface";
            default -> result = "Unknown modifier";
        }
        System.out.println("Class modifier: " + result);
    }

    public void immutableProxyExample(Fraction cf) {
        ImmutableFraction fraction = (ImmutableFraction) Proxy.newProxyInstance(
                Fraction.class.getClassLoader(),
                new Class[] { ImmutableFraction.class },
                new ImmutableProxy(cf));
        try {
            fraction.getNumerator();
            fraction.setDenominator(1);
        }
        catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}