/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.util.Scanner;
import utils.Message;

/**
 *
 * @author HuyRaw
 */
public class InjectionManagement {

    private static Scanner sc;
    private static int userChoice;
    private static InjectionList injection;

    public static void main(String[] args) {
        boolean isExit;
          sc = new Scanner(System.in);
        injection = new InjectionList();
        do {
            isExit = appMenu();
        } while (!isExit);
    }

    public static boolean appMenu() {
        sc = new Scanner(System.in);
        utils.Util.printManageMenu();
        try {
            do{
            userChoice = Integer.parseInt(sc.nextLine());
            if(userChoice <0 || userChoice > 7) System.out.println("Your option invalid!! Please try again");
            }while(userChoice< 0 || userChoice > 7);
        } catch (NumberFormatException ex) {
            System.out.println(Message.ERROR_WRONG_INPUT_INT);
        }
        switch (userChoice) {
            case 1 ->
                injection.addInjection();
            case 2 ->
                injection.listAllInjection();
            case 3 ->
                injection.searchInjectionByID();
            case 4 ->
                injection.updateInjection();
            case 5 ->
                injection.deleteInjection();
            case 6 ->
                injection.exportToFile();
            case 7 -> {
                return true;
            }
        }
        return false;
    }
}
