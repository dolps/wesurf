package com.wesurf.wesurfweb.strava.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class StravaObjectMixin {
}
