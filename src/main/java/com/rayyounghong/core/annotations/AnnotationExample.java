package com.rayyounghong.core.annotations;

import com.rayyounghong.helper.DisableInspection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ray
 */
public class AnnotationExample {
    @Override
    @MethodInfo(author = "Ray", comments = "Main method", date = "Jun 20 2020", revision = 2)
    public String toString() {
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Jun 20 2020")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @MethodInfo(author = "Ray", comments = "Main method", date = "Jun 20 2020", revision = 10)
    public static void genericsTest() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        DisableInspection.doWhatEver(list);
    }
}

/*
************************************************************************************************************************

Built-in annotations in Java

1. @Override
2. @Deprecated
3. @SuppressWarning
4. @FunctionalInterface
5. @SafeVarargs

1. RetentionPolicy.RUNTIME: The annotation should be available at runtime, for inspection via java reflection.
2. RetentionPolicy.CLASS: The annotation would be in the .class file but it would not be available at runtime.
3. RetentionPolicy.SOURCE: The annotation would be available in the source code of the program, it would neither be in
   the .class file nor be available at the runtime.

************************************************************************************************************************
*/
