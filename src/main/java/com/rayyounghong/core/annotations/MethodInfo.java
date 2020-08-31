package com.rayyounghong.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Java Annotation is metadata about the program embedded in the program itself. Annotations metadata can be available
 * at runtime too and annotation parsers can use it to determine the process flow.
 *
 * Creating custom annotation is similar to writing an interface, except that the interface keyword is prefixed with
 * {@code @} symbol. We can declare methods in annotation.
 *
 * <ol>
 * <li>Annotation methods <strong>can’t have parameters.</strong></li>
 * <li>Annotation methods <strong>return types are limited to primitives, String, Enums, Annotation or array of
 * these.</strong></li>
 * <li>Java Annotation methods <strong>can have default values.</strong></li>
 * <li>Annotations can have meta annotations attached to them. Meta annotations are used to provide information about
 * the annotation.</li>
 * </ol>
 *
 * <p>
 * To determine the target elements of a custom annotation, we need to label it with a {@code @Target} annotation:
 * </p>
 *
 * <ul>
 * <li>{@code ElementType.ANNOTATION_TYPE} can be applied to an annotation type.</li>
 * <li>{@code ElementType.CONSTRUCTOR} can be applied to a constructor.</li>
 * <li>{@code ElementType.FIELD} can be applied to a field or property.</li>
 * <li>{@code ElementType.LOCAL_VARIABLE} can be applied to a local variable.</li>
 * <li>{@code ElementType.METHOD} can be applied to a method-level annotation.</li>
 * <li>{@code ElementType.PACKAGE} can be applied to a package declaration.</li>
 * <li>{@code ElementType.PARAMETER} can be applied to the parameters of a method.</li>
 * <li>{@code ElementType.TYPE} can be applied to any element of a class.</li>
 * </ul>
 *
 * <ol>
 * <li>{@code RetentionPolicy.SOURCE}: Discard during the compile. These annotations don't make any sense after the
 * compile has completed, so they aren't written to the bytecode.</li>
 * <li>{@code RetentionPolicy.CLASS}: Discard during class load. Useful when doing bytecode-level post-processing.
 * Somewhat surprisingly, this is the default.</li>
 * <li>{@code RetentionPolicy.RUNTIME}: Do not discard. The annotation should be available for reflection at runtime.
 * Example: {@code @Deprecated}</li>
 * </ol>
 *
 * @author ray
 * @see <a href="https://www.journaldev.com/721/java-annotations">Java Annotations</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Documented.html">Annotation Type
 *      Documented</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Target.html">Annotation Type Target</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Inherited.html">Annotation Type
 *      Inherited</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Retention.html">Annotation Type
 *      Retention</a>
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
