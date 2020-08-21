package com.rantas.bankfinalproject.dao;

import java.io.Serializable;

public class Messenger implements Serializable {
    private int errorCode;
    private String failureMessage;

    public Messenger(int errorCode, String failureMessage) {
        this.errorCode = errorCode;
        this.failureMessage = failureMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    @Override
    public String toString() {
        return "Messenger{" +
                "errorCode=" + errorCode +
                ", failureMessage='" + failureMessage + '\'' +
                '}';
    }
}
