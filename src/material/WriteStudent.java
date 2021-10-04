/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material;

import data.Student;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HuyRaw
 */
public class WriteStudent {
    public static void main(String[] args) {
        List<Student> list= new ArrayList<>();
        try {
            String fileName="student.txt";
            FileOutputStream file= new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            
            list.add(new Student("SE150000", "Hoa Doan"));
            list.add(new Student("SE150001", "Hong Hanh"));
            list.add(new Student("SE150002", "Quang Huy"));
            list.add(new Student("SE150003", "Anh Khoa"));
            list.add(new Student("SE150004", "Van Que"));
            list.add(new Student("SE150005", "Ngoc Thi"));
            list.add(new Student("SE150006", "Ngoc An"));
            list.add(new Student("SE150007", "Thu Huong")); 
            list.add(new Student("SE150008", "Mai Lan")); 
            list.add(new Student("SE150009", "Tuan Tu"));
            list.add(new Student("SE150010", "Hoang Loan")); 
            for (Student student : list) {
                oStream.writeObject(student);
            }
            oStream.close();
            file.close();
        } catch (IOException e) {
        }
        
    }

    
}
