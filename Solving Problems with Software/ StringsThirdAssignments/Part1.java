
/**
 * Storing All Genes
 * 
 * @HoangHiep
 * @ver_1.0 (04/01/2024 - mm/dd/yyyy)
 */

import edu.duke.*;
import java.io.*;

public class Part1 {
    private int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 3);
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon() {
        System.out.println("Testing findStopCodon...");
        String dna = "AATGCTAACTAGCTGACTAAT";
        System.out.println("Testing string of DNA: " + dna);
        
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            System.out.println("Start codon not found!!");
        } else {
            System.out.println("Start codon ATG: " + startIndex);
        }

        int stopIndex = findStopCodon(dna, startIndex, "TAA");
        if (stopIndex == dna.length()) {
            System.out.println("Stop codon not found!!");
        } else {
            System.out.println("Stop codon TAA: " + stopIndex);
        }

        stopIndex = findStopCodon(dna, startIndex, "TAG");
        if (stopIndex == dna.length()) {
            System.out.println("Stop codon not found!!");
        } else {
            System.out.println("Stop codon TAG: " + stopIndex);
        }

        stopIndex = findStopCodon(dna, startIndex, "TGA");
        if (stopIndex == dna.length()) {
            System.out.println("Stop codon not found!!");
        } else {
            System.out.println("Stop codon TGA: " + stopIndex);
        }
    }
    
    
    private String findGene(String dna) {
        int start = dna.indexOf("ATG");
        if(start == -1)
            return "";
            
        int taaIndex = findStopCodon(dna, start, "TAA");
        int tagIndex = findStopCodon(dna, start, "TAG");
        int tgaIndex = findStopCodon(dna, start, "TGA");
        
        int minIndex = Math.min(Math.min(taaIndex, tgaIndex), tagIndex);
        if (minIndex == dna.length()) {
            return "";
        }
        return dna.substring(start, minIndex + 3);
    }
    
    
    public void testFindGene() {
        System.out.println("\nTesting findGene...");
        String dna = "AAATATCAAATAGTAAATAA";
        System.out.println("Testing string of DNA: " + dna + "\nValid gene is " + findGene(dna));
        System.out.println("–––");

        dna = "AAATATGAAATAGTGGTTTTGGAAAGT";
        System.out.println("Testing string of DNA: " + dna + "\nValid gene is " + findGene(dna));
        System.out.println("–––");

        dna = "AAATATGAAATGATAATTTTGATAGAAATAG";
        System.out.println("Testing string of DNA: " + dna + "\nValid gene is " + findGene(dna));
        System.out.println("–––");

        dna = "AAATATGTTTGTATGTGTAAAATTG";
        System.out.println("Testing string of DNA: " + dna + "\nValid gene is " + findGene(dna));
        System.out.println("–––");

        dna = "xxxATGxxxTAAxxxATGxxxTAGxxxTGA";
        System.out.println("Testing string of DNA: " + dna + "\nValid gene is " + findGene(dna));   
    }
    
    
    public void printAllGenes(String dna) {
        while (true) {
            String currGene = findGene(dna);
            if (currGene.isEmpty()) {
                break;
            }
            System.out.println(currGene);
            dna = dna.substring(dna.indexOf(currGene) + currGene.length());
        }
    }

    
    public void testPrintAllGenes() {
        System.out.println("\nTesting printAllGenes...");
        String dna = "xxxATGxxxTAAxxxATGxxxTAGxxxTGA";
        System.out.println("Testing string of DNA: " + dna + " \nFound genes:");
        printAllGenes(dna);
        System.out.println("–––");

        dna = "AAATATGAAATGATAATTTTGATAGAAATAG";
        System.out.println("Testing string of DNA: " + dna + " \nFound genes:");
        printAllGenes(dna);
    }
    
    
    public StorageResource getAllGenes(String dna) {
        StorageResource sr = new StorageResource();
        while (true) {
            String currGene = findGene(dna);
            if (currGene.isEmpty()) {
                break;
            }
            sr.add(currGene);
            dna = dna.substring(dna.indexOf(currGene) + currGene.length());
        }
        
        return sr;
    }
    
    
    public void testGetAllGenes() {
        System.out.println("\nTesting testStorageResource...");
        String dna = "xxxATGxxxTAAxxxATGxxxTAGxxxTGA";
        System.out.println("Testing string of DNA: " + dna + " \nFound genes:");
        
        StorageResource sr = getAllGenes(dna);
        for(String g : sr.data()) {
            System.out.println(g);
        }
        
        System.out.println("----------------------");
        
        dna = "AAATATGAAATGATAATTTTGATAGAAATAG";
        sr = getAllGenes(dna);
        for(String g : sr.data()) {
            System.out.println(g);
        }
    }
    
    public static void main(String[] args) {
        Part1 test = new Part1();
        test.testGetAllGenes();
    }
}
