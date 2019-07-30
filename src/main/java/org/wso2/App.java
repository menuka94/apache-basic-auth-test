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

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        Worker[] workers = new Worker[10];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("admin", "admin");
            workers[i].start();
        }
    }

    static void generateAuthHeader(int workerId, String username, String password) throws AuthenticationException {
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        BasicScheme basicScheme = new BasicScheme();

        HttpRequest httpRequest = new HttpGet("http://localhost:8688");
        HttpContext httpContext = new BasicHttpContext();
        Header header = basicScheme.authenticate(credentials, httpRequest, httpContext);
        LOG.info("Worker: {}, {}", workerId, header);
    }
}
