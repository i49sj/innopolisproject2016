package server.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by User on 07.11.2016.
 */
public class EntityManagerUtil {

    private static final String PERSISTENT_UNIT_NAME = "item-manager-pu";

    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEm() {
        return emf.createEntityManager();
    }
}
