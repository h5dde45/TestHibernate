package ru.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.hibernate.entity.Student;

public class HibernateExample {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Student student=new Student();
//        student.setFirstName("tri");
//        student.setLastName("TRI");
//        student.setAge(22);
//
//        session.save(student);

        student=session.get(Student.class,2);
        System.out.println(student);
//        student.setAge(55);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
