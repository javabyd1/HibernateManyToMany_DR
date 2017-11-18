import model.Order;
import model.Product;
import org.hibernate.Session;
import util.HibernateUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order ();
        order1.setOrderDate (LocalDate.now ());
        Order order2 = new Order ();
        order2.setOrderDate (LocalDate.now ());
        Order order3 = new Order ();
        order3.setOrderDate (LocalDate.now ());

        Product product1 = new Product ();
        product1.setName ("Mleko");
        product1.setDescription ("3,2%");
        Product product2 = new Product ();
        product2.setName ("Kisiel");
        product2.setDescription ("truskawkowy");
        Product product3 = new Product ();
        product3.setName ("Budyń");
        product3.setDescription ("czekoladowy");

        order1.getProducts ().add (product1);
        order1.getProducts ().add (product2);
        order1.getProducts ().add (product3);

        order2.getProducts ().add (product2);
        order2.getProducts ().add (product3);

        order3.getProducts ().add (product1);
        order3.getProducts ().add (product3);

        Session session = HibernateUtil.getHibernateSession ();
        session.beginTransaction ();

        session.save (order1);
        session.save (order2);
        session.save (order3);

        session.getTransaction ().commit ();
        session.close ();
    }
}
