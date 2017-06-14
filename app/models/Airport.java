package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by bsuieric on 10/04/2017.
 */

@Entity
public class Airport {

    
    @Id
    private Long id;
    private String ident;
    private String type;
    private String name;
    private String latitude_deg;
    private String longitude_deg;
    private String elevation_ft;
    private String continent;
    private String iso_country;
    private String iso_region;
    private String municipality;
    private String scheduled_service;
    private String gps_code;
    private String iata_code;
    private String local_code;
    private String home_link;
    private String wikipedia_link;
    private String keywords;

    @OneToMany(mappedBy = "airport_ref")
    private List<Runway> runways;

    public String getName() {
        return name;
    }

    public String getType(){
        return  type;
    }

    public List<Runway> getRunways() {
        return runways;
    }




}
