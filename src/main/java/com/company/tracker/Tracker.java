package com.company.tracker;

import com.company.entity.Clan;
import org.hibernate.*;

import javax.transaction.*;
import javax.transaction.Transaction;

public class Tracker {
    private static SessionFactory sessionFactory;

    public Tracker(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static void trackerClanGold(Clan clan) throws HibernateException, SystemException {//здесь сохранение трекера в базу
        Session session = sessionFactory.openSession();
        Transaction transaction = (Transaction) session.beginTransaction();

        try {
            session.save(clan);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
