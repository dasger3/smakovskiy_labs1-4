package voronin.service;

import voronin.annotation.ShouldInvoke;
import voronin.model.Fraction;
import voronin.model.ImmutableFraction;
import voronin.model.ImmutableProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReflectionService {

    public ReflectionService () {}

    public List<String> checkIfShouldInvoke(Object object) {
        List<String> invokedMethods = new LinkedList<>();
        try {
            Class<?> clazz = object.getClass();
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ShouldInvoke.class)) {
                    method.setAccessible(true);
                    int parameterCount = method.getParameterCount();
                    if(parameterCount > 0) {
                        method.invoke(object, new Object[parameterCount]);
                    }
                    else {
                        method.invoke(object);
                    }
                    invokedMethods.add(method.getName());
                }
            }
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
        return invokedMethods;
    }

    public List<String> showConstructorList(Object object) {
        List<String> result = new LinkedList<>();
        Class<?> clazz = object.getClass();
        Arrays.stream(clazz.getConstructors()).forEach(x -> result.add(x.toString()));
        return result;
    }

    public String showAccessModifierInformation(Object object) {
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
        result = "Class modifier: " + result;
        return result;
    }

    public ImmutableFraction immutableProxyExample(Fraction cf) {
        return (ImmutableFraction) Proxy.newProxyInstance(
                Fraction.class.getClassLoader(),
                new Class[] { ImmutableFraction.class },
                new ImmutableProxy(cf));
    }
}