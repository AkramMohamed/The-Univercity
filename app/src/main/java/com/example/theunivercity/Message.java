package com.example.theunivercity;

public class Message {
    private int idM,idR;
    private String message , sendeBy , time;

    public Message() {
    }

    public Message(int idM, int idR, String message, String sendeBy, String time) {
        this.idM = idM;
        this.idR = idR;
        this.message = message;
        this.sendeBy = sendeBy;
        this.time = time;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendeBy() {
        return sendeBy;
    }

    public void setSendeBy(String sendeBy) {
        this.sendeBy = sendeBy;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
