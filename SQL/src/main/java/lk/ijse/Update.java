package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class Update {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("UPDATE Customer SET name = ? WHERE id = ?");
        nativeQuery.setParameter(1, "Erandi");
        nativeQuery.setParameter(2,2);
        nativeQuery.executeUpdate();
        transaction.commit();
        session.close();

    }
}
