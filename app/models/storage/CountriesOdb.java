package models.storage;

import models.Country;
import play.db.jpa.JPAApi;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

import static play.libs.Json.toJson;

/**
 * Created by bsuieric on 12/04/2017.
 */
public class CountriesOdb implements CountriesDAO {

    @Override
    public List<Country> GetByNameOrCode(EntityManager em, String input) {
        TypedQuery<Country> query = em.createQuery("Select c from Country c where upper(name)=upper(:input) or upper(code)=upper(:input)", Country.class);
        return query.setParameter("input", input).getResultList();
    }

    @Override
    public List<Object[]> TopTenHighestNumberAirports(EntityManager em) {
        TypedQuery<Object[]> query = em.createQuery("Select c.name, count(a.id) as airportsCount from Country as c inner join c.airports as a on c.code=a.iso_country group by c.name order by airportsCount DESC", Object[].class).setMaxResults(10);
        return query.getResultList();
    }

    @Override
    public List<Object[]> TopTenLowestNumberAirports(EntityManager em) {
        TypedQuery<Object[]> query = em.createQuery("Select c.name, count(a.id) as airportsCount from Country as c inner join c.airports as a on c.code=a.iso_country group by c.name order by airportsCount ", Object[].class).setMaxResults(10);
        return query.getResultList();
    }

    @Override
    public List<Object[]> TypeOfRunwaysPerCountry(EntityManager em) {
        TypedQuery<Object[]> query = em.createQuery("select distinct(r.surface), c.name from Airport a, Runway r, Country c "
                + "where a.id = r.airport_ref and c.code = a.iso_country and r.surface<>'' order by c.name ", Object[].class);
        return query.getResultList();
    }

    @Override
    public List<Object> GetAllCountriesNames(EntityManager em) {
        TypedQuery<Object> query = em.createQuery("select c.name from Country c", Object.class);
        return query.getResultList();
    }
}
