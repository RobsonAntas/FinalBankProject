package com.rantas.bankfinalproject.routerRepo;

import com.rantas.bankfinalproject.dao.Messenger;

public interface RequestResult {
    <T> void successful(T result);
    void failureMessage(Messenger messenger);
}
