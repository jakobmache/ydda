package de.mobilityhacks.ydda.youdontdrivealone.car;


public class ByteDifference
{

    private byte start;
    private byte stop;

    public void setStart(OTPAdapter adapter, String param, byte value) {
        start = adapter.getByteProperty(param, value);
    }

    public void stop(OTPAdapter adapter, String param, byte value) {
        stop = adapter.getByteProperty(param, value);
    }

    public byte difference() {
        return (byte)(stop - start);
    }

}
