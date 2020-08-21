package com.rantas.bankfinalproject.model;

import java.io.Serializable;

public class StatusAccount implements Serializable {

    private final int status =1;

    public StatusAccount() {
    }

    public int getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "StatusAccount{" +
                "status=" + status +
                '}';
    }
}
