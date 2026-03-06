
package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Insert sample products
        session.save(new Product("Laptop","Electronics",55000,10));
        session.save(new Product("Mouse","Electronics",800,50));
        session.save(new Product("Keyboard","Electronics",1200,30));
        session.save(new Product("Chair","Furniture",3000,15));
        session.save(new Product("Table","Furniture",6000,8));
        session.save(new Product("Pen","Stationery",20,200));
        session.save(new Product("Notebook","Stationery",100,120));

        tx.commit();

        // Sorting price ascending
        Query<Product> asc = session.createQuery("from Product order by price asc", Product.class);
        asc.list().forEach(p -> System.out.println("ASC Price: "+p.getName()+" "+p.getPrice()));

        // Sorting price descending
        Query<Product> desc = session.createQuery("from Product order by price desc", Product.class);
        desc.list().forEach(p -> System.out.println("DESC Price: "+p.getName()+" "+p.getPrice()));

        // Sort by quantity highest first
        Query<Product> qty = session.createQuery("from Product order by quantity desc", Product.class);
        qty.list().forEach(p -> System.out.println("Quantity: "+p.getName()+" "+p.getQuantity()));

        // Pagination first 3
        Query<Product> page1 = session.createQuery("from Product", Product.class);
        page1.setFirstResult(0);
        page1.setMaxResults(3);
        System.out.println("First 3 products:");
        page1.list().forEach(p -> System.out.println(p.getName()));

        // Pagination next 3
        Query<Product> page2 = session.createQuery("from Product", Product.class);
        page2.setFirstResult(3);
        page2.setMaxResults(3);
        System.out.println("Next 3 products:");
        page2.list().forEach(p -> System.out.println(p.getName()));

        // Aggregates
        Long total = (Long) session.createQuery("select count(*) from Product").uniqueResult();
        System.out.println("Total products: "+total);

        Long qtyGreater0 = (Long) session.createQuery("select count(*) from Product where quantity > 0").uniqueResult();
        System.out.println("Products with quantity >0: "+qtyGreater0);

        List<Object[]> grouped = session.createQuery("select description, count(*) from Product group by description").list();
        grouped.forEach(g -> System.out.println("Group: "+g[0]+" count="+g[1]));

        Object[] minmax = (Object[]) session.createQuery("select min(price), max(price) from Product").uniqueResult();
        System.out.println("Min price="+minmax[0]+" Max price="+minmax[1]);

        // Price range filter
        Query<Product> range = session.createQuery("from Product where price between 100 and 10000", Product.class);
        range.list().forEach(p -> System.out.println("Price range: "+p.getName()));

        // LIKE queries
        session.createQuery("from Product where name like 'L%'", Product.class)
                .list().forEach(p -> System.out.println("Starts with L: "+p.getName()));

        session.createQuery("from Product where name like '%e'", Product.class)
                .list().forEach(p -> System.out.println("Ends with e: "+p.getName()));

        session.createQuery("from Product where name like '%top%'", Product.class)
                .list().forEach(p -> System.out.println("Contains top: "+p.getName()));

        session.createQuery("from Product where length(name)=5", Product.class)
                .list().forEach(p -> System.out.println("Length 5: "+p.getName()));

        session.close();
    }
}
