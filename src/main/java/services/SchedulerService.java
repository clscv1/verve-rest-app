package services;

import logging.LoggingStrategy;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SchedulerService {
    private LoggingStrategy loggingStrategy;

    public SchedulerService(LoggingStrategy loggingStrategy) {
        this.loggingStrategy=loggingStrategy;
    }

    public void setLoggingStrategy(LoggingStrategy loggingStrategy) {
        this.loggingStrategy=loggingStrategy;
    }

    public void startScheduledTask() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(()-> {
            this.loggingStrategy.processIdCount(IDCounterService.getCount());
            IDCounterService.resetIdCount();

        },0,1, TimeUnit.MINUTES);

    }
}
