/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import utils.Constants;
import utils.FileDataBase;
import utils.Message;
import utils.Util;

/**
 *
 * @author HuyRaw
 */
public class InjectionList {

    java.util.ArrayList<Injection> injectionList = FileDataBase.loadInjectionList(Constants.INJECTION_FILE_PATH);
    Scanner sc;

    public InjectionList() {
    }

    public ArrayList<Injection> getInjectionList() {
        return injectionList;
    }

    public void setInjectionList(ArrayList<Injection> injectionList) {
        this.injectionList = injectionList;
    }

    //load Data
    ArrayList<Student> studentList = FileDataBase.loadStudentList(Constants.STUDENT_FILE_PATH);
    ArrayList<Vaccine> vaccineList = FileDataBase.loadVaccineList(Constants.VACCINE_FILE_PATH);

    //adding injection
    public void addInjection() {
        sc = new Scanner(System.in);
        String _idInj, _place, _idVac, _idStu, _nameStudent = "", _nameVaccine = "";
        Date _date;
        int pos;
        boolean success, injection1;
        
        
        //get ID injection
        do {
            _idInj = Util.getID(Message.MSG_INPUT_ID_INJECTION, Message.MSG_ERROR_ID_INJECTION_FORMAT, Constants.REGEX_INJECTION_ID);
            pos = checkIDAvailableInjectionID(_idInj);
            if (pos > 0) {
                System.out.println("ID you just enter is existed!!!");
            }
        } while (pos != -1);

        //getID, name student
        listAllStudent();
        do {
            success = false;
            _idStu = Util.getID(Message.MSG_INPUT_ID_STUDENT, Message.MSG_ERROR_ID_INJECTION_STUDENT, Constants.REGEX_STUDENT_ID);

            for (Student student : studentList) {
                if (student.getStudentID().equalsIgnoreCase(_idStu)) {
                    _nameStudent = student.getStudentName();                  
                    System.out.println(Message.MSG_INPUT_ID_FOUND_SUCCESSFULY);
                }
            }
            if (_nameStudent.isEmpty()) {
                System.out.println(Message.MSG_ERROR_ID_NOTFOUND);
                success = true;
            }else if(checkStuExistInList(_idStu) > 0){
                System.out.println(Message.MSG_INPUT_ID_STUDENT_EXITS_IN_LIST);
                success = true;
            }
            

        } while (success);
        

        //get vaccine ID
        listAllVaccine();
        do {
            success = false;
            _idVac = Util.getID(Message.MSG_IPUT_ID_VACCINE, Message.MSG_ERROR_ID_NOTFOUND, Constants.REGEX_VACCINE_ID);
            for (Vaccine vaccine : vaccineList) {
                if (vaccine.getVaccineID().equalsIgnoreCase(_idVac)) {
                    _nameVaccine = vaccine.getVaccineName();
                } 
            }
             if (_nameVaccine.isEmpty()) {
                System.out.println(Message.MSG_ERROR_ID_NOTFOUND);
                success = true;
            }
        } while (success);
        
       
        //get date
        _date = Util.getDate(Message.MSG_INPUT_DATE_INJECTION, Message.MSG_ERROR_DATE_INJECTION);

        //get place
        _place = Util.getString(Message.MSG_INPUT_PLACE_INJECTION, Message.MSG_ERROR_PLACE_INJECTION);
        injection1 = true;

        Injection injection = new Injection(_idStu, _idInj, _nameStudent, _idVac,_nameVaccine, _date, _place, injection1);
        injectionList.add(injection);
        if (Util.chooseOption("Do you wana to continue add new injection ??")) {
            this.addInjection();
        }

    }
    
    
    //checking update
    public void updateInjection(){
        boolean checking = true;
        do {            
            
            sc = new Scanner(System.in);
            String _id = Util.getID(Message.MSG_UPDATE_INJECTION_INPUT_ID, Message.MSG_ERROR_ID_INJECTION_FORMAT, Constants.REGEX_INJECTION_ID);
            
            for (Injection injection : injectionList) {
               
                if(injection.getInjectionID().equalsIgnoreCase(_id) && injection.isInjection2()) {                  
                    System.out.println(Message.MSG_UPDATE_SUCCESSFULLY_2_INJECTION);
                    return;
                    
                }
                else if (injection.getInjectionID().equalsIgnoreCase(_id) && injection.isInjection1()) {                   
                    System.out.println(Message.MSG_INPUT_ID_FOUND_SUCCESSFULY);
                    System.out.println(injection.toString());
                    update(_id);      
                    return;
                    
                }
            }
            
            
            if(checking) {
                System.out.println(Message.MSG_UPDATE_NOT_HAVE_1ST_INJECTION);
                checking = false;
            }      
               
        } while (checking);
    }
    
    
    //updating
    public void update(String _id){
        injectionList.forEach(injection -> {
            if(injection.getInjectionID().equalsIgnoreCase(_id)) {
                boolean check = true;
                listAllVaccine();  
                
                //vaccine 2rd must be same vaccine in the first injection
                do{
                    
                    String _idVac = Util.getID(Message.MSG_IPUT_ID_VACCINE, Message.MSG_ERROR_ID_NOTFOUND, Constants.REGEX_VACCINE_ID);

                        if(injection.getVaccineID().equalsIgnoreCase(_idVac)) check = false;
                        else System.out.println(Message.MSG_UPDATE_VACCINE_DIFFERENCE);
                     
                    
                }while(check);
                //Update date and place 
                Date _date1, _date2;
                do{
                    _date1 = injection.getDate1();
                    _date2 = Util.getDate(Message.MSG_UPDATE_INJECTION_DATE2, Message.MSG_ERROR_DATE_INJECTION);
                    if(!checkDate(_date1, _date2)) System.out.println(Message.MSG_UPDATE_DATE_UNVALID); 
         
                }while(!checkDate(_date1, _date2));
                
                String _place = Util.getString(Message.MSG_UPDATE_INJECTION_PLACE2, Message.MSG_ERROR_PLACE_INJECTION);
                injection.setDate2(_date2);
                injection.setPlace2(_place);
                boolean injection2 = true;
                injection.setInjection2(injection2);
                System.out.println("Student has completed 2 injections!-Congatulation you can go everywhere you want!!!");
                System.out.println(Constants.UI_DIV);
                
            }
           
        });
        
    }

