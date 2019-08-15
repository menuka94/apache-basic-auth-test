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
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "admin");
        BasicScheme basicScheme = new BasicScheme();
        Worker[] workers = new Worker[2000];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker(credentials, basicScheme);
        }

        for (int i = 0; i < workers.length; i++) {
            workers[i].start();
        }
    }
}
