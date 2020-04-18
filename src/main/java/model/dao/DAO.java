package model.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

    private static String PERSISTENCE_UNIT_NAME = "web_lab12_1_";

    private EntityManagerFactory factory;

    /**
     * DAO constructor
     */
    protected DAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    protected EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }
}
