package models.storage;

import models.Airport;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bsuieric on 12/04/2017.
 */
public interface AirportsDAO {
    public List<Airport> GetById(EntityManager em, String input);
}
