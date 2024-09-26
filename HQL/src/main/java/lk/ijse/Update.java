package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Update {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE Customer SET name = ?1 WHERE id = ?2");
        query.setParameter(1, "Erandi Gamage");
        query.setParameter(2, 2);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }
}
