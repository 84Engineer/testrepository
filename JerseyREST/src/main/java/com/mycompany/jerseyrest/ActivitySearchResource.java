/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseyrest;

import com.model.Activity;
import com.model.ActivitySearch;
import com.repository.ActivityRepositoryStub;
import com.repository.ActivityRepository;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author LocalUser
 */
@Path("search/activities")
public class ActivitySearchResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response searchForActivities(ActivitySearch search) {
        System.out.println(search);
        List<Activity> activities = activityRepository.searchByConstraints(search);
        
        if(activities == null || activities.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok().entity(new GenericEntity<List<Activity>> (activities) {}).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response searchForActivities(@QueryParam(value = "description") String descriptionList,
            @QueryParam(value = "durationFrom") int durationFrom,
            @QueryParam(value = "durationTo") int durationTo) {

        String[] descs = descriptionList.replace("[", "").replace("]", "").split(",");

        for (String desc : descs) {
            desc = desc.trim();
        }

        System.out.println(durationFrom + ", " + durationTo);

        List<String> descriptions = Arrays.asList(descs);

        List<Activity> activities = activityRepository.findByDescription(descriptions, durationFrom, durationTo);

        if (activities == null || activities.size() <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {
        }).build();

    }

}
