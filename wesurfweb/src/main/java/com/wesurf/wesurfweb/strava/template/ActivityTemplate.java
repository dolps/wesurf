package com.wesurf.wesurfweb.strava.template;

import com.wesurf.wesurfweb.strava.operation.AbstractStravaOperations;
import com.wesurf.wesurfweb.strava.operation.ActivityOperations;
import com.wesurf.wesurfweb.strava.model.StravaActivity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

class ActivityTemplate extends AbstractStravaOperations implements ActivityOperations {
    private final RestTemplate restTemplate;
    private static final String ACTIVITIES_URI = "/activities";
    private static final String PAGING_PARAM = "per-page";
    private static final int ACTIVITY_LOAD_LIMIT = 200;

    ActivityTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.restTemplate = restTemplate;
    }

    public StravaActivity getActivityById(String id) {
        return restTemplate.getForObject(buildUri(ACTIVITIES_URI + id), StravaActivity.class);
    }

    public List<StravaActivity> getAllActivities() {
        return getAllActivities(ACTIVITY_LOAD_LIMIT);
    }

    public List<StravaActivity> getAllActivities(int limit) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set(PAGING_PARAM, String.valueOf(limit));

        return restTemplate.getForObject(buildUri(ACTIVITIES_URI, parameters), StravaActivityList.class);
    }

    @SuppressWarnings("serial")
    private static class StravaActivityList extends ArrayList<StravaActivity> {
    }
}