    //check duplicate id injection
    private int checkIDAvailableInjectionID(String ID) {
        if (injectionList == null) {
            return -1;
        } else {
            for (Injection injection : injectionList) {
                if (injection.getInjectionID().equalsIgnoreCase(ID)) {
                    return 1;
                }
            }

        }
        return -1;
    }
    
    //check student have been injection
    private int checkStuExistInList(String ID) {
        if (injectionList == null) {
            return -1;
        } else {
            for (Injection injection : injectionList) {
                if (injection.getStudentID().equalsIgnoreCase(ID)) {
                    return 1;
                }
            }

        }
        return -1;
    }

    //delete injection
    public void deleteInjection() {
        String injectionID;
        boolean isExist = false;
        injectionID = Util.getID(Message.MSG_DELETE_INJECTION_INPUT_ID, Message.MSG_DELETE_INJECTION_ERROR_ID_EXIST, Constants.REGEX_INJECTION_ID);
        System.out.println(Constants.UI_DIV);

        for (Injection injection : injectionList) {
            if (injection.getInjectionID().equalsIgnoreCase(injectionID)) {
                if (Util.chooseOption(Message.MSG_DELETE_INJECTION_COMFIRM)) {
                    System.out.println("The injection have ID: " + injectionID);
                    if (delete(injectionID)) {
                        System.out.println("The injection have ID : " + injectionID + Message.MSG_DELETE_INJECTION_SUCCESSFULLY);
                        isExist = true;
                    }
                    return;
                }
            }
        }
        if(!isExist) System.out.println("Student not found!!!");
        
    }

