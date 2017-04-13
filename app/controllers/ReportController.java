package controllers;

import models.Country;
import models.storage.CountriesOdb;
import models.storage.RunwaysOdb;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created by bsuieric on 11/04/2017.
 */
public class ReportController extends Controller {
    private final JPAApi jpaApi;

    @Inject
    public ReportController(JPAApi jpaApi){
        this.jpaApi =jpaApi;
    }

    @Transactional(readOnly = true)
    public Result GetReport() {
        CountriesOdb countryDao = new CountriesOdb();
        RunwaysOdb runwayDao = new RunwaysOdb();
        List<Object[]> countriesWithHighest = countryDao.TopTenHighestNumberAirports(jpaApi.em());
        List<Object[]> countriesWithLowest = countryDao.TopTenLowestNumberAirports(jpaApi.em());
        List<Object[]> typeOfRunways = countryDao.TypeOfRunwaysPerCountry(jpaApi.em());
        List<Object[]> mostCommonRunways = runwayDao.TenMostCommmonIdentification(jpaApi.em());

        return ok(views.html.report.render(countriesWithHighest, countriesWithLowest, typeOfRunways, mostCommonRunways));
    }
}
