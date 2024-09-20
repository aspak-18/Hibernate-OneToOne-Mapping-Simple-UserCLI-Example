package com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dao;

import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.Service.AgeCalculator;
import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto.Aadhar;
import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class AadharDao {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("hibernate-mapping");
    EntityManager em=emf.createEntityManager();
    EntityTransaction et=em.getTransaction();

    public Aadhar insertAadharDao(Aadhar aadhar){
        try {
            et.begin();
            em.persist(aadhar);
            et.commit();
            return aadhar;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteAadharByIdDao(int id){
        try {
            Aadhar a=em.find(Aadhar.class,id);
            if (a!=null){
                et.begin();
                em.remove(a);
                et.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean updateAadharDobByIdDao(LocalDate dob, int a_no){
        try {
            Aadhar a=em.find(Aadhar.class,a_no);
            if (a!=null){
                a.setDob(dob);
                a.setAge(AgeCalculator.getAge(dob));
                et.begin();
                em.merge(a);
                et.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public Aadhar displayAadharById(long id){
        try {
            return em.find(Aadhar.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
