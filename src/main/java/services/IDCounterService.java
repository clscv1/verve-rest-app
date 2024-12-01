package services;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class IDCounterService {
    private static final Set<String> idSet = ConcurrentHashMap.newKeySet();

    public static void addId(String id) {
        idSet.add(id);
    }

    public static int getCount() {
        return idSet.size();
    }

    public static void resetIdCount() {
        idSet.clear();
    }

}
