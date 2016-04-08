/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import com.model.Activity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author oslysenko
 */
public class ActivityClient {
    
    private Client client;
    
    public ActivityClient() {
        client = ClientBuilder.newClient();
    }
    
    public Activity get(String id) {
        WebTarget target = client.target("http://localhost:8080/webresources/");
        Activity response = target.path("activities/" + id).request().get(Activity.class);
        return response;
    }
    
}
