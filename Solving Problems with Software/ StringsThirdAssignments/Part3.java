
/**
 * Storing All Genes
 * 
 * @HoangHiep
 * @ver_1.0 (04/01/2024 - mm/dd/yyyy)
 */

import edu.duke.*;
import java.io.*;


public class Part3 {
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

    private String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int minIndex = Math.min(Math.min(taaIndex, tgaIndex), tagIndex);
        if (minIndex == dna.length()) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
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
    
    private int countCodon(String dna, String codon) {
        int index = dna.indexOf(codon);
        int count = 0;
        
        while(index != -1) {
            count++;
            index = dna.indexOf(codon, index + codon.length());
        }
        return count;
    }
    
    private float cgRatio(String dna)  {
         int cCount = countCodon(dna, "C");
         int gCount = countCodon(dna, "G");
         
         float cgRatio = (float) (cCount + gCount) / dna.length();
         return cgRatio;
    }
    
    private int countCTG(String dna) {
        String codon = "CTG";
        int index = 0, count = 0;
        
        while(index != -1) {
            index = dna.indexOf(codon, index);
            if(index != -1) {
                count++;
                index += codon.length();
            }
        }
        return count;
    }
    

    private int countGenes(String dna) {
        int count = 0;
        while (true) {
            String currGene = findGene(dna);
            if (currGene.isEmpty()) {
                break;
            }
            count += 1;
            dna = dna.substring(dna.indexOf(currGene) + currGene.length());
        }
        return count;
    }
    
    private void processGenes(StorageResource sr) {
        int count = 0;
        for(String g : sr.data()) {
            if(g.length() > 60) {
                count++;
            }
        }
        
        System.out.println("\nNumber of strings longer than 60 characters: " + count);
        
        count = 0;  //cgRatio
        for (String g : sr.data()) {
            float cgRatio = cgRatio(g);
            if (cgRatio > 0.35) {
                count += 1;
            }
        }
        System.out.println("\nNumber of strings whose C-G-ratio is higher than 0.35: " + count);

        String longestGene = "";
        for (String g : sr.data()) {
            if (g.length() > longestGene.length()) {
                longestGene = g;
            }
        }
        System.out.println("\nThe longest gene is: " + "\n" + longestGene + "\nit's length is: " + longestGene.length());
        System.out.println("––––––––––––––––––––––––––––––");
    }
    
    
    public void testProcessGenes() {
        System.out.println("Test processGenes method (with DNA string in external file).");
        FileResource fr = new FileResource("brca1line.fa");
        //FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        StorageResource sr = getAllGenes(dna);
        processGenes(sr);
        System.out.println("The number of genes found in file: " + countGenes(dna));
        System.out.println("\nThe codon of CTG appear " + countCTG(dna) + " times in DNA");
    }

    public void testProcessGenes2() {
        System.out.println("Test processGenes method (with DNA strings to use as test cases).");
        StorageResource sr = new StorageResource();

        String dna = "AAATATGAAAGTATGTTAGTGGTTTTGGAAAATGGTAXXXGATTTGAAGTAG";
        System.out.println("Testing string of DNA: " + dna);
        processGenes(getAllGenes(dna));

        dna = "AAATATCAAATAGTAAATAA";
        System.out.println("Testing string of DNA: " + dna);
        processGenes(getAllGenes(dna));

        dna = "TAAAAAATGAGTTAGATGCCCGCGAAACATGATTAAAAAATGAAACATGATTAA";
        System.out.println("Testing string of DNA: " + dna);
        processGenes(getAllGenes(dna));

        dna = "AAATATGTTTGTATGTGTAAAATTG";
        System.out.println("Testing string of DNA: " + dna);
        processGenes(getAllGenes(dna));

        dna = "xxxATGxxxTAAxxxATGxxxTAGxxxTGA";
        System.out.println("Testing string of DNA: " + dna);
        processGenes(getAllGenes(dna));
    }

    public static void main(String[] args) {
        Part3 test = new Part3();
        test.testProcessGenes();
        //test.testProcessGenes2();
    }
}
