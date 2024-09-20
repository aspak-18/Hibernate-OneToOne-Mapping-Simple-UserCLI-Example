package com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.Controller;

import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.Service.AgeCalculator;
import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dao.AadharDao;
import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dao.StudentAadharDao;
import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dao.StudentDao;
import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto.Aadhar;
import com.ashfaque.Hibernate_OneToOne_Mapping_UserCLI.dto.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;
        do {
            System.out.println("1.Insert Student\n2.Insert Aadhar\n3.Insert All\n4.Delete Student By Id\n5.Delete Aadhar By AadharNumber\n6.Update Student Name\n7.Update Aadhar Date of Birth\n8.Display Student By Id \n9.Display Aadhar By Id\n10.Display All Details ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    StudentDao dao = new StudentDao();
                    System.out.println("Enter Student id:");
                    int id = sc.nextInt();
                    System.out.println("Enter Student Name:");
                    String name = sc.next();
                    System.out.println("Enter Email:");
                    String email = sc.next();
                    Aadhar aadhar = new Aadhar();
                    System.out.println("Enter Aadhar no to match and add:");
                    long a_no = sc.nextLong();
                    Student student = new Student(id, name, email, aadhar);
                    Student s = dao.insertStudentDao(student, a_no);
                    if (s != null)
                        System.out.println("Data Inserted Successfully.....");
                    else
                        System.out.println("Something went wrong!!!!");
                    System.out.println(s);
                    if (s.getAadhar() != null)
                        System.out.println(s.getAadhar());
                }break;

                case 2: {
                    AadharDao dao = new AadharDao();
                    System.out.println("Enter Aadhar no:");
                    long aadhar_no = sc.nextLong();
                    System.out.println("Enter Date of Birth in (YYYY-MM-DD) format:");
                    String dob = sc.next();

                    System.out.println("Enter Gender: ");
                    String gender = sc.next();
                    int age = AgeCalculator.getAge(LocalDate.parse(dob));
                    Aadhar aadhar = new Aadhar(aadhar_no, LocalDate.parse(dob), age, gender);
                    Aadhar a = dao.insertAadharDao(aadhar);
                    if (a != null)
                        System.out.println("Data Inserted Successfully.....");
                    else
                        System.out.println("Something went wrong!!!!");
                }break;

                case 3: {
                    StudentAadharDao dao = new StudentAadharDao();
                    System.out.println("Enter Aadhar no:");
                    long aadhar_no = sc.nextLong();
                    System.out.println("Enter Date of Birth in (YYYY-MM-DD) format:");
                    String dob = sc.next();
                    System.out.println("Enter Gender: ");
                    String gender = sc.next();
                    int age = AgeCalculator.getAge(LocalDate.parse(dob));

                    System.out.println("Enter Student id:");
                    int id = sc.nextInt();
                    System.out.println("Enter Student Name:");
                    String name = sc.next();
                    System.out.println("Enter Email:");
                    String email = sc.next();
                    System.out.println("Enter Aadhar no to match and add:");
                    long a_no = sc.nextLong();
                    Aadhar aadhar = new Aadhar(aadhar_no, LocalDate.parse(dob), age, gender);
                    Student student = new Student(id, name, email, aadhar);
                    Student s = dao.insertAllDao(aadhar, student);
                    if (s != null) {
                        System.out.println("Both Table data Inserted");
                        System.out.println(s);
                        if (s.getAadhar() != null)
                            System.out.println(s.getAadhar());
                    } else
                        System.out.println("Something went wrong!!!!!");

                }break;

                case 4: {
                    StudentDao dao = new StudentDao();
                    System.out.println("Enter Student id to delete:");
                    int id = sc.nextInt();
                    boolean b = dao.deleteStudentByIdDao(id);
                    if (b)
                        System.out.println("Student data deleted....");
                    else
                        System.out.println("Something went wrong");

                }break;

                case 5: {
                    AadharDao dao = new AadharDao();
                    System.out.println("Enter Aadhar id to delete:");
                    int id = sc.nextInt();
                    boolean b = dao.deleteAadharByIdDao(id);
                    if (b)
                        System.out.println("Aadhar data deleted....");
                    else
                        System.out.println("Something went wrong");

                }break;

                case 6: {
                    StudentDao dao = new StudentDao();
                    System.out.println("Enter Student id to update:");
                    int id = sc.nextInt();
                    System.out.println("Enter new name of Student:");
                    String name = sc.next();
                    boolean b = dao.updateStudentNameByIdDao(name, id);
                    if (b)
                        System.out.println("Student data updated....");
                    else
                        System.out.println("Something went wrong");
                }break;

                case 7: {
                    AadharDao dao = new AadharDao();
                    System.out.println("Enter Aadhar number to update:");
                    int id = sc.nextInt();
                    System.out.println("Enter new Date of birth of Student:");
                    String dob = sc.next();
                    boolean b = dao.updateAadharDobByIdDao(LocalDate.parse(dob), id);
                    if (b)
                        System.out.println("Aadhar data updated....");
                    else
                        System.out.println("Something went wrong");
                }break;

                case 8: {
                    StudentDao dao = new StudentDao();
                    System.out.println("Enter Student id:");
                    int id = sc.nextInt();
                    Student stu = dao.displayStudentById(id);
                    if (stu != null) {
                        System.out.println(stu);
                        if (stu.getAadhar() != null)
                            System.out.println(stu.getAadhar());
                    } else
                        System.out.println("Something went wrong!!!!!");
                }break;

                case 9: {
                    AadharDao dao = new AadharDao();
                    System.out.println("Enter Aadhar number:");
                    long id = sc.nextLong();
                    Aadhar aadhar = dao.displayAadharById(id);
                    if (aadhar != null) {
                        System.out.println(aadhar);
                    } else
                        System.out.println("Something went wrong!!!!!");
                }break;

                case 10:{
                    StudentAadharDao dao=new StudentAadharDao();
                    List<Student> s =dao.displayAllDao();
                    if (s!=null){
                        for (Student stud:s){
                            if (stud.getAadhar()!=null){
                                System.out.println(stud);
                                System.out.println(stud.getAadhar());
                                System.out.println("========================================================");
                            }
                        }

                    }
                }break;

                default:
                    System.out.println("Invalid Option!!  Try again!!");
            }
            System.out.println("Press y/Y to try again!");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
    }
}
