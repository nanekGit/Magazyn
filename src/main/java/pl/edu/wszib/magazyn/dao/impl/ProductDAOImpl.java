package pl.edu.wszib.magazyn.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.magazyn.dao.iProductDAO;
import pl.edu.wszib.magazyn.model.Product;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ProductDAOImpl implements iProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.edu.wszib.magazyn.model.Product");
        List<Product> products = query.getResultList();
        session.close();
        return products;
    }

    @Override
    public Product getProductByID(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.edu.wszib.magazyn.model.Product WHERE id = :id");
        query.setParameter("id", id);
        Product result = null;
        try{
            result = query.getSingleResult();
        }catch (NoResultException e){}
        session.close();
        return result;
    }

    @Override
    public Product getProductByName(String name) {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.edu.wszib.magazyn.model.Product WHERE name = :name");
        query.setParameter("name", name);
        Product result = null;
        try{
            result = query.getSingleResult();
        }catch (NoResultException e){}
        session.close();
        return result;
    }

    @Override
    public boolean persistProduct(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(product);
            tx.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }finally {
            session.close();
        }
        return false;
    }
}
