package org.torresgranadosamaury.pixup.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.torresgranadosamaury.pixup.dao.EstadoDao;
import org.torresgranadosamaury.pixup.model.Estado;
import org.torresgranadosamaury.pixup.hibernate.HibernateUtil;


import java.util.List;

public class EstadoDaoImpl implements EstadoDao {

    @Override
    public List<Estado> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM Estado", Estado.class).list();
        }
    }

    @Override
    public boolean save(Estado estado) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(estado);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Estado estado) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(estado);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Estado estado) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(estado);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Estado findById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Estado.class, id);
        }
    }
}
