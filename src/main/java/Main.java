import logging.StandardLoggingStrategy;
import logging.StreamingStrategy;
import services.RestService;
import services.SchedulerService;

import static spark.Spark.*;

public class Main {
    public static void main(String args[]) {
        port(8080);
        threadPool(1000);
        get("/api/verve/accept", RestService::processRequest);

        StandardLoggingStrategy standardLoggingStrategy = new StandardLoggingStrategy();
        //StreamingStrategy streamingStrategy = new StreamingStrategy();
        SchedulerService schedulerService = new SchedulerService(standardLoggingStrategy);
        schedulerService.startScheduledTask();

    }
}
