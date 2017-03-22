import core.managers.DriverManager;
import core.MyLogger;
import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;
import tests.TestPrimer;

public class Runner {
    public static void main(String[] args) {
        MyLogger.log.setLevel(Level.INFO); //Enable different logging levels : INFO, DEBUG, ERRROR, etc

        try {
            DriverManager.createDriver();
            JUnitCore.runClasses(TestPrimer.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
            DriverManager.killDriver();
        }
    }
}