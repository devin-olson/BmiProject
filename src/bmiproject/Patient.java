/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmiproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author Devin
 */
public class Patient {
    private String patient_name;
    private String birthDate;
    private String bmiCategory;
    private String insuranceCategory;
    private double patient_weight,patient_height, BMI;
    
    
    void userInput(){
        Scanner sc=new Scanner(System.in);
    
        while(true)
            {
                 
                System.out.println("Enter the name of the patient (or press q to stop): ");
                patient_name=sc.next();
                
                if(patient_name.equalsIgnoreCase("q"))
                    break;
                
                System.out.print("Enter the birth date of the patient (dd/mm/yyyy): ");
                birthDate=sc.next();
                
                
                System.out.print("Enter the weight of the patient (in pound): ");
                patient_weight=sc.nextDouble();
                
                System.out.print("Enter the height of the patient (in inches): ");
                patient_height=sc.nextDouble();
                break;
            }
        
    }
   public void calcBmi(){
       BMI= (patient_weight * 730) /(patient_height * patient_height);
       
   }
    
   
    
    public void determineCategory(){
         if(BMI>18.5)
                {
                    bmiCategory="underweight";
                    insuranceCategory="low";
                }
                else if (BMI>=18.5 && BMI<=24.9 )
                {
                    bmiCategory="Normal";
                    insuranceCategory="low";
                }
                else if (BMI>=25 || BMI<=29.9 )
                {
                    bmiCategory="Overweight";
                    insuranceCategory="high";
                }
                else
                {
                    bmiCategory="Obesity";
                    insuranceCategory="highest";
                }
                
               
              
        
    }
    void print(){
        //output
                for(int i = 0;i<=5;i++){
                    System.out.println("Name: "+patient_name);
                    System.out.println("Birth Day: "+birthDate);
                    System.out.println("BMI Cateogry: "+bmiCategory);
                    System.out.println("Insurance Category: "+insuranceCategory);
                    break;
                }
    }
    
    public void writeToFile()throws FileNotFoundException, IOException{
        
        File fout = new File("patients.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos)); 
        
        //write to file logic
        String strDouble = String.format("%.2f", BMI);
        System.out.println("BMI index calculated and write to file succesfull.");
        bw.write("Patient Name: "+patient_name+"\r\n"+"Birth Date: "+birthDate+"\r\nBMI Index: "strDouble+"\r\nBMI Category: "+bmiCategory+"\r\nInsurance payment category is:" +insuranceCategory);
        bw.newLine();
        bw.newLine();
        System.out.println("");
    }
}