    public boolean delete(String injectionID) {
        return injectionList.removeIf(injection -> {
            boolean isMatch = injection.getInjectionID().equalsIgnoreCase(injectionID);
            return isMatch;
        });
    }

    //list student
    public void listAllStudent() {
        System.out.println(String.format("|%10s|%20s|", "StudenID", "StudentName"));
        System.out.println(Constants.UI_DIV);
        studentList.forEach(student -> {
            System.out.println(student.toString());
        });
        System.out.println(Constants.UI_DIV);
    }
    //list vaccine
    public void listAllVaccine() {
        System.out.println(String.format("|%10s|%20s|", "VaccineID", "VaccineName"));
        System.out.println(Constants.UI_DIV);
        vaccineList.forEach(vaccine -> {
            System.out.println(vaccine.toString());
        });
        System.out.println(Constants.UI_DIV);
    }
    //list injection
    public void listAllInjection() {
        System.out.println(String.format("|%-12s|%-12s|%-15s|%-15s|%-10s|%-15s|%-10s|%-15s|", "INJECTION ID", "STUDENT ID", "STUDENT NAME", "VACCINE NAME",
                                                                                                   "DATE 1", "PLACE1", "DATE 2", "PLACE 2" ));
        System.out.println(Constants.UI_DIV);
        
        injectionList.forEach(injection -> {
            System.out.println(injection.toString());
        });
        System.out.println(Constants.UI_DIV);
    }
        
 
    //second day must be greater than first day 4 weeks to 12 weeks
    public boolean checkDate(Date date1, Date date2){
        long checkDay = date2.getTime() - date1.getTime();
        long checkValue = TimeUnit.DAYS.convert(checkDay, TimeUnit.MILLISECONDS);
        return checkValue >= 28 && checkValue <= 84;
    }
    
    //save to file
    
    public void exportToFile() {
        String fileName;
        if(Util.chooseOption(Message.MSG_SAVE_TO_FILE_OPTION)) {
            fileName = Util.getString(Message.MSG_SAVE_TO_FILE_INPUT_FNAME, Message.MSG_SAVE_TO_FILE_INPUT_FNAME_ERROR);
            export(fileName+".txt");
            System.out.println("Export successfully!!");
        }else{
            fileName = Constants.INJECTION_FILE_PATH;
            export(fileName);
            System.out.println("Export successfully!!");
        }
    }
            
    public void export(String path){
        String fileName= path;
        try (FileOutputStream file = new FileOutputStream(fileName)) {
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            for (Injection injection : injectionList) {
                oStream.writeObject(injection);
            }
            oStream.close();
            file.close();      
        } catch (IOException e){
            System.out.println("Error export!!");
        }
    }
    //Search student by ID
    public void searchInjectionByID() {
        boolean isExist = false;
        sc  = new  Scanner(System.in);
        String _idStudent = Util.getID(Message.MSG_FIND_INPUT_ID, Message.MSG_FIND_ERROR_ID_STUDENT, Constants.REGEX_STUDENT_ID);
        for (Injection injection : injectionList) {
            if(injection.getStudentID().equalsIgnoreCase(_idStudent)) {
                System.out.println("Information students need to find is: ");
                System.out.println(String.format("|%-12s|%-12s|%-15s|%-15s|%-10s|%-15s|%-10s|%-15s|", "INJECTION ID", "STUDENT ID", "STUDENT NAME", "VACCINE NAME",
                        "DATE 1", "PLACE1", "DATE 2", "PLACE 2" ));
                System.out.println(injection.toString());               
                return;
            } 
        }
        
        if(!isExist) System.out.println("Student not found!!!");  
    }
    
    

}
