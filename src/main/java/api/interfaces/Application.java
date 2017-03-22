package api.interfaces;

/**
 * Created by Colin on 3/22/2017.
 */
public interface Application {

    void forceStop();
    Object open();
    void clearData();
    String packageID();
    String activityID();

}
