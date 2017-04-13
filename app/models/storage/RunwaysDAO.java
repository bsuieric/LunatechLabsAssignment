package models.storage;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by bsuieric on 12/04/2017.
 */
public interface RunwaysDAO {
    public List<Object[]> TenMostCommmonIdentification(EntityManager em);
}
