package tests;

import core.MyLogger;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.io.FileWriter;
import java.io.IOException;

import static core.managers.TestManager.jsonArray;

@RunWith(Suite.class)
@Suite.SuiteClasses({Navigation.class, Functionality.class})
public class TestPrimer {

    @AfterClass
    public static void afterClass()
    {
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
