package com.rayyounghong.core.statickeyword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rayyounghong.StandardIOTest;
import com.rayyounghong.helper.DisableInspection;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class StaticBlockTest extends StandardIOTest {
    @Test
    void testStaticBlock() {
        StaticBlock s = new StaticBlock();
        DisableInspection.doWhatEver(s);
        StaticBlock s2 = new StaticBlock();
        DisableInspection.doWhatEver(s2);
        assertEquals("static block! init  init ", outContent.toString());
    }
}
