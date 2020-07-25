package com.rayyounghong.core.helloworld;

/**
 * The name of the class and filename should match in Java.
 *
 * main method signature: {@code public static void main(String[] args) { ... }}
 *
 * @author ray
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

/*
 * Java Program(.java) ---(Java Compiler)---> Java Bytecode(.class file) ---(JVM)---> Machine Code ---(CPU)---> Output.
 *
 * JVM (Java Virtual Machine) is an abstract machine that enables your computer to run a Java program.
 * JRE (Java Runtime Environment) = JVM + Class Libraries.
 * JDK (Java Development Kit) = JRE + Compilers + Debuggers...
 *
 * Each operating system has different JVM, however the output they produce after execution of bytecode is same across
 * all operating systems. That is why we call java as platform independent language.
 *
 * see: https://docs.oracle.com/javase/tutorial/information/glossary.html
 */
