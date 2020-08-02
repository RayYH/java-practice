package com.rayyounghong.core.oop.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author ray
 */
public class ReflectionTest {

    public static String CONCRETE_CLASS = "com.rayyounghong.core.oop.reflection.ConcreteClass";

    @Test
    @SuppressWarnings({"deprecated"})
    void testGetClassObject() {
        // Get Class using reflection
        Class<?> concreteClass = ConcreteClass.class;
        try {
            // below method is used most of the times in frameworks like JUnit
            // Spring dependency injection, Tomcat web container
            // Eclipse auto completion of method names, hibernate, Struts2 etc.
            // because ConcreteClass is not available at compile time
            concreteClass = Class.forName(CONCRETE_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        assertEquals("com.rayyounghong.core.oop.reflection.ConcreteClass", concreteClass.getCanonicalName());

        Class<?> booleanWrapperClass = Boolean.class;
        assertEquals("java.lang.Boolean", booleanWrapperClass.getCanonicalName());
        Class<?> booleanClass = boolean.class;
        assertEquals("boolean", booleanClass.getCanonicalName());

        try {
            Class<?> cDoubleArray = Class.forName("[D");
            assertEquals("double[]", cDoubleArray.getCanonicalName());
            Class<?> cFloatArray = Class.forName("[F");
            assertEquals("float[]", cFloatArray.getCanonicalName());
            Class<?> cByteArray = Class.forName("[B");
            assertEquals("byte[]", cByteArray.getCanonicalName());
            Class<?> twoDStringArray = String[][].class;
            assertEquals("java.lang.String[][]", twoDStringArray.getCanonicalName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetSuperClass() throws ClassNotFoundException {
        Class<?> superClass = Class.forName(CONCRETE_CLASS).getSuperclass();
        assertEquals("class com.rayyounghong.core.oop.reflection.BaseClass", superClass.toString());
        assertNull(Object.class.getSuperclass());
        assertEquals("class java.lang.Object", String[][].class.getSuperclass().toString());
    }

    @Test
    void testGetPublicMemberClasses() {
        Class<?> concreteClass = ConcreteClass.class;
        // getClasses method returns an array of Class objects including
        // all public classes, interfaces, enums.
        Class<?>[] classes = concreteClass.getClasses();
        ArrayList<String> list = new ArrayList<>();
        for (Class<?> item : classes) {
            list.add(item.toString());
        }
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("interface com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassPublicInterface");
        expectedList.add("class com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassPublicEnum");
        expectedList.add("class com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassPublicClass");
        expectedList.add("class com.rayyounghong.core.oop.reflection.BaseClass$BaseClassMemberEnum");
        expectedList.add("class com.rayyounghong.core.oop.reflection.BaseClass$BaseClassInnerClass");
        assertArrayEquals(list.toArray(), expectedList.toArray());
    }

    @Test
    void testGetDeclaredClasses() {
        Class<?> concreteClass = ConcreteClass.class;
        // returns an array of Class objects reflecting all the classes and interfaces declared as members of the class
        Class<?>[] classes = concreteClass.getDeclaredClasses();
        ArrayList<String> list = new ArrayList<>();
        for (Class<?> item : classes) {
            list.add(item.toString());
        }
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("interface com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassPublicInterface");
        expectedList.add("class com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassPublicEnum");
        expectedList.add("class com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassDefaultEnum");
        expectedList.add("class com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassDefaultClass");
        expectedList.add("class com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassProtectedClass");
        expectedList.add("class com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassPrivateClass");
        expectedList.add("class com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassPublicClass");

        assertArrayEquals(list.toArray(), expectedList.toArray());
    }

    @Test
    void testGetDeclaringClass() throws ClassNotFoundException {
        Class<?> innerClass =
            Class.forName("com.rayyounghong.core.oop.reflection.ConcreteClass$ConcreteClassDefaultClass");
        assertEquals("com.rayyounghong.core.oop.reflection.ConcreteClass",
            innerClass.getDeclaringClass().getCanonicalName());
        assertEquals("com.rayyounghong.core.oop.reflection.ConcreteClass",
            innerClass.getEnclosingClass().getCanonicalName());
    }

    @Test
    void testGetPackageName() throws ClassNotFoundException {
        assertEquals("com.rayyounghong.core.oop.reflection",
            Class.forName("com.rayyounghong.core.oop.reflection.BaseInterface").getPackage().getName());
    }

    @Test
    void testGetClassModifiers() throws ClassNotFoundException {
        Class<?> concreteClass = ConcreteClass.class;
        assertEquals("public", Modifier.toString(concreteClass.getModifiers()));
        assertEquals("public abstract interface",
            Modifier.toString(Class.forName("com.rayyounghong.core.oop.reflection.BaseInterface").getModifiers()));
    }

    @Test
    void testGetTypeParameters() throws ClassNotFoundException {
        TypeVariable<?>[] typeVariables = Class.forName("java.util.HashMap").getTypeParameters();
        assertEquals("[K, V]", Arrays.toString(typeVariables));
    }

    @Test
    void testGetImplementedInterfaces() throws ClassNotFoundException {
        Type[] interfaces = Class.forName("java.util.HashMap").getGenericInterfaces();
        assertEquals("[java.util.Map<K, V>, interface java.lang.Cloneable, interface java.io.Serializable]",
            Arrays.toString(interfaces));
        assertEquals("[interface java.util.Map, interface java.lang.Cloneable, interface java.io.Serializable]",
            Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));
    }

    @Test
    void testGetAllPublicMethods() throws ClassNotFoundException {
        Method[] publicMethods = Class.forName(CONCRETE_CLASS).getMethods();
        assertNotNull(publicMethods);
    }

    @Test
    void testGetAllPublicConstructors() throws ClassNotFoundException {
        Constructor<?>[] publicConstructors = Class.forName(CONCRETE_CLASS).getConstructors();
        // prints public constructors of ConcreteClass
        assertEquals("[public com.rayyounghong.core.oop.reflection.ConcreteClass(int)]",
            Arrays.toString(publicConstructors));
    }

    @Test
    void testGetAllPublicFields() throws ClassNotFoundException {
        Field[] fields = Class.forName(CONCRETE_CLASS).getFields();
        assertEquals("[public int com.rayyounghong.core.oop.reflection.ConcreteClass.publicInt, "
            + "public static final int com.rayyounghong.core.oop.reflection.BaseInterface.INTERFACE_INT, "
            + "public int com.rayyounghong.core.oop.reflection.BaseClass.baseInt]", Arrays.toString(fields));
    }

    @Test
    void testGetPublicField() throws ClassNotFoundException, NoSuchFieldException {
        Field field = Class.forName(CONCRETE_CLASS).getField("INTERFACE_INT");
        assertNotNull(field);
        assertThrows(NoSuchFieldException.class, () -> {
            Field field2 = Class.forName(CONCRETE_CLASS).getField("NOT_EXISTS_FIELD");
            assertNull(field2);
        });
    }

    @Test
    void testGetAllAnnotations() throws ClassNotFoundException {
        Annotation[] annotations = Class.forName(CONCRETE_CLASS).getAnnotations();
        assertEquals("[@java.lang.Deprecated(forRemoval=false, since=\"\")]", Arrays.toString(annotations));
    }

    @Test
    void testFieldDeclaringClass() throws ClassNotFoundException, NoSuchFieldException {
        Field field = Class.forName(CONCRETE_CLASS).getField("INTERFACE_INT");
        Class<?> fieldClass = field.getDeclaringClass();
        assertEquals("com.rayyounghong.core.oop.reflection.BaseInterface", fieldClass.getCanonicalName());
    }

    @Test
    void testGetFieldType() throws ClassNotFoundException, NoSuchFieldException {
        Field field = Class.forName(CONCRETE_CLASS).getField("publicInt");
        Class<?> fieldType = field.getType();
        assertEquals("int", fieldType.toString());
    }

    @Test
    void testGetAndSetPublicFieldValue() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Field field = Class.forName(CONCRETE_CLASS).getField("publicInt");
        ConcreteClass concreteClass = new ConcreteClass(5);
        assertEquals(5, field.get(concreteClass));
        field.setInt(concreteClass, 10);
        assertEquals(10, field.get(concreteClass));
    }

    @Test
    void testGetAndSetPrivateFieldValue() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // here should use getDeclaredField instead of getField
        Field privateField = Class.forName(CONCRETE_CLASS).getDeclaredField("privateString");
        ConcreteClass concreteClass = new ConcreteClass(5);
        privateField.setAccessible(true);
        assertEquals("private string", privateField.get(concreteClass));
        privateField.set(concreteClass, "private string updated");
        assertEquals("private string updated", privateField.get(concreteClass));
    }

    @Test
    void testGetPublicMethod() throws ClassNotFoundException, NoSuchMethodException {
        Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
        assertEquals("[class java.lang.Object, class java.lang.Object]", Arrays.toString(method.getParameterTypes()));
        assertEquals("class java.lang.Object", method.getReturnType().toString());
        assertEquals("public", Modifier.toString(method.getModifiers()));
    }

    @Test
    void testInvokingPublicMethod()
        throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
        Map<String, String> hm = new HashMap<>();
        method.invoke(hm, "key", "value");
        assertEquals("{key=value}", hm.toString());
    }

    @Test
    void testInvokingPrivateMethod()
        throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Class.forName("com.rayyounghong.core.oop.reflection.BaseClass").getDeclaredMethod("method3");
        method.setAccessible(true);
        assertEquals("Method3", method.invoke(null));
    }

    @Test
    void testGetPublicConstructors() throws ClassNotFoundException, NoSuchMethodException {
        Constructor<?> constructor = Class.forName(CONCRETE_CLASS).getConstructor(int.class);
        assertEquals("[int]", Arrays.toString(constructor.getParameterTypes()));
        Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor();
        assertEquals("[]", Arrays.toString(hashMapConstructor.getParameterTypes()));
    }

    @Test
    void testInitializeObjectUsingConstructor() throws ClassNotFoundException, NoSuchMethodException,
        IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = Class.forName(CONCRETE_CLASS).getConstructor(int.class);
        Object obj = constructor.newInstance(10);
        Method method = obj.getClass().getMethod("method1");
        assertEquals("Method1 impl.", method.invoke(obj));
        Constructor<?> hashmapConstructor = Class.forName("java.util.HashMap").getConstructor();
        HashMap<String, String> hashmap = (HashMap<String, String>)hashmapConstructor.newInstance();
        hashmap.put("name", "Ray");
        assertEquals("Ray", hashmap.get("name"));
    }
}
