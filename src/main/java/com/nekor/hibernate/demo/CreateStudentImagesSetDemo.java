package com.nekor.hibernate.demo;

import com.nekor.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

public class CreateStudentImagesSetDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //create the object
            Student student = new Student("hamza", "Diouri", "diourimehdi01@gmail.com");
            List<String> images = student.getImages();
            images.add("photo1");
            images.add("photo2");
            images.add("photo3");
            images.add("photo4");
            images.add("photo4");
            images.add("photo6");

            //start a transaction
            session.beginTransaction();
            //save the object
            System.out.println("Saving the student and images...");
            session.persist(student);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        } finally {
            session.close();
            factory.close();
        }

        //clean up code
    }
}
