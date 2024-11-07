package com.diffblue;


public class StatusDTO {
    int status;
    String message;

    public StatusDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
