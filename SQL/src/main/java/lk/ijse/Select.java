package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Select {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM Customer WHERE name = ?");
        nativeQuery.setParameter(1, "Hansi");
        List<Object[]> resultList = nativeQuery.getResultList();
        for(Object[] customer : resultList){
            System.out.println(Arrays.toString(customer));
        }
        transaction.commit();
        session.close();
    }
}
