package com.rayyounghong.core.basic;

import com.rayyounghong.helper.container.BooleanContainer;
import java.util.Calendar;
import java.util.TimeZone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @link https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
 * @author ray
 */
public class FormatTest {

    @Test
    void testFormatString() {
        // decimal
        assertEquals("159", String.format("%d", 159));
        // hexadecimal
        assertEquals("9f", String.format("%x", 159));
        // octal
        assertEquals("237", String.format("%o", 159));

        // %f
        assertEquals("15.9", String.format("%.1f", (float)159 / 10));
        assertEquals("15.90", String.format("%.2f", (float)159 / 10));
        assertEquals("16", String.format("%.0f", (float)159 / 10));

        // %e
        assertEquals("1.6e+01", String.format("%.1e", (float)159 / 10));
        assertEquals("1.59e+01", String.format("%.2e", (float)159 / 10));
        assertEquals("2e+01", String.format("%.0e", (float)159 / 10));

        // %g
        assertEquals("15.9000", String.format("%g", (float)159 / 10));
        assertEquals("16", String.format("%.2g", (float)159 / 10));
        assertEquals("15.9", String.format("%.3g", (float)159 / 10));

        // %a - (1 + fccccc/fffff) * (2^3) = (1+16567500/16777215) * 8 = 15.9000000894
        assertEquals("0x1.fcccccp3", String.format("%a", (float)159 / 10));

        // %s
        String s = "Hello";
        assertEquals("Hello World", String.format("%s World", s));

        // %c
        Character ch = 'H';
        assertEquals("Hello World", String.format("%cello World", ch));

        // %b
        BooleanContainer booleanContainer = new BooleanContainer(true, false);
        assertEquals("isTrue: true", String.format("isTrue: %b", booleanContainer.boolOne));

        // %h - the hashcode is not certain
        assertNotNull(String.format("%h", 123));

        // %%
        assertEquals("%1", String.format("%%%d", 1));

        // %n
        assertEquals(System.lineSeparator(), String.format("%n"));

        // FLAGS

        // +
        assertEquals("+1", String.format("%+d", 1));
        assertEquals("-1", String.format("%+d", -1));
        assertEquals("+3.14", String.format("%+.2f", 3.14));
        assertEquals("-3.14", String.format("%+.2f", -3.14));

        // space
        assertEquals(" 1", String.format("% d", 1));
        assertEquals(" 3.14", String.format("% .2f", 3.14));
        assertEquals("-1", String.format("% d", -1));

        // 0
        assertEquals("0123", String.format("%04d", 123));
        assertEquals("00123", String.format("%05d", 123));

        // -
        assertEquals("123 ", String.format("%-4d", 123));
        assertEquals("123  ", String.format("%-5d", 123));
        assertEquals("Hel  ", String.format("%-5s", "Hel"));

        // (
        assertEquals("123", String.format("%(d", 123));
        assertEquals("(123)", String.format("%(d", -123));
        assertEquals("123.45", String.format("%(.2f", 123.45));
        assertEquals("(123.45)", String.format("%(.2f", -123.45));

        // ,
        assertEquals("1,234,567", String.format("%,d", 1234567));
        assertEquals("1,234,567.89", String.format("%,.2f", 1234567.89));

        // # for decimal
        assertEquals("1234.", String.format("%#.0f", 1234.01));
        assertEquals("1235.", String.format("%#.0f", 1234.57));

        // # for hexadecimal or octal
        assertEquals("0x9f", String.format("%#x", 159));
        assertEquals("0237", String.format("%#o", 159));

        // $
        assertEquals(" d  c  b  a", String.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d"));

        // <
        assertEquals("a b b b", String.format("%s %s %<s %<s", "a", "b"));
    }

    @Test
    void testFormatDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1078884319047L);
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // full datetime
        assertEquals("Wed Mar 10 10:05:19 CST 2004", String.format("%tc", calendar));
        // ISO 8601
        assertEquals("2004-03-10", String.format("%tF", calendar));
        // month/day/year
        assertEquals("03/10/04", String.format("%tD", calendar));
        // Hour:Minute:Second
        assertEquals("10:05:19", String.format("%tT", calendar));
        // Hour:Minute
        assertEquals("10:05", String.format("%tR", calendar));
        // 12-hour clock
        assertEquals("10:05:19 AM", String.format("%tr", calendar));
        // Year
        assertEquals("2004", String.format("%tY", calendar));
        // year - tail 2 number
        assertEquals("04", String.format("%ty", calendar));
        // year - head 2 number
        assertEquals("20", String.format("%tC", calendar));
        // month - full
        assertEquals("March", String.format("%tB", calendar));
        // month - abbr
        assertEquals("Mar", String.format("%tb", calendar));
        assertEquals("Mar", String.format("%th", calendar));
        // month
        assertEquals("03", String.format("%tm", calendar));
        // day - leading zero
        assertEquals("10", String.format("%td", calendar));
        // day
        assertEquals("10", String.format("%te", calendar));
        // week
        assertEquals("Wednesday", String.format("%tA", calendar));
        assertEquals("Wed", String.format("%ta", calendar));
        // day index of year
        assertEquals("070", String.format("%tj", calendar));
        // Hour 0-23 leading zero
        assertEquals("10", String.format("%tH", calendar));
        // Hour 0-23
        assertEquals("10", String.format("%tk", calendar));
        // Hour 0-12 leading zero
        assertEquals("10", String.format("%tI", calendar));
        // Hour 0-12
        assertEquals("10", String.format("%tl", calendar));
        // Minute - leading zero
        assertEquals("05", String.format("%tM", calendar));
        // Second, Millisecond, Nanosecond) - leading zero
        assertEquals("19", String.format("%tS", calendar));
        assertEquals("047", String.format("%tL", calendar));
        assertEquals("047000000", String.format("%tN", calendar));
        // pm or am
        assertEquals("am", String.format("%tp", calendar));
        // GMT RFC822 shift
        assertEquals("+0800", String.format("%tz", calendar));
        // Timezone
        assertEquals("CST", String.format("%tZ", calendar));
        // Timestamp
        assertEquals("1078884319", String.format("%ts", calendar));
        // Micro timestamp
        assertEquals("1078884319047", String.format("%tQ", calendar));
    }
}
