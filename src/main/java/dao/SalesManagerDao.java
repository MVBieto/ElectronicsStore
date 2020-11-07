package dao;
import models.SalesManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;
public class SalesManagerDao {
    public SalesManagerDao() {
    }
    public void createSalesManager(SalesManager salesManager) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(salesManager);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
    public SalesManager getSalesManager(Long salesManagerId) {
        Session session = Hibernate.getSessionFactory().openSession();
        try {
            SalesManager SM = session.find(SalesManager.class, salesManagerId);
            session.close();
            return SM;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the SalesManager with id: "+ salesManagerId);
            ex.printStackTrace();
            return null;
        }
    }
    public List<SalesManager> getSalesManagers(){
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from SalesManager", SalesManager.class).list();
    }
    public void updateSalesManager(SalesManager savedSalesManager) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedSalesManager);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
    public void deleteSalesManager(SalesManager savedSalesManager) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(savedSalesManager);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
}