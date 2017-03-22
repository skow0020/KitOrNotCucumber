package core.constants;

import io.appium.java_client.service.local.flags.ServerArgument;

/**
 * Created by Colin on 3/22/2017.
 */
public enum Arg implements ServerArgument {

    TIMEOUT("--command-timeout"),
    LOG_LEVEL("--log-level");

    private final String arg;

    Arg(String arg){
        this.arg = arg;
    }

    @Override
    public String getArgument() { return arg; }
}
