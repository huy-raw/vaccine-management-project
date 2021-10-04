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
public class Constants {
    public static final String REGEX_INJECTION_ID = "^[a-zA-Z]{2}\\d{6}$";
    public static final String REGEX_STUDENT_ID = "^[s|S]{1}[e|E]{1}\\d{6}$";
    public static final String REGEX_VACCINE_ID = "^[c|C]{1}[o|O]{1}[v|V]{1}[i|I]{1}[d|D]{1}[-]{1}[v|V]{1}\\d{3}$";
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String DATE_REGEX = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9]|[0-9])/[0-9]{4}$";
    public static final String UI_DIV = "------------------------------------";
    public static final String STUDENT_FILE_PATH = "student.txt";
    public static final String VACCINE_FILE_PATH = "vaccine.txt";
}
