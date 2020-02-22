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
// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;
public class Warning
{
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args)
    {
        int creditHrs; // number of semester hours earned
        double qualityPts; // number of quality points earned
        double gpa; // grade point (quality point) average
        String line, name, inputName = "students.dat";
        String outputName = "warning.dat";
        try
        {
            // Set up scanner to input file
            File inFile = new File("D:\\Data\\POLBAN\\SMT IV\\"
                    + "Analisis Perancangan Perangkat Lunak\\Weeks 2\\"
                    + "APPL1_ReadWriteTextFiles\\" + inputName);
            Scanner sc = new Scanner(inFile);
            
            // Set up the output file stream
            PrintWriter outFile = new PrintWriter(outputName);
            // Print a header to the output file
            outFile.println("==============================");
            outFile.println ("Students on Academic Warning");
            outFile.println("Format: Name CreditHours GPA");
            outFile.println("==============================");
            outFile.println();
            // Process the input file, one token at a time
            while (sc.hasNextLine())
            {
                name = sc.next();
                creditHrs = sc.nextInt();
                qualityPts = sc.nextDouble();
                gpa = qualityPts/creditHrs;
                if(creditHrs < 30){
                    if(gpa < 1.5){
                        outFile.println(name + " " + creditHrs + " "+ gpa);
                    }
                }
                else if(creditHrs <60){
                    if (gpa < 1.75){
                        outFile.println(name + " " + creditHrs + " "+ gpa);
                    }
                }
                else{
                    if(gpa < 2.0){
                        outFile.println(name + " " + creditHrs + " "+ gpa);
                    }
                }
            }
            // Close output file
            outFile.close();
            
        }
            catch (FileNotFoundException exception)
        {
            System.out.println ("The file " + inputName + " was not found.");
        }
            catch (IOException exception)
        {
            System.out.println (exception);
        }
            catch (NumberFormatException e)
        {
            System.out.println ("Format error in input file: " + e);
        }
    }
}
