package com.rayyounghong.core.annotations;

import com.rayyounghong.helper.DisableInspection;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author ray
 */
public class AnnotationParsing {

    /**
     * Output:
     *
     * {@code
     * Annotation in Method 'public java.lang.String com.rayyounghong.core.annotations.AnnotationExample
     * .toString()'
     * : @com.rayyounghong.core.annotations.MethodInfo(author="Ray", revision=2, comments="Main method", date="Jun 20 2020")
     * revision: 2
     * Annotation in Method 'public static void com.rayyounghong.core.annotations.AnnotationExample.oldMethod()' : @java.lang.Deprecated(forRemoval=false, since="")
     * Annotation in Method 'public static void com.rayyounghong.core.annotations.AnnotationExample.oldMethod()' : @com.rayyounghong.core.annotations.MethodInfo(author="Rayyh", revision=1, comments="deprecated method", date="Jun 20 2020")
     * revision: 1
     * Annotation in Method 'public static void com.rayyounghong.core.annotations.AnnotationExample.genericsTest()' : @com.rayyounghong.core.annotations.MethodInfo(author="Ray", revision=10, comments="Main method", date="Jun 20 2020")
     * revision: 10
     * }
     */
    public static void parseAnnotation() {
        try {
            for (Method method : AnnotationParsing.class.getClassLoader()
                .loadClass("com.rayyounghong.core.annotations.AnnotationExample").getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(com.rayyounghong.core.annotations.MethodInfo.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation annotation : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "' : " + annotation);
                        }

                        MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);

                        System.out.println("revision: " + methodInfo.revision());
                    } catch (Throwable e) {
                        DisableInspection.doWhatEver(e);
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            DisableInspection.doWhatEver(e.toString());
        }
    }
}
