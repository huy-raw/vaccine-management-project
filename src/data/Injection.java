/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HuyRaw
 */
public class Injection extends Student implements Serializable{

    private String vaccineID, vaccineName;
    private String injectionID;
    private String place1;
    private Date date1;
    private String place2;
    private Date date2;
    private boolean injection1 = false;
    private boolean injection2 = false;
    
    

    public Injection() {
    }

    public Injection(String studentID, String injectionID, String studentName, String vaccineID,String vaccineName,
                                            Date date1, String place1, boolean injection1) {
        super(studentID, studentName);
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
        this.injectionID = injectionID;
        this.place1 = place1;
        this.date1 = date1;
        this.injection1 = injection1;
        
    }
    
    public Injection(String studentID, String injectionID, String studentName, String vaccineID, String vaccineName, 
                                        Date date1, String place1, Date date2, String place2, boolean injection1, boolean injection2) {
        super(studentID, studentName);
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
        this.injectionID = injectionID;
        this.place1 = place1;
        this.date1 = date1;
        this.place2 = place2;
        this.date2 = date2;
        this.injection1 = injection1;
        this.injection2 = injection2;
        
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public boolean isInjection1() {
        return injection1;
    }

    public void setInjection1(boolean injection1) {
        this.injection1 = injection1;
    }

    public boolean isInjection2() {
        return injection2;
    }

    public void setInjection2(boolean injection2) {
        this.injection2 = injection2;
    }

    
   
     @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String _date1 = simpleDateFormat.format(date1);
        String _date2;
        if (place2 != null) {
            _date2 = simpleDateFormat.format(date2);
            return String.format("|%-12s|%-12s|%-15s|%-15s|%-10s|%-15s|%-10s|%-15s|",injectionID, studentID, studentName, vaccineName, _date1, place1, _date2, place2);
        }else return String.format("|%-12s|%-12s|%-15s|%-15s|%-10s|%-15s|%-10s|%-15s|", injectionID, studentID, studentName, vaccineName,  _date1, place1, "-", "-");

    }
    
    
    

}
