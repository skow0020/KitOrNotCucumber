package core.managers;

import core.MyLogger;
import core.Retry;
import core.TestInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * Created by Colin on 3/20/2017.
 */
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
            TestInfo.result("Failed");
            MyLogger.log.info("Test Failed: ");
            TestInfo.printResults();
            addToResults();
        }
        @Override
        public void succeeded(Description description)
        {
            TestInfo.result("Passed");
            MyLogger.log.info("Test Passed: ");
            TestInfo.printResults();
            addToResults();
        }
    };

    private void addToResults()
    {
        Map result = new HashMap<String, String>();
        result.put("ID", TestInfo.id());
        result.put("Name", TestInfo.name());
        result.put("Result", TestInfo.result());
        results.add(result);
        jsonArray.add(result);
    }

}
