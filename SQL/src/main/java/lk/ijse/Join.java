package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;
import java.util.Objects;

public class Join {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT name,aid FROM customer c RIGHT JOIN address a ON c.id = a.customer_id");
        List<Objects[]> resultList = nativeQuery.getResultList();
        for (Objects[] objects : resultList) {
            System.out.println("Name: " + objects[0] + ", AddressId: " + objects[1]);
        }

        transaction.commit();
        session.close();

    }
}
