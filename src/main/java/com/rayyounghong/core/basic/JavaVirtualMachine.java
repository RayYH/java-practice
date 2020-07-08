package com.rayyounghong.core.basic;

/**
 * @author ray
 */
public class JavaVirtualMachine {

}

/*
 ***********************************************************************************************************************
 * Bootstrap Class Loader – It loads JDK internal classes. It loads `rt.jar` and other core classes for example
 * `java.lang.*` package classes.
 *
 * Extensions Class Loader – It loads classes from the JDK extensions directory, usually $JAVA_HOME/lib/ext directory.
 *
 * System Class Loader – This classloader loads classes from the current classpath. We can set classpath while invoking
 *  a program using `-cp` or `-classpath` command line option.
 ***********************************************************************************************************************
 */
