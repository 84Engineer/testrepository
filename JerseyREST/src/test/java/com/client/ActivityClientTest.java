package com.client;

import com.client.ActivityClient;
import com.model.Activity;
import com.model.ActivitySearch;
import com.model.ActivitySearchType;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Ignore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oslysenko
 */
public class ActivityClientTest {
    
    @Test
    public void testSearchObject() {
        ActivitySearchClient client = new ActivitySearchClient();
        
        List<String> descriptions = new ArrayList();
        descriptions.add("Dancing");
        descriptions.add("Climbing");
        
        ActivitySearch search = new ActivitySearch();
        search.setDescriptions(descriptions);
        search.setDuratiionFrom(30);
        search.setDurationTo(55);
        search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);
        
        List<Activity> activities = client.search(search);
        
        for (Activity activity:activities) {
            System.out.println(activity);
        }
        
        assertNotNull(activities);
    }
    
    @Test
    @Ignore
    public void testSearch() {
        ActivitySearchClient client = new ActivitySearchClient();
        
        String param = "description";
        
        List<String> searchValues = new ArrayList();
        searchValues.add("Riding");
        searchValues.add("Running");
        
        String secondParam = "durationFrom";
        int durationFrom = 30;
        
        String thirdParam = "durationTo";
        int durationTo = 55;
        
        List<Activity> activities = client.search(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);
        
        for(Activity activity:activities) {
            System.out.println(activity);
        }
        
        assertNotNull(activities);
        
    }
    
    
    @Test
    @Ignore
    public void testDelete() {
        ActivityClient client = new ActivityClient();
        
        client.delete("23435");
    }
    
    @Test
    @Ignore
    public void testPut() {
        Activity activity = new Activity();
        
        activity.setId("3456");
        activity.setDescription("Bikram Yoga");
        activity.setDuration(90);
        
        ActivityClient client = new ActivityClient();
        
        activity = client.update(activity);
        
        assertNotNull(activity);
        
    }

    
    @Test
    @Ignore
    public void testCreate() {
        ActivityClient client = new ActivityClient();
        Activity activity = new Activity();
        
        activity.setDescription("Riding");
        activity.setDuration(90);
        
        activity = client.create(activity);
        assertNotNull(activity);
    }
    
    
    @Test
    @Ignore
    public void testGet() {
        ActivityClient client = new ActivityClient();
        Activity activity = client.get("1234");

        System.out.println(activity);

        assertNotNull(activity);
    }

    @Test
    @Ignore
    public void testGetList() {
        ActivityClient client = new ActivityClient();
        List<Activity> activities = client.get();

        for (Activity activity : activities) {
            System.out.println(activity);
        }
        assertNotNull(activities);
    }

    @Test(expected = RuntimeException.class)
    @Ignore
    public void testWithBadRequest() {
        ActivityClient client = new ActivityClient();
        client.get("123");
    }

    @Test(expected = RuntimeException.class)
    @Ignore
    public void testWithNotFound() {
        ActivityClient client = new ActivityClient();
        client.get("7777");
    }

}
