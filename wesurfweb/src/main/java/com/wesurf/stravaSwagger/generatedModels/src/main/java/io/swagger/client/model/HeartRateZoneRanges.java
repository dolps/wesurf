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
import io.swagger.client.model.ZoneRanges;
import java.io.IOException;

/**
 * HeartRateZoneRanges
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-28T14:44:25.609+02:00")
public class HeartRateZoneRanges {
  @SerializedName("custom_zones")
  private Boolean customZones = null;

  @SerializedName("zones")
  private ZoneRanges zones = null;

  public HeartRateZoneRanges customZones(Boolean customZones) {
    this.customZones = customZones;
    return this;
  }

   /**
   * Whether the athlete has set their own custom heart rate zones
   * @return customZones
  **/
  @ApiModelProperty(value = "Whether the athlete has set their own custom heart rate zones")
  public Boolean isCustomZones() {
    return customZones;
  }

  public void setCustomZones(Boolean customZones) {
    this.customZones = customZones;
  }

  public HeartRateZoneRanges zones(ZoneRanges zones) {
    this.zones = zones;
    return this;
  }

   /**
   * Get zones
   * @return zones
  **/
  @ApiModelProperty(value = "")
  public ZoneRanges getZones() {
    return zones;
  }

  public void setZones(ZoneRanges zones) {
    this.zones = zones;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HeartRateZoneRanges heartRateZoneRanges = (HeartRateZoneRanges) o;
    return Objects.equals(this.customZones, heartRateZoneRanges.customZones) &&
        Objects.equals(this.zones, heartRateZoneRanges.zones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customZones, zones);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HeartRateZoneRanges {\n");
    
    sb.append("    customZones: ").append(toIndentedString(customZones)).append("\n");
    sb.append("    zones: ").append(toIndentedString(zones)).append("\n");
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

