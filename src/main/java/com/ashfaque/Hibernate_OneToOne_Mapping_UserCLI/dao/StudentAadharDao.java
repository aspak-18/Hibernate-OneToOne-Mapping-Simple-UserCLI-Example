package com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dao;

import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto.Aadhar;
import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class StudentAadharDao {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("hibernate-mapping");
    EntityManager em=emf.createEntityManager();
    EntityTransaction et=em.getTransaction();

    public Student insertAllDao(Aadhar a,Student s){
        try {
            et.begin();
            em.persist(a);
            em.persist(s);
            et.commit();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> displayAllDao(){
        return em.createNativeQuery("select * from student",Student.class).getResultList();
    }
}
