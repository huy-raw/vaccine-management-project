/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author HuyRaw
 */
public class Message {

    //Input msg
    public static final String MSG_INPUT_ID_INJECTION = "INPUT INJECTION ID (eg: SE123456, AB456890...): ";
    public static final String MSG_INPUT_ID_STUDENT = "INPUT STUDENT ID (eg: SE150000, SE1500...): ";
    public static final String MSG_IPUT_ID_VACCINE = "INPUT VACCINE ID following  the list vaccine: ";
    public static final String MSG_INPUT_DATE_INJECTION = "INPUT DATE injection following the format (eg: 12/02/2021): ";
    public static final String MSG_INPUT_PLACE_INJECTION = "INPUT PLACE injection: ";
    public static final String MSG_INPUT_ID_FOUND_SUCCESSFULY = "The ID you just entered has been found!!!";

    //Error msg
    public static final String MSG_ERROR_ID_EMPTY = "ID can not be empty!! Please input ID following format"  ;  
    public static final String MSG_ERROR_ID_INJECTION_FORMAT = "Injection ID must be start with two character and after it is six number!! (eg: AB123456...)";
    public static final String MSG_ERROR_ID_INJECTION_STUDENT = "Student ID must be start with SE and after it is six number! (eg: SE150324...)";
    public static final String MSG_ERROR_ID_NOTFOUND = "The ID you just entered could not be found. Please input again";
    public static final String MSG_ERROR_DATE_INJECTION = "Date input  must be following format dd/MM/YYYY  ";
    public static final String MSG_ERROR_PLACE_INJECTION = "Place input invalid: ";
    public static final String ERROR_WRONG_INPUT_INT = "The number entered is not valid. Please enter an INTEGER ";
    public static final String MSG_INPUT_ID_STUDENT_EXITS_IN_LIST = "The student who has just entered has injected !!!";

    
    
    //Delete msg
    public static final String MSG_DELETE_INJECTION_INPUT_ID = "Input ID injection you want to delete (eg: SE123456, AB456890...): ";
    public static final String MSG_DELETE_INJECTION_ERROR_ID_EXIST = "The ID dont exist!!";
    public static final String MSG_DELETE_INJECTION_COMFIRM = "The ID you just entered has been found. Do you really want to delete it ???";
    public static final String MSG_DELETE_INJECTION_SUCCESSFULLY = " have been delete succesfully!!";
    
    //Update msg
    public static final String MSG_UPDATE_INJECTION_INPUT_ID = "INPUT Injection ID to update 2rd injection : ";
    public static final String MSG_UPDATE_INJECTION_NOT_FOUND = "ID just entered cound not be found in Injection List ";
    public static final String MSG_UPDATE_INJECTION_DATE2 = "INPUT the second date injection following the format (eg: 12/02/2021):  ";
    public static final String MSG_UPDATE_INJECTION_PLACE2 = "INPUT the second place injection :  ";
    public static final String MSG_UPDATE_DATE_UNVALID = "The second day must be greater than 4 weeks to 12 weeks!! Please input again";
    public static final String MSG_UPDATE_VACCINE_DIFFERENCE = "The second vaccine must be same with vaccine in the first injection ";
    public static final String MSG_UPDATE_SUCCESSFULLY_2_INJECTION = "This student has been 2 injection !!";
    public static final String MSG_UPDATE_NOT_HAVE_1ST_INJECTION = "Student has just searched and hasn't had the 1st injection yet!!";
    
    
    //save to file
    public static final String MSG_SAVE_TO_FILE_OPTION = "Do you want to set name file to save?. IF you choose YES you will INPUT file name, name file will be set Injection.txt IF you choose NO";
    public static final String MSG_SAVE_TO_FILE_INPUT_FNAME = " INPUT name file you wana to save (eg: thaythongdeptrai) the file will be save thaythongdeptrai.txt";
    public static final String MSG_SAVE_TO_FILE_INPUT_FNAME_ERROR = " File name can not be null";
    public static final String MSG_SAVE_TO_FILE_DEFAULT = "The file name is : Injection.txt";
    
    
    
       
}
