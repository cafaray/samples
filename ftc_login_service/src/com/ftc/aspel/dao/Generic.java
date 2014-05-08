package com.ftc.aspel.dao;

import com.ftc.aspel.exception.AspelException;
import java.util.List;
import javax.persistence.EntityManager;

public interface Generic {

    Object insert(Object object) throws AspelException;

    Object update(Object object) throws AspelException;

    boolean remove(Object object) throws AspelException;

    <T> List<T> listar(Class className) throws AspelException;

    EntityManager getEntityManager() throws AspelException;
}
