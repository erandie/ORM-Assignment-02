package lk.ijse.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class JPQLModule {
    public void insertCustomer(EntityManager entityManager, String name){
        Customer customer = new Customer();
        customer.setName(name);

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    public void deleteCustomer(EntityManager entityManager, int cId){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Customer s WHERE s.id = :cid");
        query.setParameter("cid", cId);
        int rowsDeleted = query.executeUpdate();
        entityManager.getTransaction().commit();
    }

}
