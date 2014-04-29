package com.ftc.aspel.dao.impl;

import com.ftc.aspel.exception.AspelException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final static String PERSISTENCE_UNIT = "AspelDemoPU";

    public GenericDAO() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
    }

    public Object insert(Object object) throws AspelException {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        Object o = em.find(object.getClass(), object);
        return o;
    }

    public Object update(Object object) throws AspelException {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        Object o = em.find(object.getClass(), object);
        return o;
    }

    public EntityManager getEntityManager() throws AspelException {
        return this.em;
    }

    @Override
    public void finalize() {
        emf.close();
    }

}
