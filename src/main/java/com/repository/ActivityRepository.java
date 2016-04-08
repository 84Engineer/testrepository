/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository;

import com.model.Activity;
import java.util.List;

/**
 *
 * @author oslysenko
 */
public interface ActivityRepository {

    List<Activity> findAllActivities();

    public Activity findActivity(String activityId);

    public void create(Activity activity);
    
}
