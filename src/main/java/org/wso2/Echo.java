package org.wso2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("echo")
public class Echo {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String echo() {
        return "hello";
    }
}
