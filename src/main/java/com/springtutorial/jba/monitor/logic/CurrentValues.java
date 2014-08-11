package main.java.com.springtutorial.jba.monitor.logic;

import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;

import java.io.IOException;
import java.util.TreeMap;

import com.sun.jna.platform.win32.Advapi32Util;

public class CurrentValues {

    private static int interval = 2000; // 2 seconds
    private static final String AIDA_REG_PATH = "Software\\FinalWire\\AIDA64\\SensorValues";
    public static TreeMap<String, Object> AIDA_READS;

    public static void update() throws IOException, InterruptedException {
        AIDA_READS = Advapi32Util.registryGetValues(HKEY_CURRENT_USER, AIDA_REG_PATH);
    }

    public static TreeMap<String, Object> getValues() {
        try {
            CurrentValues.update();
            return AIDA_READS;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
