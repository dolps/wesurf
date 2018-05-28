package com.wesurf.wesurfweb.strava.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wesurf.wesurfweb.strava.json.StravaActivityMixin;
import com.wesurf.wesurfweb.strava.json.StravaAthleteProfileMixin;
import com.wesurf.wesurfweb.strava.model.StravaActivity;
import com.wesurf.wesurfweb.strava.model.StravaAthleteProfile;

public class StravaModule extends SimpleModule {

    public StravaModule() {
        super("StravaModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(StravaAthleteProfile.class, StravaAthleteProfileMixin.class);
        context.setMixInAnnotations(StravaActivity.class, StravaActivityMixin.class);
    }
}
