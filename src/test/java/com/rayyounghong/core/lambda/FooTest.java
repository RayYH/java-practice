package com.rayyounghong.core.lambda;

import java.util.function.Function;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * lambda expression: deferred execution.
 *
 * @author ray
 */
public class FooTest {
    @Test
    void testFoo() {
        Foo foo = parameter -> parameter + " from lambda";
        UseFoo useFoo = new UseFoo();
        assertEquals("message from lambda", useFoo.add("message", foo));
        Function<String, String> fn = (parameter) -> {
            // this -> outer class
            assertEquals(this.getClass(), FooTest.class);
            return parameter + " from lambda";
        };
        assertEquals(useFoo.anotherAdd("Message", fn), "Message from lambda");
    }

    @Test
    void testInnerClass() {
        // can be replaced with lambda expression
        Foo fooByIC = new Foo() {
            @Override
            public String method(String string) {
                return string + " from foo";
            }
        };
        UseFoo useFoo = new UseFoo();
        assertEquals("message from foo", useFoo.add("message", fooByIC));
    }

    @Test
    void testDifferenceBetweenInnerclassAndLambda() {
        UseFoo useFoo = new UseFoo();
        assertEquals(useFoo.scopeExperiment(),
            "Results: resultInnerClass = Inner class value, resultLambda = Enclosing scope value");
    }
}
