/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material;

import data.Vaccine;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HuyRaw
 */
public class WriteVaccine {
    public static void main(String[] args) {
        try {
            String fileName="vaccine.txt";
            FileOutputStream file= new FileOutputStream(fileName);
            ObjectOutputStream oSteam = new ObjectOutputStream(file);
            List<Vaccine> list= new ArrayList<>();
            list.add(new Vaccine("Covid-V001", "AstraZeneca"));
            list.add(new Vaccine("Covid-V002", "SPUTNIK V"));
            list.add(new Vaccine("Covid-V003", "Vero Cell")); 
            list.add(new Vaccine("Covid-V004", "Pfizer"));
            list.add(new Vaccine("Covid-V005", "Moderne"));
            for (Vaccine vaccine : list) {
                oSteam.writeObject(vaccine);
            }
            
            oSteam.close();
            file.close();
        } catch (IOException e) {
        }
        
    }

   
}
