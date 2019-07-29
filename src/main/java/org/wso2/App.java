package org.wso2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;

public class App {
    private static final Log LOG = LogFactory.getLog(App.class);
    public static void main(String[] args) {
        WorkerOne workerOne = new WorkerOne();
        WorkerTwo workerTwo = new WorkerTwo();

        workerOne.start();
        workerTwo.start();
    }

    public static void generateAuthHeader(String username, String password) throws AuthenticationException {
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        BasicScheme basicScheme = new BasicScheme();

        HttpRequest httpRequest = new HttpGet("http://localhost:8688");
        HttpContext httpContext = new BasicHttpContext();

        Header header = basicScheme.authenticate(credentials, httpRequest, httpContext);
        LOG.info(header);
    }
}
