package core.constants;

import core.managers.ServerManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.FileReader;
import java.io.ObjectInput;

/**
 * Created by Colin on 3/23/2017.
 */
public class Resources {

    public static final String QUEUE = ServerManager.getWorkingDir() + "/src/main/resources/queue.json";

    public static JSONObject getQueue() throws IOException,  ParseException{
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(QUEUE));
        return (JSONObject) obj;
    }
}
