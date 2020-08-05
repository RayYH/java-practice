package com.rayyounghong.core.lambda;

import java.util.function.Function;

/**
 * @author ray
 */
public class UseFoo {
    private final String value = "Enclosing scope value";

    public String add(String string, Foo foo) {
        return foo.method(string);
    }

    public String anotherAdd(String string, Function<String, String> fn) {
        return fn.apply(string);
    }

    public String scopeExperiment() {
        Foo fooInnerClass = new Foo() {
            final String value = "Inner class value";

            @Override
            public String method(String string) {
                return this.value;
            }
        };
        String resultInnerClass = fooInnerClass.method("");

        Foo fooLambda = parameter -> {
            // will never be used.
            // String value = "Lambda value";
            return this.value;
        };
        String resultLambda = fooLambda.method("");

        return "Results: resultInnerClass = " + resultInnerClass + ", resultLambda = " + resultLambda;
    }
}
