package com.qenetech.charitywithbooks.api;

import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by davescof on 4/30/17.
 */

public class Api {

    public static final String RESULT_OK = "OK";
    public static final String RESULT_ERROR = "ERROR";

    private static final String BASE_URL = "https://192.168.1.1/api/";
    private static final String GET_USER_URL = BASE_URL + "users";
    private static final String USER_REGISTER_URL = GET_USER_URL + "/register";

    // Connect to Api and retrieve information/status
    public static boolean checkApi() {
        try {
            String text = Loader.get(BASE_URL);
            return parseForStatus(text);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean parseForStatus(String text) throws JSONException {
        // Create a root object containing all the JSON text
        JSONObject root = new JSONObject(text);
        // Retrieve api_status flag
        String status = root.getString("api_status");
        return status.equals("running");
    }

    public static String registerTalent(String fullName, String phone ,String password) throws Exception {
        // create object with the attributes
        JSONObject object = new JSONObject();
        object.put("name", fullName);
        object.put("phone", phone);
        object.put("password", password);

        String text = Loader.post(object, USER_REGISTER_URL);
        // Parse the response to a JSONObject
        JSONObject root = new JSONObject(text);
        // Check if there is email present
        if (root.has("phone")) {
            String returnedEmail = root.getString("email");
            // check if the returned email is same as sent email
            if (returnedEmail.equals(phone)) {
                return RESULT_OK;
            } else {
                return createError("The returned email is invalid");
            }
        } else {
            // signup failed
            String message = root.getString("message");
            return createError(message);
        }
    }

    public static String createError(String message) {
        return RESULT_ERROR + ":" + message;
    }
    public static String getError(String message) {
        String[] parts = message.split(":");
        return parts[1];
    }
}
