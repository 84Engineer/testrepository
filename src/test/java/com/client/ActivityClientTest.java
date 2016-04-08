package com.client;


import com.client.ActivityClient;
import com.model.Activity;
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
    //@Ignore
    public void testGet() {
        ActivityClient client = new ActivityClient();
        Activity activity = client.get("1234");
        
        System.out.println(activity);
        
        assertNotNull(activity);
    }
    
}
