/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository;

import com.model.Activity;
import com.model.ActivitySearch;
import java.util.List;

/**
 *
 * @author oslysenko
 */
public interface ActivityRepository {

    List<Activity> findAllActivities();

    public Activity findActivity(String activityId);

    public void create(Activity activity);

    public Activity update(Activity activity);

    public void delete(String activityId);

    public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

    public List<Activity> searchByConstraints(ActivitySearch search);
    
}
