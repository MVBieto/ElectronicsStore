package Dao;

import Models.Customer;
import Util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CustomerDao {

    public CustomerDao() {
    }

    public void createCustomer(Customer customer) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public Customer getCustomer(Long customerId) {
        Session session = Hibernate.getSessionFactory().openSession();
        try {
            Customer customer = session.find(Customer.class, customerId);
            session.close();
            return customer;
        } catch (Exception ex) {
            session.close();
            System.out.println("Unable to find the product with id: " + customerId);
            ex.printStackTrace();
            return null;
        }
    }

    public List<Customer> getCustomers() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from Customer", Customer.class).list();
    }

    public void updateCustomer(Customer savedCustomer) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(savedCustomer);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void deleteCustomer(Customer savedUser) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(savedUser);
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
