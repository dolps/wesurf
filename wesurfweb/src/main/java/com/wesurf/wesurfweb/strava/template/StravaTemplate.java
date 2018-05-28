package com.wesurf.wesurfweb.strava.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wesurf.wesurfweb.strava.Strava;
import com.wesurf.wesurfweb.strava.json.StravaModule;
import com.wesurf.wesurfweb.strava.operation.ActivityOperations;
import com.wesurf.wesurfweb.strava.operation.AthleteOperations;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;

public class StravaTemplate extends AbstractOAuth2ApiBinding implements Strava {
    private AthleteOperations athleteOperations;
    private ActivityOperations activityOperations;

    /**
     * No-arg constructor to support cases in which you want to call the Strava
     * API without requiring authorization. This is useful for public operations,
     * such as getting the list of watchers for a public repository.
     */
    public StravaTemplate() {
        super();
        initSubApis();
    }

    /**
     * Constructs a StravaTemplate with the minimal amount of information
     * required to sign requests with an OAuth <code>Authorization</code>
     * header.
     *
     * @param accessToken An access token granted to the application after OAuth
     *                    authentication.
     */
    public StravaTemplate(String accessToken) {
        super(accessToken);
        initSubApis();
    }

    @Override
    protected OAuth2Version getOAuth2Version() {
        return OAuth2Version.BEARER;
    }

    public AthleteOperations athleteOperations() {
        return athleteOperations;
    }

    public ActivityOperations activityOperations() {
        return activityOperations;
    }


    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new StravaModule());
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    // internal helpers
    private void initSubApis() {
        this.athleteOperations = new AthleteTemplate(getRestTemplate(), isAuthorized());
        this.activityOperations = new ActivityTemplate(getRestTemplate(), isAuthorized());
    }
}
