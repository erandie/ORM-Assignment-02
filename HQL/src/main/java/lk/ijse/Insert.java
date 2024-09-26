package lk.ijse;

import org.hibernate.Session;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Insert {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query =  session.createQuery("INSERT INTO Customer(id, name)" + "SELECT id, name FROM Customer");
        query.setParameter(1,3);
        query.setParameter(2, "Hansi");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
