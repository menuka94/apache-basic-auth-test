package org.wso2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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

@Path("app")
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    @GET
    @Path("{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public String generateAuthHeader(@PathParam("username") String username, @PathParam("password") String password)
            throws AuthenticationException {
        UsernamePasswordCredentials usernamePasswordCredentials = new UsernamePasswordCredentials(username, password);
        BasicScheme basicScheme = new BasicScheme();

        HttpRequest httpRequest = new HttpGet("http://localhost:8688");
        HttpContext httpContext = new BasicHttpContext();
        Header header = basicScheme.authenticate(usernamePasswordCredentials, httpRequest, httpContext);
        LOG.info(header.toString());
        return "";
    }
}
