package handlers;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpHandler {
    private static final OkHttpClient client = new OkHttpClient();
    private static final Logger logger = LoggerFactory.getLogger(HttpHandler.class);

    public static void makeHttpGetRequest(String endpoint) throws IOException {
        try {
            Request request = new Request.Builder()
                    .url(endpoint)
                    .get()
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    logger.error("Request failed with an exception: " + e.getMessage());
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        logger.info("Request succeeded with code: "+ response.code());
                    }
                    else {
                        logger.warn("Request failed with code: "+ response.code());
                    }
                }
            });

        }
        catch (Exception e) {
            throw e;
        }

    }

    public static void makeHTTPPostRequest(String endpoint, String body) {
        try {
            Request request = new Request.Builder()
                    .url(endpoint)
                    .post(RequestBody.create(body.getBytes(StandardCharsets.UTF_8)))
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    logger.error("Request failed with an exception: " + e.getMessage());
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) {
                    if (response.isSuccessful()) {
                        logger.info("Request succeeded with code: "+ response.code());
                    }
                    else {
                        logger.warn("Request failed with code: "+ response.code());
                    }
                }
            });

        }
        catch (Exception e) {
            throw e;
        }
    }
}
