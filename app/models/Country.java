package models;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bsuieric on 10/04/2017.
 */

@Entity
public class Country {


    private Long id;

    @Id
    private String code;
    private String name;
    private String continent;
    private String wikipedia_link;
    private String keywords;

    @OneToMany(mappedBy = "iso_country")
    private List<Airport> airports;

    public String getName() {
        return name;
    }

    public List<Airport> getAirports() {
        return airports;
    }

}
