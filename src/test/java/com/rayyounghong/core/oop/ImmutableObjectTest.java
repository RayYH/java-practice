package com.rayyounghong.core.oop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rayyounghong.AppTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Related Readings
 *
 * <a href="https://www.baeldung.com/java-immutable-object">Immutable Objects in Java</a>
 * <a href="https://www.baeldung.com/java-string-immutable">Why String is Immutable in Java</a>
 * <a href="https://www.baeldung.com/java-string-pool">Guide to Java String Pool</a>
 *
 * @author ray
 * @date 2020/1/26
 */
public class ImmutableObjectTest {

    /*
     * ---------------------------------------------------------------------------------------------
     * | Immutable Objects in Java
     * ---------------------------------------------------------------------------------------------
     * 1. An immutable object is an object whose internal state remains constant after it has been
     *    entirely created.
     * 2. In java, variables are mutable by default, meaning we can change the value they hold.
     *    By using the final keyword when declaring a variable, the Java compiler won't let us
     *    change the value of that variable.
     * 3. If we want to make a class immutable, we must rely on the API provided by class to
     *    protect itself from changes. And the place to initialize the internal state of an
     *    immutable object is its constructor.
     * 4. Using the reflection API, we can break immutability and change immutable objects.
     *    However, reflection violates immutable object's public API, and usually, we should avoid
     *    doing this.
     * 5. Since the internal state of an immutable object remains constant in time, we can share it
     *    safely among multiple threads, immutable objects are side-effects free.
     */

    @Test
    void testStringWillNotChangeAndFinalKeyword() {
        // the original String doesn't change
        String original = "Hello World";
        String newStr = original.replace("World", "Java");
        assertEquals("Hello World", original);
        assertEquals("Hello Java", newStr);
        /*
         * the final keyword only forbids us from changing the reference the value holds, it doesn't
         * protect us from changing the internal state of the object it refers by using its public
         * API.
         */
        final List<String> strings = new ArrayList<>();
        assertEquals(0, strings.size());
        strings.add("Ray");
        assertEquals(1, strings.size());
    }

    /*
     * ---------------------------------------------------------------------------------------------
     * | Why String is Immutable in Java?
     * ---------------------------------------------------------------------------------------------
     * 1. String Pool: Java String Pool is the special memory region where Strings are stored by
     *    JVM. Caching the String literals and reusing them saves a lot of heap space because
     *    different String variables refer to the same object in the String Pool.
     * 2. Security: Unreliable source caller method may have reference to a String object, mutable
     *    Strings could lead to degradation of security.
     * 3. Synchronization: If a thread changes the String value, a new String would be created in
     *    the String Pool. Hence, Strings are safe for multi-threading.
     * 4. Hashcode caching: the hashcode() method is overridden in String class to facilitate
     *    caching, the hash is calculated and cached during thr first hashcode() call. This improves
     *     the performance of collections that uses hash implementations when operated with String
     *    objects.
     * 5. Performance: String Pool enhances the performance by saving heap memory and faster access
     *    of hash implementations when operated with Strings.
     */

    /*
     * ---------------------------------------------------------------------------------------------
     * | Guide to Java String Pool
     * ---------------------------------------------------------------------------------------------
     * 1. String Pool is the special memory region where Strings are stored by JVM.
     * 2. interning - Thanks to the immutability of Strings, the JVM can store only one copy of each
     *    literal String in the Pool.
     * 3. How it works: create a String variable - searches the pool - if found, then return the
     *    the reference to its memory address, if not found, it'll be added to the pool(interned).
     * 4. Using the constructor: Every String created via new keyword will point to a different
     *    memory region with its own address.
     * 5. Manually interning: We can manually intern a String in the Java String Pool by calling
     *    the intern() method on the object we want to intern.
     * 6. Garbage Collection: Before Java 7, the JVM placed the Java String Pool in the PermGen
     *    space, which has a fixed size — it can't be expanded at runtime and is not eligible for
     *    garbage collection. So, we can get an OutOfMemory error from the JVM if we intern too many
     *    Strings. From Java 7 onwards, the Java String Pool is stored in the Heap space, which
     *    is garbage collected by the JVM. The advantage of this approach is the reduced risk of
     *    OutOfMemory error because unreferenced Strings will be removed from the pool, thereby
     *    releasing memory.
     * 7. Performance and Optimizations: check below link
     *    https://www.baeldung.com/java-string-pool#performance-and-optimizations
     * 8. A Note about Java 9: Until Java 8, Strings were internally represented as an array of
     *    characters – char[], so that every character uses two bytes of memory.
     *    Java 9 provides Compact Strings, This new format will choose the appropriate encoding
     *    between char[] and byte[] depending on the stored content.
     *    Since the new String representation will use the UTF-16 encoding only when necessary, the
     *    amount of heap memory will be significantly lower, which in turn causes less Garbage
     *    Collector overhead on the JVM.
     */

    @Test
    void testStringPool() {
        String strOne = "Hello Java!";
        String strTwo = "Hello Java!";
        String strThree = new String(
            new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'J', 'a', 'v', 'a', '!'}
        );
        String strFour = new String(
            new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'J', 'a', 'v', 'a', '!'}
        );
        /*
         * 1. (strOne == strTwo) is true.
         * 2. (strOne == strThree) is false.
         * 3. (strThree == strFour) is false.
         */
        AppTest.doWhatEver(strOne);
        AppTest.doWhatEver(strTwo);
        AppTest.doWhatEver(strThree);
        AppTest.doWhatEver(strFour);
    }
}
