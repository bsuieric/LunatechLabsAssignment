import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.HomeController;
import models.Country;
import org.h2.engine.Database;
import org.junit.*;

import play.db.Databases;
import play.db.jpa.JPAApi;
import play.mvc.*;
import play.test.*;
import org.mockito.mock.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static play.db.jpa.JPAApi.*;
import static play.test.Helpers.*;
import static org.junit.Assert.*;
import models.storage.CountriesOdb;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;


import java.util.ArrayList;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import play.twirl.api.Content;


/**
 *
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 *
 */
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test
    public void testReport(){
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            public void run(){
            Result result = route(
                    fakeRequest().uri("/report")
            );
            assertEquals(OK, result.status());

            }
        });
    }

}
