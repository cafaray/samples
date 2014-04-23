package com.palestra.wf.model.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DoSomething {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd MM yyyy HH:mm:ss");
	private EntityManager em;
	private EntityManagerFactory emf;
	private final static String ENTITY_MANAGER = "wf-notaria-data";
	private boolean debug = false;

	public DoSomething() {
		emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
		em = emf.createEntityManager();
	}

	public DoSomething(boolean debug) {
		this.debug = debug;
		writeDebug("DoSometing generated");
		emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
		em = emf.createEntityManager();
		writeDebug("Entity Manager created");
	}

	public <T> List<T> list(String namedQuery, Class<T> obj) {
		TypedQuery<T> query = em.createNamedQuery(namedQuery, obj);
		List<T> lst = query.getResultList();
		writeDebug("List ready in a Set!!!");
		return lst;
	}

	public <T> T findById(Class<T> entityClass, String identificador) {
		T vuelta = em.find(entityClass, identificador);
		if (vuelta == null) {
			writeDebug("Entity findById \"" + identificador
					+ "\" --NOT FOUND--");
		} else {
			writeDebug("Entity findById \"" + identificador + "\"");
		}
		return vuelta;
	}

	public <T> T update(T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		writeDebug("Entity updated");
		return obj;
	}

	public void insert(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
		writeDebug("Entity persisted");
	}

	public void remove(Object object) {
		em.getTransaction().begin();
		em.remove(object);
		em.getTransaction().commit();
		writeDebug("Entity removed");
	}

	public <T> void removeById(Class<T> entityClass, String identificador) {
		Object object = findById(entityClass, identificador);
		if (object != null) {
			em.getTransaction().begin();
			em.remove(object);
			em.getTransaction().commit();
			writeDebug("Entity removedById \"" + identificador + "\"");
		}else{
			writeDebug("Could not remove something that does not exists \"" + identificador + "\"");
		}
	}

	public void closeConnection() {
		emf.close();
	}

	private void writeDebug(String mensaje) {
		if (debug)
			System.out.printf("[DEBUG]%s:%s. %s%n",
					dateFormat.format(new Date()), DoSomething.class, mensaje);
	}

	@Override
	public void finalize() {
		if (emf.isOpen()) {
			System.out.print("Closing connection emf for you ");
			emf.close();
			System.out.println(" [OK] \n\tat:" + dateFormat.format(new Date()));
		}
	}
}
