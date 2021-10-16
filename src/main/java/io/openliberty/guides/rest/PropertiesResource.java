// tag::comment[]
/*******************************************************************************
 * Copyright (c) 2017, 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
 // end::comment[]
package io.openliberty.guides.rest;

import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// tag::path[]
@Path("properties")
// end::path[]
public class PropertiesResource {

    private WebTarget target;
    // tag::get[]
    @GET
    // end::get[]
    // tag::produces[]
    @Produces(MediaType.APPLICATION_JSON)
    // end::produces[]
    public String getProperties() {
	Client c = ClientBuilder.newClient();
	System.out.println("Client2");
        String url = System.getenv ("MSG_API_MP_DEMO_URL");
	System.out.println("URL=" + url);
	System.out.println("Client3");
        target = c.target(url);
	System.out.println("Client4");
	String responseMsg = "";
        try {
	System.out.println("Client5");
        target = target.path("properties");
	System.out.println("Client6");
	System.out.println("URI=" + target.getUri());
	responseMsg = target.request().get(String.class);
	} catch ( Exception e ) {
            responseMsg = e.getMessage();
            e.printStackTrace();
	}
	System.out.println ("Client ready");  
	return responseMsg;
    }

}
