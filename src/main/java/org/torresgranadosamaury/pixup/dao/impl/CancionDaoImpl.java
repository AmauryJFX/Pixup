package org.torresgranadosamaury.pixup.dao.impl;

import org.hibernate.Session;
import org.torresgranadosamaury.pixup.dao.CancionDao;
import org.torresgranadosamaury.pixup.hibernate.HibernateUtil;
import org.torresgranadosamaury.pixup.model.Cancion;

import java.util.List;

public class CancionDaoImpl implements CancionDao {

    private static CancionDao cancionDao;

    private CancionDaoImpl() {}

    public static CancionDao getInstance() {
        if (cancionDao == null) {
            cancionDao = new CancionDaoImpl();
        }
        return cancionDao;
    }

    @Override
    public List<Cancion> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM Cancion", Cancion.class).list();
        }
    }

    @Override
    public boolean save(Cancion cancion) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.persist(cancion);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean update(Cancion cancion) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.merge(cancion);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean delete(Cancion cancion) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.remove(cancion);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public Cancion findById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Cancion.class, id);
        }
    }
}
