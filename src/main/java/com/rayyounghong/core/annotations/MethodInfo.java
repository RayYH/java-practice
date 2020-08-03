package com.rayyounghong.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <ol>
 * <li>Annotation methods can’t have parameters.</li>
 * <li>Annotation methods return types are limited to primitives, String, Enums, Annotation or array of these.</li>
 * <li>Java Annotation methods can have default values.</li>
 * <li>Annotations can have meta annotations attached to them. Meta annotations are used to provide information about
 * the annotation.</li>
 * </ol>
 *
 * @author ray
 * @see <a href="https://www.journaldev.com/721/java-annotations">Java Annotations</a>
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Rayyh";

    String date();

    int revision() default 1;

    String comments();
}
