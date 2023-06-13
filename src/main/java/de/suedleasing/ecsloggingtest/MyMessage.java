package de.suedleasing.ecsloggingtest;

import java.util.HashMap;

public class MyMessage {
    public String message = "ObjectMessage() test";
    public HashMap<String, String> myCustomField = new HashMap<>();

    public MyMessage() {
        this.myCustomField.put("test1", "value1");
    }
}