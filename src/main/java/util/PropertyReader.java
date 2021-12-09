package util;

import java.util.ResourceBundle;

public class PropertyReader {

    private static final ResourceBundle trelloBundle = ResourceBundle.getBundle(
            "Trello");

    public static String trelloKey() {
        return trelloBundle.getString("trello.key");
    }

    public static String trelloToken() {
        return trelloBundle.getString("trello.token");
    }

    public static String baseUrl() {
        return trelloBundle.getString("trello.baseURL");
    }

}
