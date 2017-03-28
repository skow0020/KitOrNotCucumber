package core.managers;

import core.MyLogger;
import core.Retry;
import core.TestInfo;
import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.*;

public class TestManager {

    public static TestInfo testinfo = new TestInfo();
    public static List<Object> results = new ArrayList<Object>();
    public static JSONArray jsonArray = new JSONArray();

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
            testinfo.result("Failed");
            testinfo.notes(t.getLocalizedMessage());
            MyLogger.log.info("Test Failed: ");
            testinfo.printResults();
            addToResults();
        }
        @Override
        public void succeeded(Description description)
        {
            TestInfo.result("Passed");
            testinfo.notes("");
            MyLogger.log.info("Test Passed: ");
            testinfo.printResults();
            addToResults();
        }
    };

    private void addToResults()
    {
        Map result = new HashMap<String, String>();
        result.put("ID", TestInfo.id());
        result.put("Name", TestInfo.name());
        result.put("Suite", TestInfo.suite());
        result.put("Result", TestInfo.result());
        result.put("Message", TestInfo.notes());
        results.add(result);
        jsonArray.add(result);
    }

}
