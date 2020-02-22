/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author User
 */
import java.util.Scanner;
import java.io.*;
public class CopyFile
{
    public static void main (String[] args)
    {
        String nameFile;
        File inFile;
        do{
            System.out.println("Please enter the name of the file(With extension): ");   
            Scanner scInput = new Scanner (System.in);
            nameFile = scInput.nextLine();
            inFile = new File("D:\\Data\\POLBAN\\SMT IV\\Analisis Perancangan Perangkat Lunak\\Weeks 2\\APPL1_CopyingFile\\" + nameFile);
            try
            {
                Scanner sc = new Scanner(inFile);
                System.out.println("=======================");
                System.out.println("The Content of the File");
                System.out.println("=======================");
                while (sc.hasNextLine()){
                    System.out.println(sc.nextLine());
                }
            }
            catch (FileNotFoundException exception)
            {
                System.out.println("The file " + nameFile + " was not found.");
            }
            catch (IOException exception)
            {
                System.out.println (exception);
            }
            System.out.println();
        } while (inFile.exists() == false);
    }
}
