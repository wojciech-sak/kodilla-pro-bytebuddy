package com.kodilla.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;

public class BuddyApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> dynamicBookClass = new ByteBuddy()
                .subclass(Book.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello my Buddy!"))
                .make()
                .load(Book.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Class[] parameterTypes = { String.class, String.class, int.class };

        System.out.println(dynamicBookClass
                        .getDeclaredConstructor(parameterTypes)
                .newInstance("title", "author", 2010));
    }
}
