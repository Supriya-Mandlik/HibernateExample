package com.code;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws IOException
    {
        System.out.println( "Project Started..." );
        
        Configuration cfg = new Configuration();
        cfg.configure();
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        //creating student
        Student st = new Student();
        st.setId(105);
        st.setName("Dipali");
        st.setCity("Akole");
        System.out.println(st);
        
        // creating object of address class
        Address add = new Address();
        add.setStreet("Street4");
        add.setCity("Akole");
        add.setOpen(true);
        add.setAddedDate(new Date());
        add.setX(1234.234);
        
        // Reading image
        FileInputStream fis = new FileInputStream("src/main/java/red.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        add.setImage(data);
        
        Session session = factory.openSession();   
       // it will create new session . we want session to get methods from it .session has methods.
        
        session.beginTransaction();   // it will begin transaction
        // transaction is necessory when we are saving the data.
        
        session.save(st);   // session has save method   // it will save object
        
        session.save(add);
        
        session.getTransaction().commit();   //it will commit transaction
         
        // OR
        
      //  Transaction tx = session.beginTransaction();
      //  session.save(st);
      //  tx.commit();
           
        session.close();
        
        System.out.println("Done...");
        
       // System.out.println(factory);
        //System.out.println(factory.isClosed());
        
        
    }
}
