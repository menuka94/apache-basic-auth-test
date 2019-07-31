package org.wso2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("app")
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    private static void startWorkers() {
        Worker[] workers = new Worker[10];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("admin", "admin");
            workers[i].start();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello";
    }

    // @GET
    // @Produces(MediaType.TEXT_PLAIN)
    // public static void generateAuthHeader(int workerId, String username, String password) throws AuthenticationException {
    //     UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
    //     BasicScheme basicScheme = new BasicScheme();
    //
    //     HttpRequest httpRequest = new HttpGet("http://localhost:8688");
    //     HttpContext httpContext = new BasicHttpContext();
    //     Header header = basicScheme.authenticate(credentials, httpRequest, httpContext);
    //     LOG.info("Worker: {}, {}", workerId, header);
    // }
}
