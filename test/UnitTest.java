import models.storage.CountriesDAO;
import models.storage.CountriesOdb;
import org.junit.*;

import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.*;
import play.test.*;
import play.twirl.api.Content;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;


public class UnitTest {

    @Test
    public void testReport(){
        List<Object[]> highest = new ArrayList<Object[]>();

        Object[] pair = new Object[2];
        pair[0] = "Italy";
        pair[1] = "ToMany";
        highest.add(pair);
        Content html = views.html.report.render(highest, highest, highest, highest);
        assertEquals("text/html", html.contentType());
        assertFalse(contentAsString(html).contains("United States"));
        assertTrue(contentAsString(html).contains("ToMany"));
    }


}
