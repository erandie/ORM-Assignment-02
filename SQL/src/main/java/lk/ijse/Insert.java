package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class Insert {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("INSERT INTO Customer VALUES (?, ?)");
        nativeQuery.setParameter(1,3);
        nativeQuery.setParameter(2, "Hansi");
        nativeQuery.executeUpdate();
        transaction.commit();
        session.close();
    }
}
