/**
 * @HoangHiep
 * @ver_1.0 (04/01/2024 - mm/dd/yyyy)
 */

import edu.duke.*;
import java.io.*;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String certainDNA = dna.toLowerCase();
        int start = certainDNA.indexOf(startCodon);
        if (start == -1) {
            return "";
        }
        int stop = certainDNA.indexOf(stopCodon, start+3);
        if (stop == -1) {
            return "";
        }
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    
    public void testSimpleGene() {  //taken from https://github.com/misterpandaa/Java-Programming-Solving-Problems-with-Software/blob/master/Week2/StringsFirstAssignments/Part2.java
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        // DNA with no ATG
        String dna = "ATCTAACATC";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon,stopCodon));
        
        // DNA with no TAA
        dna = "ATTATCATGTTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with no “ATG” and “TAA”
        dna = "ATTAGTGTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with ATG, TAA and the substring between them is not a multiple of 3
        dna = "GAAATGGATAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "TAAGATATGGTGAAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        dna = "ATGGGTTAAGTC";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        dna = "gatgctataat";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
    }
    
    public void quiz() {
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        String start = "ATG";
        String stop = "TAA";
        
        System.out.println("DNA is: " + findSimpleGene(dna, start, stop));
    }
    
    public static void main(String args[]) {
        Part2 pt = new Part2();
        //pt.testSimpleGene();
        pt.quiz();
    }
}
