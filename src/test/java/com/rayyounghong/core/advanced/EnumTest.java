package com.rayyounghong.core.advanced;

import com.rayyounghong.AppTest;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/6/20
 */
public class EnumTest {
    @Test
    void threadStatesTest() {
        assertEquals(ThreadStates.START.toString(), "START");
        assertEquals(ThreadStates.RUNNING.toString(), "RUNNING");
        assertEquals(ThreadStates.WAITING.toString(), "WAITING");
        assertEquals(ThreadStates.DEAD.toString(), "DEAD");
    }

    @Test
    void testUsingEnumSet() {
        EnumSet<ThreadStatesEnum> enumSet = EnumSet.allOf(ThreadStatesEnum.class);
        int priority = 1;
        for (ThreadStatesEnum threadStatesEnum : enumSet) {
            AppTest.doWhatEver(threadStatesEnum);
            // System.out.println(threadStatesEnum);
            // Output:
            // START implementation. Priority=1
            // Default ThreadStatesConstructors implementation. Priority=2
            // Default ThreadStatesConstructors implementation. Priority=3
            // Default ThreadStatesConstructors implementation. Priority=4
            assertEquals(priority++, threadStatesEnum.getPriority());
        }
    }

    @Test
    void testUsingEnumMapAndSwitchCase() {
        int priority = 1;
        EnumMap<ThreadStatesEnum, String> enumMap = new EnumMap<>(ThreadStatesEnum.class);
        enumMap.put(ThreadStatesEnum.START, "Thread is started");
        enumMap.put(ThreadStatesEnum.RUNNING, "Thread is running");
        enumMap.put(ThreadStatesEnum.WAITING, "Thread is waiting");
        enumMap.put(ThreadStatesEnum.DEAD, "Thread is dead");
        Set<ThreadStatesEnum> keySet = enumMap.keySet();
        for (ThreadStatesEnum key : keySet) {
            AppTest.doWhatEver(key);
            // System.out.println("key=" + key.toString() + ":: value=" + enumMap.get(key));
            // Output:
            // key=START implementation. Priority=1:: value=Thread is started
            // key=Default ThreadStatesConstructors implementation. Priority=2:: value=Thread is running
            // key=Default ThreadStatesConstructors implementation. Priority=3:: value=Thread is waiting
            // key=Default ThreadStatesConstructors implementation. Priority=4:: value=Thread is dead
            assertEquals(priority++, key.getPriority());
        }

        assertEquals(usingEnumInSwitch(ThreadStatesEnum.START), "START thread");
        assertEquals(usingEnumInSwitch(ThreadStatesEnum.WAITING), "WAITING thread");
        assertEquals(usingEnumInSwitch(ThreadStatesEnum.RUNNING), "RUNNING thread");
        assertEquals(usingEnumInSwitch(ThreadStatesEnum.DEAD), "DEAD thread");
    }

    @Test
    void testUsingEnumValues() {
        int priority = 1;
        ThreadStatesEnum[] thArray = ThreadStatesEnum.values();
        for (ThreadStatesEnum th : thArray) {
            // System.out.println(th.toString() + "::priority=" + th.getPriority());
            // output
            // START implementation. Priority=1::priority=1
            // Default ThreadStatesConstructors implementation. Priority=2::priority=2
            // Default ThreadStatesConstructors implementation. Priority=3::priority=3
            // Default ThreadStatesConstructors implementation. Priority=4::priority=4
            assertEquals(priority++, th.getPriority());
        }
    }

    @Test
    void testUsingEnumValueOf() {
        ThreadStatesEnum th = Enum.valueOf(ThreadStatesEnum.class, "START");
        assertEquals(1, th.getPriority());
    }

    @Test
    void testUsingEnumMethods() throws IOException {
        ThreadStatesEnum thc = ThreadStatesEnum.DEAD;
        assertEquals(thc.getPriority(), 4);
        thc = ThreadStatesEnum.START;
        assertEquals(thc.getPriority(), 1);
        thc.setPriority(10);
        assertEquals(thc.getPriority(), 10);
        thc.setPriority(1);
        thc.close();
    }

    private String usingEnumInSwitch(ThreadStatesEnum th) {
        switch (th) {
            case START:
                return "START thread";
            case WAITING:
                return "WAITING thread";
            case RUNNING:
                return "RUNNING thread";
            case DEAD:
                return "DEAD thread";
            default:
                return "";
        }
    }
}
