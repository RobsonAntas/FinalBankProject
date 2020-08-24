package com.rantas.bankfinalproject.repository;

import com.rantas.bankfinalproject.dao.Messenger;

public interface RequestResult {
    <T> void successful(T result);
    void failureMessage(Messenger messenger);
}
