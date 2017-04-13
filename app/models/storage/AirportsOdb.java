package models.storage;

import models.Airport;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by bsuieric on 12/04/2017.
 */
public class AirportsOdb implements AirportsDAO {

    @Override
    public List<Airport> GetById(EntityManager em, String input) {
        TypedQuery<Airport> query = em.createQuery("Select a from Airport where c.id=:input", Airport.class);
        return query.setParameter("input", input).getResultList();
    }
}
