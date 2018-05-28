package com.wesurf.wesurfweb.strava.model;

import java.io.Serializable;
import java.util.List;

public class StravaActivity implements Serializable {
    private long id;
    private String name;
    private String type;
    private String description;
    private float distance;
    private long elapsedTime;
    private String date;
    private StravaMap map;

    public StravaActivity(long id, String name, String type, String description, float distance, long elapsedTime, String date, StravaMap map) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.distance = distance;
        this.elapsedTime = elapsedTime;
        this.date = date;
        this.map = map;
    }

    public StravaActivity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public float getDistance() {
        return distance;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public String getDate() {
        return date;
    }

    public StravaMap getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "StravaActivity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", description='" + description + '\'' +
            ", distance=" + distance +
            ", elapsedTime=" + elapsedTime +
            ", date='" + date + '\'' +
            ", map=" + map +
            '}';
    }
}
