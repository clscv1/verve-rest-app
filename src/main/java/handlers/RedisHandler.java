package handlers;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntryID;
import redis.clients.jedis.params.XReadParams;
import redis.clients.jedis.resps.StreamEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisHandler {
    private static final Jedis redis = new Jedis(System.getenv("REDIS_HOST"), Integer.parseInt(System.getenv("REDIS_PORT")));
    private static final String STREAM_NAME = "unique-count-stream";


    public static void addToStream(long count) {
        try {
            Map<String, String> message = new HashMap<>();
            message.put("uniqueCount", String.valueOf(count));
            message.put("timestamp", String.valueOf(System.currentTimeMillis()));

            StreamEntryID id =  redis.xadd(STREAM_NAME, StreamEntryID.NEW_ENTRY, message);
            System.out.println("Added to stream: "+ id.toString());
        }
        catch (Exception e) {
            System.err.println("An error occurred while adding to stream");
            e.printStackTrace();
        }
    }
}
