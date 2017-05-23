package ru.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.hibernate.entity.Student;

import javax.persistence.Query;
import java.util.List;

public class HibernateExample {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

//        Student student=session.get(Student.class,1);
//        Set<Exam> exams=student.getExams();

        Query query=session.createQuery("from Student");
        List<Student> students=query.getResultList();

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
