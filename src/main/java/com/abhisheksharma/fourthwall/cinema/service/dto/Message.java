package com.abhisheksharma.fourthwall.cinema.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    private Boolean status;

    private String message;

    public Message(){}

    public Message(Boolean status, String message){
        this.status = status;
        this.message = message;
    }

    public Boolean isStatus() { return status; }

    public String getMessage() { return message; }

    public void setStatus(Boolean status) { this.status = status; }

    public void setMessage(String message) { this.message = message; }


    @Override
    public String toString() {
        return "Message{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
