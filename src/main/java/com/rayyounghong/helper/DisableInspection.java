package com.rayyounghong.helper;

/**
 * This class provides a generic method doWhatEver for avoiding inspection produced by IDEA.
 *
 * @author ray
 */
public class DisableInspection {
    public static void doWhatEver() {}

    public static <T> void doWhatEver(T var) {
        System.setProperty("TMP_T", var.toString());
    }
}
