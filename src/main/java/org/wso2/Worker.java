package org.wso2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.auth.AuthenticationException;

public class Worker extends Thread {
    private static int workerId = 0;
    private static final Log LOG = LogFactory.getLog(Worker.class);
    private String username;
    private String password;

    public Worker(String username, String password) {
        this.username = username;
        this.password = password;
        workerId++;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // App.generateAuthHeader(workerId, username, password);
                throw new AuthenticationException();
            }
        } catch (AuthenticationException e) {
            LOG.error(e.getStackTrace());
        }
    }
}
