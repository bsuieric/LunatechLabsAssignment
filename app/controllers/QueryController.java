package controllers;
import javax.inject.Inject;
import javax.persistence.*;
import models.Country;
import models.storage.CountriesDAO;
import models.storage.CountriesOdb;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import java.util.*;
import play.libs.Json;
import play.mvc.*;
import scala.util.parsing.json.JSON;

import static play.libs.Json.*;
import static play.libs.Json.toJson;

/**
 * Created by bsuieric on 11/04/2017.
 */
public class QueryController extends Controller {

    private final JPAApi jpaApi;

    @Inject
    public QueryController(JPAApi jpaApi){
        this.jpaApi =jpaApi;
    }

    @Transactional(readOnly = true)
    public Result GetCountryByNameOrCode(String input) {
        CountriesOdb countryDao = new CountriesOdb();
        List<Country> countries = countryDao.GetByNameOrCode(jpaApi.em(), input);
        return ok(views.html.query.render(countries));
    }


    /*
    @Transactional(readOnly = true)
    public Result GetAll() {
        TypedQuery<Country> query = jpaApi.em().createNamedQuery("Country.findAll", Country.class);
        List<Country> countries = query.getResultList();
        return ok(views.html.query.render(countries));
    }
    */

}
