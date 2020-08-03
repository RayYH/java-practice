package com.rayyounghong.core.jvm;

/**
 * <li>Bootstrap Class Loader – It loads JDK internal classes. It loads {@code rt.jar} and other core classes for
 * example {@code java.lang.*} package classes.</li>
 * <Li>Extensions Class Loader – It loads classes from the JDK extensions directory, usually {@code $JAVA_HOME/lib/ext}
 * directory.</Li>
 * <li>System Class Loader – This classloader loads classes from the current classpath. We can set classpath while
 * invoking a program using {@code -cp} or {@code -classpath} command line option.</li>
 *
 * @author ray
 */
public class JavaVirtualMachine {

}
