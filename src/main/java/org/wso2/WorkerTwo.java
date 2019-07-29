package org.wso2;

import org.apache.http.auth.AuthenticationException;

public class WorkerTwo extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                App.generateAuthHeader("admin", "admin");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
