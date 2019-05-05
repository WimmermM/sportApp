package com.example.etnateraapp.api.model;

import com.example.etnateraapp.model.SportResult;

import java.util.List;

public class APIResponse {

    private String status;
    private String message;

    public APIResponse() {
    }

    public APIResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
