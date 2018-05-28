package com.wesurf.wesurfweb.strava;

import com.wesurf.wesurfweb.strava.operation.ActivityOperations;
import com.wesurf.wesurfweb.strava.operation.AthleteOperations;
import org.springframework.social.ApiBinding;

public interface Strava extends ApiBinding {
    /**
     * Returns the portion of the Strava API containing the user operations.
     *
     * @return athlete operations
     */
    AthleteOperations athleteOperations();

    ActivityOperations activityOperations();
}
