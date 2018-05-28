package com.wesurf.wesurfweb.strava.model;

public class StravaSegmentEffort {
    private long id;
    private String name;
    private StravaSegmentEffortAthlete athlete;
    private float distance;
    private String date;
    private StravaSegment segment;
    private long elapsedTime;
    private StravaActivity activity;

    public StravaSegmentEffort(long id, String name, StravaSegmentEffortAthlete athlete, float distance, String date, StravaSegment segment, long elapsedTime, StravaActivity activity) {
        this.id = id;
        this.name = name;
        this.athlete = athlete;
        this.distance = distance;
        this.date = date;
        this.segment = segment;
        this.elapsedTime = elapsedTime;
        this.activity = activity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StravaSegmentEffortAthlete getAthlete() {
        return athlete;
    }

    public float getDistance() {
        return distance;
    }

    public String getDate() {
        return date;
    }

    public StravaSegment getSegment() {
        return segment;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public StravaActivity getActivity() {
        return activity;
    }
}
