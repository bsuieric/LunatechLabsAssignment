package models.storage;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by bsuieric on 12/04/2017.
 */
public class RunwaysOdb implements RunwaysDAO {
    @Override
    public List<Object[]> TenMostCommmonIdentification(EntityManager em) {
        TypedQuery<Object[]> query = em.createQuery("Select r.le_ident, count(r.le_ident) as le_identCount from Runway r group by r.le_ident order by le_identCount DESC)", Object[].class).setMaxResults(10);
        return query.getResultList();
    }
}
