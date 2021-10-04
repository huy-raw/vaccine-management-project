/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import data.Student;
import data.Vaccine;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author HuyRaw
 */
public class FileDataBase {

    public static ArrayList<Student> loadStudentList(String path) {
        ArrayList<Student> studentList = new ArrayList<>();

        File fileStudent = new File(path);
        try {
            FileInputStream fis = new FileInputStream(fileStudent);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Student stu = (Student) ois.readObject();
                studentList.add(stu);
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println();
        }

        return studentList;
    }

    public static ArrayList<Vaccine> loadVaccineList(String path) {
        ArrayList<Vaccine> vaccineList = new ArrayList<>();
        File fileVaccine = new File(path);
        try {
            FileInputStream fis = new FileInputStream(fileVaccine);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Vaccine vac = (Vaccine) ois.readObject();
                vaccineList.add(vac);
            }
        } catch (ClassNotFoundException | IOException e) {
        }

        return vaccineList;
    
    }
    
     
    
    
 
   
}
