package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.SchedulerService;

public class StandardLoggingStrategy implements LoggingStrategy{
    private static final Logger logger = LoggerFactory.getLogger(StandardLoggingStrategy.class);


    @Override
    public void processIdCount(int count) {
        logger.info("Count of unique requests: "+count);
    }
}
