package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class MusicService implements IMusicService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            sessionFactory.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Music> showAll() {
        String queryStr = "SELECT c FROM Music AS c";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    public void save(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Music music1 = findById(music.getId());
            music1.setName(music.getName());
            music1.setType(music.getType());
            music1.setSinger(music.getSinger());
            music1.setLink(music.getLink());
            session.saveOrUpdate(music1);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Music findById(Long id) {
        String queryStr = "SELECT c FROM Music AS c WHERE c.id = :id";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void delete(Long id) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Music music = session.load(Music.class, id);
            session.delete(music);
            transaction.commit();

//            Music music1 = findById(music.getId());
//            music1.setName(music.getName());
//            music1.setType(music.getType());
//            music1.setSinger(music.getSinger());
//            music1.setLink(music.getLink());
//            session.saveOrUpdate(music1);


        } catch (Exception e) {
            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

//        String queryStr = "Delete from Music c where c.id = :id";
//        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
//        query.setParameter("id", id);
//
//        query.executeUpdate();

    }

    @Override
    public List<Music> findByName(String name) {
        return null;
    }
}
