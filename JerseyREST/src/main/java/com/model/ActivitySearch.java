/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.List;

/**
 *
 * @author LocalUser
 */
public class ActivitySearch {
    
    int duratiionFrom;
    int durationTo;
    
    List<String> descriptions;
    
    private ActivitySearchType searchType;

    public ActivitySearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(ActivitySearchType searchType) {
        this.searchType = searchType;
    }

    public int getDuratiionFrom() {
        return duratiionFrom;
    }

    public void setDuratiionFrom(int duratiionFrom) {
        this.duratiionFrom = duratiionFrom;
    }

    public int getDurationTo() {
        return durationTo;
    }

    public void setDurationTo(int durationTo) {
        this.durationTo = durationTo;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "ActivitySearch{" + "duratiionFrom=" + duratiionFrom + ", durationTo=" + durationTo + ", descriptions=" + descriptions + ", searchType=" + searchType + '}';
    }

     
    
}
