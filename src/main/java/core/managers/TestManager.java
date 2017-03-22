package core.managers;

import core.MyLogger;
import core.Retry;
import core.TestInfo;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import sun.security.krb5.internal.crypto.Des;

/**
 * Created by Colin on 3/20/2017.
 */
public class TestManager {

    public static TestInfo testinfo = new TestInfo();

    @Rule
    public Retry retry = new Retry(3);

    @Before
    public void before()
    {
        testinfo.reset();
    }

    @Rule
    public TestRule listen = new TestWatcher() {
        @Override
        public void failed(Throwable t, Description description)
        {
            MyLogger.log.info("Test Failed: ");
            TestInfo.printResults();
        }
        @Override
        public void succeeded(Description description)
        {
            MyLogger.log.info("Test Passed: ");
            TestInfo.printResults();
        }
    };

}
