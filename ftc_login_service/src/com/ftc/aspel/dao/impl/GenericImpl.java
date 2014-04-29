package com.ftc.aspel.dao.impl;

import com.ftc.aspel.dao.Generic;
import com.ftc.aspel.exception.AspelException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class GenericImpl implements Generic{

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final static String PERSISTENCE_UNIT = "iaspel_pu";

    public GenericImpl() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
    }

    @Override
    public Object insert(Object object) throws AspelException {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        //Object o = em.find(object.getClass(), object);
        return object;
    }

    @Override
    public Object update(Object object) throws AspelException {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        Object o = em.find(object.getClass(), object);
        return o;
    }

    @Override
    public EntityManager getEntityManager() throws AspelException {
        return this.em;
    }
    
    @Override
    public boolean remove(Object object) throws AspelException {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public <T> List<T> listar(Class className) throws AspelException {        
        Query query = em.createNamedQuery( className.getSimpleName()+".findAll", className.getClass());
        List<T> vuelta = query.getResultList();
        return vuelta;
    }
    
    @Override
    public void finalize() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(String.format("[WARNNING]: FTC-iASPEL %s -- Closing the emf connection for you.", dateFormat.format(Calendar.getInstance().getTime())));
        emf.close();
    }

}
