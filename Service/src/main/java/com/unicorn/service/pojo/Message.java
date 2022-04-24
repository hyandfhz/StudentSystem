package com.unicorn.service.pojo;

public class Message {
    String message;
    boolean status;

    public Message() {
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{\"Message\":{"
                + "\"message\":\""
                + message + '\"'
                + ",\"status\":"
                + status
                + "}}";

    }
}
