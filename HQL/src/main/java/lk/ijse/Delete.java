package lk.ijse;

import org.hibernate.query.Query;
import org.hibernate.Session;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Transaction;

public class Delete {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Customer WHERE id = ?1");
        query.setParameter(1,3);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
