package com.rayyounghong.helper;

/**
 * @author ray
 * @date 2020/6/20
 */
public class DisableInspection {
    /**
     * Some methods for avoiding inspection by IDEA.
     */
    public static void doWhatEver() {

    }

    public static void doWhatEver(int var) {
        System.setProperty("TMP_INT", Integer.toString(var));
    }

    public static void doWhatEver(boolean var) {
        System.setProperty("TMP_BOOLEAN", Boolean.toString(var));
    }

    public static void doWhatEver(char var) {
        System.setProperty("TMP_BOOLEAN", Character.toString(var));
    }

    public static void doWhatEver(long var) {
        System.setProperty("TMP_BOOLEAN", Long.toString(var));
    }

    public static void doWhatEver(float var) {
        System.setProperty("TMP_BOOLEAN", Float.toString(var));
    }

    public static void doWhatEver(double var) {
        System.setProperty("TMP_BOOLEAN", Double.toString(var));
    }

    public static void doWhatEver(String var) {
        System.setProperty("TMP_STRING", var);
    }

    public static <T> void doWhatEver(T var) {
        System.setProperty("TMP_T", var.toString());
    }
}
