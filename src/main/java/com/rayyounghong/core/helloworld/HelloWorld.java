package com.rayyounghong.core.helloworld;

/**
 * The name of the class and filename should match in Java.
 *
 * main method signature: {@code public static void main(String[] args) { ... }}
 *
 * Java Program(.java) ---(Java Compiler)---> Java Bytecode(.class file) ---(JVM)---> Machine Code ---(CPU)---> Output.
 * <ul>
 * <li>JVM (Java Virtual Machine) is an abstract machine that enables your computer to run a Java program.</li>
 * <li>JRE (Java Runtime Environment) = JVM + Class Libraries.</li>
 * <li>JDK (Java Development Kit) = JRE + Compilers + Debuggers...</li>
 * </ul>
 * Each operating system has different JVM, however the output they produce after execution of bytecode is same across
 * all operating systems. That is why we call java as platform independent language.
 *
 * <a href="https://docs.oracle.com/javase/tutorial/information/glossary.html">Glossary of Terms</a>
 *
 * @author ray
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

/*

 */
