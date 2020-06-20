package com.rayyounghong.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rayyounghong.AppTest;
import java.util.Random;
import org.junit.jupiter.api.Test;

class ControlFlowTest {

    final static int START = 0;
    final static int END = 5;

    @Test
    public void testIf() {
        Random random = new Random();
        int i = random.nextInt(6);
        // Simple if-else
        if (i > 3) {
            AppTest.doWhatEver();
        } else {
            AppTest.doWhatEver(i);
        }
        // nested if
        if (i >= 3) {
            if (i < 4) {
                AppTest.doWhatEver();
            }
        }
        // if-elseif-else
        if (i > 3) {
            AppTest.doWhatEver();
        } else if (i == 3) {
            AppTest.doWhatEver();
        } else {
            AppTest.doWhatEver();
        }
    }

    /*
     * the type of value used in case statement can be: byte, short, char, int, enumerated types,
     * String class, and some Wrapper classes: Character, Byte, Short, and Integer.
     */
    @Test
    public void testSwitchCase() {
        Random random = new Random();
        // i can be 0 1 2
        int i = random.nextInt(3);
        // with no break
        switch (i) {
            case 0:
                AppTest.doWhatEver();
            case 1:
                AppTest.doWhatEver();
            case 2:
                AppTest.doWhatEver();
            default:
                AppTest.doWhatEver();
        }
        // with break
        switch (i) {
            case 0:
                AppTest.doWhatEver(0);
                break;
            case 1:
                AppTest.doWhatEver(1);
                break;
            case 2:
                AppTest.doWhatEver(2);
                break;
            default:
                AppTest.doWhatEver(3);
                break;
        }
    }

    @Test
    public void showCases() {
        ControlFlowTest.whileLoop();
        ControlFlowTest.doWhileLoop();
        ControlFlowTest.forLoop();
        ControlFlowTest.foreachLoop();
        ControlFlowTest.breakLoop();
        ControlFlowTest.continueLoop();
    }

    public static void whileLoop() {
        StringBuilder res = new StringBuilder();
        int i = START;
        while (i++ < END) {
            res.append(i).append(" ");
        }
        AppTest.doWhatEver(res.toString());
    }

    public static void doWhileLoop() {
        StringBuilder res = new StringBuilder();
        int i = START;
        do {
            res.append(i).append(" ");
        } while (i++ < END);
        AppTest.doWhatEver(res.toString());
    }

    public static void forLoop() {
        StringBuilder res = new StringBuilder();
        for (int i = START; i < END; i++) {
            res.append(i).append(" ");
        }
        AppTest.doWhatEver(res.toString());
    }

    public static void foreachLoop() {
        StringBuilder res = new StringBuilder();
        String[] strings = {" ", " ", " "};
        int i = START;
        for (String s : strings) {
            res.append(i++).append(s);
        }
        AppTest.doWhatEver(res.toString());
    }

    public static void breakLoop() {
        StringBuilder res = new StringBuilder();
        for (int i = START; i < END; i++) {
            if (i == 2) {
                break;
            }
            res.append(i).append(" ");
        }
        AppTest.doWhatEver(res.toString());
    }

    public static void continueLoop() {
        StringBuilder res = new StringBuilder();
        for (int i = START; i < END; i++) {
            if (i == 2) {
                continue;
            }
            res.append(i).append(" ");
        }
        AppTest.doWhatEver(res.toString());
    }

    /**
     * @link https://docs.oracle.com/javase/tutorial/java/nutsandbolts/examples/BreakWithLabelDemo.java
     *
     *       <p>
     *       Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
     *       <p>
     *       Redistribution and use in source and binary forms, with or without modification, are permitted provided
     *       that the following conditions are met:
     *       <p>
     *       - Redistributions of source code must retain the above copyright notice, this list of conditions and the
     *       following disclaimer.
     *       <p>
     *       - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
     *       following disclaimer in the documentation and/or other materials provided with the distribution.
     *       <p>
     *       - Neither the name of Oracle or the names of its contributors may be used to endorse or promote products
     *       derived from this software without specific prior written permission.
     *       <p>
     *       THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
     *       WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
     *       PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY
     *       DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
     *       PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
     *       HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
     *       NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
     *       POSSIBILITY OF SUCH DAMAGE.
     */
    @Test
    void testBreak() {
        int index = 4;
        int[] arrayOfInts = {32, 87, 3, 589, 12, 1076, 2000, 8, 622, 127};
        int searchFor = arrayOfInts[index];
        int i;
        boolean foundIt = false;

        for (i = 0; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] == searchFor) {
                foundIt = true;
                break;
            }
        }

        if (foundIt) {
            assertEquals(i, index);
        }
    }

    @Test
    void testWithLabelBreak() {
        int[][] arrayOfInts = {{32, 87, 3, 589}, {12, 1076, 2000, 8}, {622, 127, 77, 955}};
        int iIndex = 1;
        int jIndex = 0;
        int searchFor = arrayOfInts[iIndex][jIndex];
        int i;
        int j = 0;
        boolean foundIt = false;

        search:
        for (i = 0; i < arrayOfInts.length; i++) {
            for (j = 0; j < arrayOfInts[i].length; j++) {
                if (arrayOfInts[i][j] == searchFor) {
                    foundIt = true;
                    break search;
                }
            }
        }

        if (foundIt) {
            assertEquals(i, iIndex);
            assertEquals(j, jIndex);
        }
    }
}
