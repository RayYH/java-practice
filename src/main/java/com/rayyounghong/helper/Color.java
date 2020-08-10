package com.rayyounghong.helper;

/**
 * Use ANSI escape codes to use color in output, only works for Unix shell prompts. For windows user, you can try
 * <a href="https://github.com/microsoft/terminal"> microsoft terminal. </a>.
 *
 * @author ray
 * @see <a href= "https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println">
 *      how-to-print-color-in-console-using-system-out-println </a>
 */
public class Color {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    /**
     * This method was added to avoid inspection produced by IDEA.
     *
     * @return string.
     */
    public static String showAllConstants() {
        return ANSI_RESET + ANSI_BLACK + ANSI_RED + ANSI_GREEN + ANSI_YELLOW + ANSI_BLUE + ANSI_PURPLE + ANSI_CYAN
            + ANSI_WHITE + ANSI_BLACK_BACKGROUND + ANSI_RED_BACKGROUND + ANSI_GREEN_BACKGROUND + ANSI_YELLOW_BACKGROUND
            + ANSI_BLUE_BACKGROUND + ANSI_PURPLE_BACKGROUND + ANSI_CYAN_BACKGROUND + ANSI_WHITE_BACKGROUND;
    }

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN + "This text has green text but a default background!" + ANSI_RESET);
        System.out.println(ANSI_RED + "This text has red text but a default background!" + ANSI_RESET);
        System.out.println(
            ANSI_GREEN_BACKGROUND + ANSI_WHITE + "This text has a green background and white text!" + ANSI_RESET);
    }
}
