package com.wesurf.wesurfweb.strava.template;

import com.wesurf.wesurfweb.strava.operation.AbstractStravaOperations;
import com.wesurf.wesurfweb.strava.operation.AthleteOperations;
import com.wesurf.wesurfweb.strava.model.StravaAthleteProfile;
import com.wesurf.wesurfweb.strava.model.StravaSegment;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;

class AthleteTemplate extends AbstractStravaOperations implements AthleteOperations {

    private final RestTemplate restTemplate;

    /**
     * @param restTemplate        A RestTemplate
     * @param isAuthorizedForUser Boolean indicating whether the RestTemplate is authorized for a user
     */
    AthleteTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.restTemplate = restTemplate;
    }

    public String getProfileId() {
        return String.valueOf(getAthleteProfile().getId());
    }

    public StravaAthleteProfile getAthleteProfile() {
        return restTemplate.getForObject(buildUri("/athlete"), StravaAthleteProfile.class);
    }

    public String getProfileUrl() {
        return "https://www.strava.com/athletes/" + getProfileId();
    }

    public StravaAthleteProfile getAthleteProfileById(String id) {
        return restTemplate.getForObject(buildUri("/athletes/" + id), StravaAthleteProfile.class);
    }

    // TODO fix
    public List<StravaSegment> getSegments(String user) {
        return asList(new StravaSegment(123));
    }

    private Date toDate(String dateString, DateFormat dateFormat) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.ENGLISH);
}
