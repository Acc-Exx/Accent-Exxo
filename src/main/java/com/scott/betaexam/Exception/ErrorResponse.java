package com.scott.betaexam.Exception;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class ErrorResponse {
    private LocalDateTime date;
    private String message;
    private String details;

    public ErrorResponse(LocalDateTime date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
