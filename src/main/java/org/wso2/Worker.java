package org.wso2;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Worker extends Thread {
    private static int workerId = 0;
    private static final Logger LOG = LoggerFactory.getLogger(Worker.class);
    private static final Logger myLog = LoggerFactory.getLogger("NEW_LOGGER");
    private UsernamePasswordCredentials credentials;
    private BasicScheme basicScheme;

    public Worker(UsernamePasswordCredentials credentials, BasicScheme basicScheme) {
        this.credentials = credentials;
        this.basicScheme = basicScheme;
        workerId++;
    }

    @Override
    public void run() {
        try {
            while (true) {
                HttpRequest httpRequest = new HttpGet("http://localhost:8688");
                HttpContext httpContext = new BasicHttpContext();
                Header header = basicScheme.authenticate(credentials, httpRequest, httpContext);
                if (!header.toString().contains("YWRtaW46YWRtaW4=")) {
                    // LOG.info("Worker: {}, {}", workerId, header);
                    myLog.info("Worker: {}, {}", workerId, header);
                }
            }
        } catch (AuthenticationException e) {
            LOG.error(e.getLocalizedMessage());
        }
    }
}
