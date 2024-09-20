package com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dao;

import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto.Aadhar;
import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentDao {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("hibernate-mapping");
    EntityManager em=emf.createEntityManager();
    EntityTransaction et=em.getTransaction();

    public Student insertStudentDao(Student stud,long aadhar_no){
        try {
            Aadhar aad=em.find(Aadhar.class,aadhar_no);
            if (aad!=null){
                stud.setAadhar(aad);
                et.begin();
                em.persist(stud);
                et.commit();
                return stud;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean deleteStudentByIdDao(int id){
        try {
            Student s=em.find(Student.class,id);
            if (s!=null){
                s.setAadhar(null);
                et.begin();
                em.remove(s);
                et.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean updateStudentNameByIdDao(String name,int id){
        try {
            Student s=em.find(Student.class,id);
            if (s!=null){
                s.setName(name);
                et.begin();
                em.merge(s);
                et.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public Student displayStudentById(int id){
        try {
            return em.find(Student.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
