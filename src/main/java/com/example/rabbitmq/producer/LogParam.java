package com.example.rabbitmq.producer;

public class LogParam {
    String type = "info";
    String message = "";

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
