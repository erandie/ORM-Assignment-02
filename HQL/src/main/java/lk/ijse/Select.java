package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class Select {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT id, name FROM  Customer WHERE id = ?1");
        query.setParameter(1, 1);
        List<Objects[]> resultList = query.getResultList();
        for(Objects[] objects : resultList){
            System.out.println("ID : " + objects[0] +"Name : " + objects[1]);
        }

        Query query1 = session.createQuery("SELECT id, name FROM Customer");
        List<Objects[]> resultList1 = query1.getResultList();
        for (Objects[] objects : resultList1){
            System.out.println("ID : " + objects[0] + "Name: " +objects[1]);
        }

        Query query2 = session.createQuery("SELECT a.aid, c.name FROM Address a INNER JOIN Customer c on a.aid = c.cid");
        List<Objects[]> resultList2 = query2.getResultList();
        for (Objects[] objects:resultList2){
            System.out.println("AddressID: " + objects[0] + "Name: " + objects[1]);
        }

        transaction.commit();
        session.close();
    }
}
