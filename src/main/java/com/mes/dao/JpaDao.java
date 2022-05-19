package com.mes.dao;

import com.mes.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaDao<E> {
    protected final EntityManagerFactory factory = HibernateUtil.getFactory();

    public E create(E entity) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        return entity;
    }

    public E find(Class<E> type, Object id) {
        EntityManager manager = factory.createEntityManager();
        E entity = manager.find(type, id);
        manager.close();

        return entity;
    }

    public E update(E entity) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            entity = manager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        return entity;
    }

    public List<E> findWithNamedQuery(String queryName) {
        EntityManager entityManager = factory.createEntityManager();

        Query query = entityManager.createNamedQuery(queryName);
        List<E> result = query.getResultList();

        entityManager.close();

        return result;
    }

    public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
        List<E> result = query.getResultList();

        manager.close();

        return result;
    }
}
