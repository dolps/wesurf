package com.wesurf.wesurfweb.strava.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wesurf.wesurfweb.strava.model.StravaMap;
import com.wesurf.wesurfweb.strava.model.StravaSegmentEffort;

import java.util.List;

abstract class StravaActivityMixin extends StravaObjectMixin {
    @JsonProperty("name")
    String name;
    @JsonProperty("start_date")
    String date;
    @JsonProperty("description")
    String description;
    @JsonProperty("type")
    String type;

    StravaActivityMixin(
        @JsonProperty("id") long id,
        @JsonProperty("name") String name,
        @JsonProperty("type") String type,
        @JsonProperty("description") String description,
        @JsonProperty("distance") float distance,
        @JsonProperty("elapsed_time") long elapsedTime,
        @JsonProperty("start_date") String date,
        @JsonProperty("map") StravaMap map,
        @JsonProperty("segment_efforts") List<StravaSegmentEffort> segmentEfforts) {
    }
}
