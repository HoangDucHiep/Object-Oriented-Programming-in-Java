
/**
 * Finding Many Genes
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

    public void testCountGenes() {
        System.out.println("Test countGenes method.");
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println("Testing string of DNA: " + dna + "\nThe number of genes found in DNA: " + countGenes(dna));
        System.out.println("–––");

        dna = "AAATATGAAATGATAATTTTGATAGAAATAG";
        System.out.println("Testing string of DNA: " + dna + "\nThe number of genes found in DNA: " + countGenes(dna));
        System.out.println("–––");

        dna = "AAATATGTTTGTATGTGTAAAATTG";
        System.out.println("Testing string of DNA: " + dna + "\nThe number of genes found in DNA: " + countGenes(dna));
    }

    public static void main(String[] args) {
        Part3 test = new Part3();
        test.testCountGenes();
    }
}
