package models.storage;

import java.util.List;
import models.Country;

import javax.persistence.EntityManager;

/**
 * Created by bsuieric on 12/04/2017.
 */


public interface CountriesDAO {

    public List<Country> GetByNameOrCode(EntityManager em, String input);
    public List<Object[]> TopTenHighestNumberAirports(EntityManager em);
    public List<Object[]> TopTenLowestNumberAirports(EntityManager em);
    public List<Object[]> TypeOfRunwaysPerCountry(EntityManager em);
    public List<Object> GetAllCountriesNames(EntityManager em);
}
