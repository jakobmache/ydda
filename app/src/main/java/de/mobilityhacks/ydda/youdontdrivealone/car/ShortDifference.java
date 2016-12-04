package de.mobilityhacks.ydda.youdontdrivealone.car;


public class ShortDifference
{

    private short start;
    private short stop;

    public void setStart(OTPAdapter adapter, String param, short value) {
        start = adapter.getShortProperty(param, value);
    }

    public void stop(OTPAdapter adapter, String param, short value) {
        stop = adapter.getShortProperty(param, value);
    }

    public short difference() {
        return (short)(stop - start);
    }

}
