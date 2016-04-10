/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import com.model.Activity;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        WebTarget target = client.target("http://localhost:8084/webresources/");
        //Activity response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Activity.class);
        //String response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
        // System.out.println(response);

        Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }

        return response.readEntity(Activity.class);
    }

    public List<Activity> get() {
        WebTarget target = client.target("http://localhost:8084/webresources/");
        List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
        });
        return response;
    }

    Activity create(Activity activity) {
        WebTarget target = client.target("http://localhost:8084/webresources/");

        Response response = target.path("activities/activity")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(activity, MediaType.APPLICATION_JSON));

        if (response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }

        return response.readEntity(Activity.class);
    }

    Activity update(Activity activity) {
        WebTarget target = client.target("http://localhost:8084/webresources/");

        Response response = target.path("activities/" + activity.getId())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(activity, MediaType.APPLICATION_JSON));

        if (response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }

        return response.readEntity(Activity.class);

    }

    void delete(String activityId) {
        WebTarget target = client.target("http://localhost:8084/webresources/");

        Response response = target.path("activities/" + activityId)
                .request(MediaType.APPLICATION_JSON)
                .delete();

        if (response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }
    }

}
