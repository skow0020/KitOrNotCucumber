package core;

import javax.print.attribute.standard.MediaSize;

/**
 * Created by Colin on 3/20/2017.
 */
public class TestInfo {
    private static String
        TIMESTAMP,
        SUITE,
        ID,
        NAME,
        NOTES,
        EXPECTED,
        ACTUAL,
        VERSION,
        RESULT;

    public void reset()
    {
        TIMESTAMP = null;
        SUITE = null;
        ID = null;
        NAME = null;
        NOTES = null;
        EXPECTED = null;
        ACTUAL = null;
        VERSION = null;
        RESULT = null;
    }

    public TestInfo timestamp(String value)
    {
        TIMESTAMP = value;
        return this;
    }

    public TestInfo suite(String value)
    {
        SUITE = value;
        return this;
    }

    public TestInfo id(String value)
    {
        ID = value;
        return this;
    }

    public TestInfo name(String value)
    {
        NAME = value;
        return this;
    }

    public TestInfo notes(String value)
    {
        NOTES = value;
        return this;
    }

    public TestInfo expected(String value)
    {
        EXPECTED = value;
        return this;
    }

    public TestInfo actual(String value)
    {
        ACTUAL = value;
        return this;
    }

    public TestInfo version(String value)
    {
        VERSION = value;
        return this;
    }

    public static void result(String result)
    {
        VERSION = result;
    }

    public static String timestamp()
    {
        return TIMESTAMP;
    }

    public static String suite()
    {
        return SUITE;
    }

    public static String id()
    {
        return ID;
    }

    public static String name()
    {
        return NAME;
    }

    public static String notes()
    {
        return NOTES;
    }

    public static String expected()
    {
        return EXPECTED;
    }

    public static String actual()
    {
        return ACTUAL;
    }

    public static String version()
    {
        return VERSION;
    }

    public static String result() { return RESULT; }

    public static void printResults()
    {
        MyLogger.log.info("Test ID: " + id());
        MyLogger.log.info("Test Name: " + name());
        MyLogger.log.info("Test Suite: " + suite());
    }
}
