/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository;

import com.model.Activity;
import com.model.ActivitySearch;
import com.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oslysenko
 */
public class ActivityRepositoryStub implements ActivityRepository {

    @Override
    public List<Activity> findAllActivities() {

        List<Activity> activities = new ArrayList();

        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);

        activities.add(activity1);
        
        Activity activity2 = new Activity();
        activity2.setDescription("Cycling");
        activity2.setDuration(120);
        
        activities.add(activity2);
        
        return activities;

    }

    @Override
    public Activity findActivity(String activityId) {
        
        if(activityId.equals("7777")) {
            return null;
        }

        Activity activity1 = new Activity();
        
        activity1.setId("1234");
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        
        User user = new User();
        user.setId("5678");
        user.setName("Bryan");
        
        activity1.setUser(user);
        
        return activity1;
    }

    @Override
    public void create(Activity activity) {
        //inserting
    }

    @Override
    public Activity update(Activity activity) {
        //some operations
        return activity;
    }
    @Override
    public void delete(String activityId) {
       //delete operations
    }

    @Override
    public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
        
        List<Activity> activities = new ArrayList();
        
        Integer id = 1111;
        int duration = 50;
        
        for(String desc:descriptions) {
            Activity a = new Activity();
            a.setId((id++).toString());
            a.setDuration(duration);
            duration+=10;
            a.setDescription(desc);
            activities.add(a);
        }
        
        return activities;
    }

    @Override
    public List<Activity> searchByConstraints(ActivitySearch search) {
        System.out.println(search);
        
        List<Activity> activities = new ArrayList();
        
        List<String> descriptions = search.getDescriptions();
        
        Integer id = 1111;
        int duration = 50;
        
        for(String desc:descriptions) {
            Activity a = new Activity();
            a.setId((id++).toString());
            a.setDuration(duration);
            duration+=10;
            a.setDescription(desc);
            activities.add(a);
        }
        
        return activities;
        
    }

}
