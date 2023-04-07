package se.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class GenericRepo<T,v> {
    private EntityManager em;
    private String entityName;

    public GenericRepo( String entityName) {
        this.entityName = entityName;
        em = Persistence.createEntityManagerFactory("vinh").createEntityManager();
    }
    public T add(T t) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(t);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        }
        return t;
    }

    public T update(T t) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(t);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        }
        return t;
    }

    public boolean delete(T t, v id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            T t1= findById(t, id);
            em.remove(t1);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public T findById(T entity, v id) {
        return (T) em.find(entity.getClass(), id);
    }

    public List<T> findAll() {
        String sql = "from " + entityName;
        List<T> lst = em.createQuery(sql).getResultList();
        return lst;
    }
}
