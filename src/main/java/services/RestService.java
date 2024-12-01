package services;

import com.google.gson.Gson;
import handlers.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.util.Map;

public class RestService {
    private static final Gson gson = new Gson();
    public static String processRequest(Request req, Response res) {
        String id = req.queryParams("id");
        String endpoint = req.queryParams("endpoint");

        if (id == null) {
            IDCounterService.addId(id);
            res.status(400);
            return "failed";
        }

        try {
            if (endpoint!=null) {
                Map<String, String> payload = Map.of(
                        "count", String.valueOf(IDCounterService.getCount()),
                        "timestamp", String.valueOf(System.currentTimeMillis()));
                HttpHandler.makeHTTPPostRequest(endpoint,gson.toJson(payload));
            }
            return "ok";
        }
        catch (Exception e) {
            res.status(501);
            return "failed";
        }

    }
}
