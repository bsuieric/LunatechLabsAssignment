package models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by bsuieric on 11/04/2017.
 */

@Entity
public class Runway {

    @Id
    private Long id;
    private String airport_ref;
    private String airport_ident;
    private String length_ft;
    private String width_ft;
    private String surface;
    private String lighted;
    private String closed;
    private String le_ident;
    private String le_latitude_deg;
    private String le_longitude_deg;
    private String le_elevation_ft;
    private String le_heading_degT;
    private String le_displaced_threshold_ft;
    private String he_ident;
    private String he_latitude_deg;
    private String he_longitude_deg;
    private String he_elevation_ft;
    private String he_heading_degT;
    private String he_displaced_threshold_ft;

    public String getSurface(){
        return surface;
    }
    public Long getId(){
        return id;
    }
}
