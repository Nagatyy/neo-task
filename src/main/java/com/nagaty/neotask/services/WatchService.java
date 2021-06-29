package com.nagaty.neotask.services;

import java.util.ArrayList;

// to follow best practice, any watch service will implement from this interface
public interface WatchService {
    public float calculateCartPrice(ArrayList<String> listOfWatchIDs);
}
