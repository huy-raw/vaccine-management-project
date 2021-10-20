/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author HuyRaw
 */
public class Util {
    private static Scanner sc;
    
    //get ID with form 
    public static String getID(String inputMsg, String errorMsg, String format) {
        sc = new Scanner(System.in);
        String id;
        
        boolean match;
        while (true) {            
            System.out.println(inputMsg);
            id = sc.nextLine().trim();
            
            match = id.matches(format);
            if (id.isEmpty()) System.out.println(Message.MSG_ERROR_ID_EMPTY);
            else if ( match == false) System.out.println(errorMsg);
            else return id.toUpperCase();
        }
    }
    
    //get Date
    public static Date getDate(String inputMsg, String errorMsg) {
        Date date;
        String sDate;
        Date currentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat(utils.Constants.DATE_FORMAT);
        format.setLenient(false); // auto plus date
        sc = new Scanner(System.in);
        
        do {
            boolean checkRegex = true;
            
            System.out.println(inputMsg);
            do{
            sDate = sc.nextLine();
            
            if(sDate.matches(Constants.DATE_REGEX)) checkRegex = false;
            else System.out.println(errorMsg);
            }while(checkRegex);
            
            try {
                date = format.parse(sDate);
                if (date.compareTo(currentDate) >= 0) 
                    return date;
                else if (date.compareTo(currentDate) < 0){
                    System.out.println("Expired date must be greater than current date");
                    System.out.println(Constants.UI_DIV);
                }

            } catch (ParseException e) {
                System.out.println(errorMsg);
                System.out.println(Constants.UI_DIV);
            }
        } while (true);

    }
    
    
    
    // get string
    public static String getString(String inputMsg, String errorMsg) {
        sc = new Scanner(System.in);
        String string;
        while (true) {
            System.out.print(inputMsg);
            string = sc.nextLine();
            if (string.length() == 0) {
                System.out.println(errorMsg);
            } else {
                
                return string;
            }
        }
       
    }

    
       //yes/no option
    public static boolean chooseOption(String inputMsg) {
        String s;
        sc = new Scanner(System.in);

        do {
            System.out.println(inputMsg);
            System.out.println("Y/y = YES || N/n = NO");
            s = sc.nextLine();
            if (s.equalsIgnoreCase("y") == true) {
                return true;
            } else if (s.equalsIgnoreCase("n") == true) {
                return false;
            } else {
                System.out.println("Please input Y/y or N/n to choose your option you want!!");
            }
        } while (true);
    }
    
    //menu form
    public static void printManageMenu() {
        System.out.println(Constants.UI_DIV);
        System.out.println("--Welcome to the Refrigerator Management System--");
        System.out.println(Constants.UI_DIV);
        System.out.println("1 - Add a new injection");
        System.out.println("2 - Print the list injection ");
        System.out.println("3 - Search student by ID ");
        System.out.println("4 - Update injection");
        System.out.println("5 - Remove injection");
        System.out.println("6 - Save to file");
        System.out.println("7 - Exit");

    }

    
    
//    public static void main(String[] args) {
//        getDate("Nhap ngay", "Loi");
//    }
        
}
