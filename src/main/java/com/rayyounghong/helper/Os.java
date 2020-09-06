package com.rayyounghong.helper;

/**
 * @author ray
 */
public class Os {

    public static OSEnum getOperatingSystem() {
        // detecting the operating system using os.name System property
        String os = System.getProperty("os.name").toLowerCase();

        String win = "win";
        String nix = "nix";
        String nux = "nux";
        String aix = "aix";
        String mac = "mac";
        String sunos = "sunos";
        if (os.contains(win)) {
            return OSEnum.WINDOWS;
        }

        else if (os.contains(nix) || os.contains(nux) || os.contains(aix)) {
            return OSEnum.LINUX;
        }

        else if (os.contains(mac)) {
            return OSEnum.MAC;
        }

        else if (os.contains(sunos)) {
            return OSEnum.SOLARIS;
        }

        return null;
    }

}
