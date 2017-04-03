package step_definitions;

import api.android.Android;
import api.apps.kitOrNot.KitTest;
import core.MyLogger;
import core.TestInfo;
import core.managers.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Level;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Colin on 3/29/2017.
 */
public class Hooks {
    public static Scenario scenario;
    private static KitTest kitTest = Android.app.kitTest;
    private static TestInfo testinfo = new TestInfo();
    private static List<Object> results = new ArrayList<Object>();
    private static JSONArray jsonArray = new JSONArray();
    private static boolean dunit = false;

    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;

        if(!dunit) {
            try {
                MyLogger.log.setLevel(Level.INFO); //Enable different logging levels : INFO, DEBUG, ERRROR, etc
                DriverManager.createDriver();
                kitTest.open();

                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        MyLogger.log.info("Ending run and killing driver");
                        DriverManager.killDriver();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            dunit = true;
        }
    }

    @After
    public void afterScenario(Scenario scenario) {

        Map result = new HashMap<String, String>();
        result.put("ID", TestInfo.id());
        result.put("Name", TestInfo.name());
        result.put("Suite", TestInfo.suite());
        result.put("Result", scenario.getStatus());
        result.put("Message", TestInfo.notes());
        results.add(result);
        jsonArray.add(result);

        FileWriter file;
        try
        {
            MyLogger.log.info("Adding results.json file ");
            file = new FileWriter("results.json");
            file.write(jsonArray.toJSONString());
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
