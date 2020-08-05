package com.rayyounghong.core.trykeyword;

import com.rayyounghong.helper.DisableInspection;
import com.rayyounghong.helper.Order;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author ray
 */
public class TryTest {
    private int getLength() {
        return 2;
    }

    private void throwsAnException() throws CustomException {
        throw new CustomException();
    }

    @Test
    void testTryCatchException() {
        int length = getLength();
        int lengthPlusOne = getLength() + 1;
        try {
            int[] a = new int[length];
            for (int i = 0; i < length; i++) {
                a[i] = 0;
            }
            System.out.println(a[lengthPlusOne]);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals(e.getClass(), ArrayIndexOutOfBoundsException.class);
            assertEquals(e.getMessage(), String.format("Index %d out of bounds for length %d", lengthPlusOne, length));
        }
    }

    @Test
    void testTryCatchMultiExceptions() {
        int length = getLength();
        int lengthPlusOne = getLength() + 1;
        try {
            FileInputStream fileInputStream = new FileInputStream("NON-EXISTS-FILE");
            byte x = (byte)fileInputStream.read();
            DisableInspection.doWhatEver(x);
            int[] a = new int[length];
            for (int i = 0; i < length; i++) {
                a[i] = 0;
            }
            System.out.println(a[lengthPlusOne]);
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    void testThrowsAnException() {
        assertThrows(CustomException.class, this::throwsAnException);
    }

    @Test
    void testTryWithFinallyBlock() {
        int number = 1;
        int length = getLength();
        int lengthPlusOne = getLength() + 1;
        try {
            int[] a = new int[length];
            for (int i = 0; i < length; i++) {
                a[i] = 0;
            }
            System.out.println(a[lengthPlusOne]);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals(e.getClass(), ArrayIndexOutOfBoundsException.class);
            assertEquals(e.getMessage(), String.format("Index %d out of bounds for length %d", lengthPlusOne, length));
        } finally {
            number++;
        }
        assertEquals(number, 2);
    }

    @Test
    void testTryWithResources() {
        String userDirectory = System.getProperty("user.dir");
        String testResourceDir = userDirectory + "/src/test/resources";
        // Resources declared in a try block will be closed when after the execution of that block
        try (PrintWriter writer = new PrintWriter(new File(testResourceDir + "/test-try-with-resources.txt"))) {
            writer.println("JAVA PRACTICE!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Read the content
        try (Scanner scanner = new Scanner(new File(testResourceDir + "/test-try-with-resources.txt"))) {
            while (scanner.hasNext()) {
                DisableInspection.doWhatEver(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Multiple resources can be declared in a try-with-resources block by separating them
        // with a semicolon
        try (Scanner scanner = new Scanner(new File(testResourceDir + "/test-try-with-resources.txt"));
            PrintWriter writer = new PrintWriter(new File(testResourceDir + "/test-try-with-resources-write.txt"))) {
            while (scanner.hasNext()) {
                writer.print("NEW " + scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAutoCloseResourcesInvokeOrder() {
        /*
         * To construct a custom resource that will be correctly handled by a try-with-resources
         * block, the class should implement the Closeable or AutoCloseable interfaces, and
         * override the close method.
         */

        try (MyResourceOne mro = new MyResourceOne(); MyResourceTwo mrt = new MyResourceTwo()) {
            mrt.doSomething();
            mro.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Resources that were defined/acquired first will be closed last.
        // Check below invoke order.
        ArrayList<String> predictedOrders = new ArrayList<>(Arrays.asList("Constructor One.", "Constructor Two.",
            "Do Something Two.", "Do Something One.", "Closed Two.", "Closed One."));
        assertArrayEquals(predictedOrders.toArray(), Order.orders.toArray());
        Order.orders.clear();
    }
}
