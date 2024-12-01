package logging;

import handlers.RedisHandler;

public class StreamingStrategy implements LoggingStrategy {

    @Override
    public void processIdCount(int count) {
        RedisHandler.addToStream(count);
    }
}
