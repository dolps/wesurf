/*
 * Strava API v3
 * Strava API
 *
 * OpenAPI spec version: 3.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.AltitudeStream;
import io.swagger.client.model.CadenceStream;
import io.swagger.client.model.DistanceStream;
import io.swagger.client.model.HeartrateStream;
import io.swagger.client.model.LatLngStream;
import io.swagger.client.model.MovingStream;
import io.swagger.client.model.PowerStream;
import io.swagger.client.model.SmoothGradeStream;
import io.swagger.client.model.SmoothVelocityStream;
import io.swagger.client.model.TemperatureStream;
import io.swagger.client.model.TimeStream;
import java.io.IOException;

/**
 * StreamSet
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-28T14:44:25.609+02:00")
public class StreamSet {
  @SerializedName("time")
  private TimeStream time = null;

  @SerializedName("distance")
  private DistanceStream distance = null;

  @SerializedName("latlng")
  private LatLngStream latlng = null;

  @SerializedName("altitude")
  private AltitudeStream altitude = null;

  @SerializedName("velocity_smooth")
  private SmoothVelocityStream velocitySmooth = null;

  @SerializedName("heartrate")
  private HeartrateStream heartrate = null;

  @SerializedName("cadence")
  private CadenceStream cadence = null;

  @SerializedName("watts")
  private PowerStream watts = null;

  @SerializedName("temp")
  private TemperatureStream temp = null;

  @SerializedName("moving")
  private MovingStream moving = null;

  @SerializedName("grade_smooth")
  private SmoothGradeStream gradeSmooth = null;

  public StreamSet time(TimeStream time) {
    this.time = time;
    return this;
  }

   /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(value = "")
  public TimeStream getTime() {
    return time;
  }

  public void setTime(TimeStream time) {
    this.time = time;
  }

  public StreamSet distance(DistanceStream distance) {
    this.distance = distance;
    return this;
  }

   /**
   * Get distance
   * @return distance
  **/
  @ApiModelProperty(value = "")
  public DistanceStream getDistance() {
    return distance;
  }

  public void setDistance(DistanceStream distance) {
    this.distance = distance;
  }

  public StreamSet latlng(LatLngStream latlng) {
    this.latlng = latlng;
    return this;
  }

   /**
   * Get latlng
   * @return latlng
  **/
  @ApiModelProperty(value = "")
  public LatLngStream getLatlng() {
    return latlng;
  }

  public void setLatlng(LatLngStream latlng) {
    this.latlng = latlng;
  }

  public StreamSet altitude(AltitudeStream altitude) {
    this.altitude = altitude;
    return this;
  }

   /**
   * Get altitude
   * @return altitude
  **/
  @ApiModelProperty(value = "")
  public AltitudeStream getAltitude() {
    return altitude;
  }

  public void setAltitude(AltitudeStream altitude) {
    this.altitude = altitude;
  }

  public StreamSet velocitySmooth(SmoothVelocityStream velocitySmooth) {
    this.velocitySmooth = velocitySmooth;
    return this;
  }

   /**
   * Get velocitySmooth
   * @return velocitySmooth
  **/
  @ApiModelProperty(value = "")
  public SmoothVelocityStream getVelocitySmooth() {
    return velocitySmooth;
  }

  public void setVelocitySmooth(SmoothVelocityStream velocitySmooth) {
    this.velocitySmooth = velocitySmooth;
  }

  public StreamSet heartrate(HeartrateStream heartrate) {
    this.heartrate = heartrate;
    return this;
  }

   /**
   * Get heartrate
   * @return heartrate
  **/
  @ApiModelProperty(value = "")
  public HeartrateStream getHeartrate() {
    return heartrate;
  }

  public void setHeartrate(HeartrateStream heartrate) {
    this.heartrate = heartrate;
  }

  public StreamSet cadence(CadenceStream cadence) {
    this.cadence = cadence;
    return this;
  }

   /**
   * Get cadence
   * @return cadence
  **/
  @ApiModelProperty(value = "")
  public CadenceStream getCadence() {
    return cadence;
  }

  public void setCadence(CadenceStream cadence) {
    this.cadence = cadence;
  }

  public StreamSet watts(PowerStream watts) {
    this.watts = watts;
    return this;
  }

   /**
   * Get watts
   * @return watts
  **/
  @ApiModelProperty(value = "")
  public PowerStream getWatts() {
    return watts;
  }

  public void setWatts(PowerStream watts) {
    this.watts = watts;
  }

  public StreamSet temp(TemperatureStream temp) {
    this.temp = temp;
    return this;
  }

   /**
   * Get temp
   * @return temp
  **/
  @ApiModelProperty(value = "")
  public TemperatureStream getTemp() {
    return temp;
  }

  public void setTemp(TemperatureStream temp) {
    this.temp = temp;
  }

  public StreamSet moving(MovingStream moving) {
    this.moving = moving;
    return this;
  }

   /**
   * Get moving
   * @return moving
  **/
  @ApiModelProperty(value = "")
  public MovingStream getMoving() {
    return moving;
  }

  public void setMoving(MovingStream moving) {
    this.moving = moving;
  }

  public StreamSet gradeSmooth(SmoothGradeStream gradeSmooth) {
    this.gradeSmooth = gradeSmooth;
    return this;
  }

   /**
   * Get gradeSmooth
   * @return gradeSmooth
  **/
  @ApiModelProperty(value = "")
  public SmoothGradeStream getGradeSmooth() {
    return gradeSmooth;
  }

  public void setGradeSmooth(SmoothGradeStream gradeSmooth) {
    this.gradeSmooth = gradeSmooth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamSet streamSet = (StreamSet) o;
    return Objects.equals(this.time, streamSet.time) &&
        Objects.equals(this.distance, streamSet.distance) &&
        Objects.equals(this.latlng, streamSet.latlng) &&
        Objects.equals(this.altitude, streamSet.altitude) &&
        Objects.equals(this.velocitySmooth, streamSet.velocitySmooth) &&
        Objects.equals(this.heartrate, streamSet.heartrate) &&
        Objects.equals(this.cadence, streamSet.cadence) &&
        Objects.equals(this.watts, streamSet.watts) &&
        Objects.equals(this.temp, streamSet.temp) &&
        Objects.equals(this.moving, streamSet.moving) &&
        Objects.equals(this.gradeSmooth, streamSet.gradeSmooth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, distance, latlng, altitude, velocitySmooth, heartrate, cadence, watts, temp, moving, gradeSmooth);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamSet {\n");
    
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    latlng: ").append(toIndentedString(latlng)).append("\n");
    sb.append("    altitude: ").append(toIndentedString(altitude)).append("\n");
    sb.append("    velocitySmooth: ").append(toIndentedString(velocitySmooth)).append("\n");
    sb.append("    heartrate: ").append(toIndentedString(heartrate)).append("\n");
    sb.append("    cadence: ").append(toIndentedString(cadence)).append("\n");
    sb.append("    watts: ").append(toIndentedString(watts)).append("\n");
    sb.append("    temp: ").append(toIndentedString(temp)).append("\n");
    sb.append("    moving: ").append(toIndentedString(moving)).append("\n");
    sb.append("    gradeSmooth: ").append(toIndentedString(gradeSmooth)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

