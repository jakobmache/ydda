package de.mobilityhacks.ydda.youdontdrivealone;

import org.junit.Test;

import de.mobilityhacks.ydda.youdontdrivealone.car.OTPAdapter;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        OTPAdapter adapter = new OTPAdapter();
        adapter.getRpm();
    }
}