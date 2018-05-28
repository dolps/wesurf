package com.wesurf.wesurfweb.strava.operation;

import com.wesurf.wesurfweb.strava.model.StravaActivity;

import java.util.List;

public interface ActivityOperations {
    StravaActivity getActivityById(String id);

    List<StravaActivity> getAllActivities();

    List<StravaActivity> getAllActivities(int limit);
}
