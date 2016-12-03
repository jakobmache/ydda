package de.mobilityhacks.ydda.youdontdrivealone.car;

import java.net.MalformedURLException;
import java.net.URL;

public class OTPAdapter
{
    private static final String IP = "192.168.189.99:9080/";

    public static final String TAG = OTPAdapter.class.getName();

    public short getFuelLevel() {
        try {
            URL url = new URL(IP + "vehicle?fields=level_fuel");
        }
        catch(MalformedURLException exc) {
        }

        return 0;

    }
}
