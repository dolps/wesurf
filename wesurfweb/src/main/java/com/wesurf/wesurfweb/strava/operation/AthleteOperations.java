package com.wesurf.wesurfweb.strava.operation;

import com.wesurf.wesurfweb.strava.model.StravaAthleteProfile;
import com.wesurf.wesurfweb.strava.model.StravaSegment;

import java.util.List;

public interface AthleteOperations {
    /**
     * Retrieves the user's Strava profile ID.
     *
     * @return the user's Strava profile ID.
     */
    String getProfileId();

    List<StravaSegment> getSegments(String user);

    /**
     * Retrieves the athlete's profile details.
     *
     * @return the athlete's Strava profile
     */
    StravaAthleteProfile getAthleteProfile();

    String getProfileUrl();

    StravaAthleteProfile getAthleteProfileById(String id);
}
