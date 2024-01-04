
/**
 * Storing All Genes
 * 
 * @HoangHiep
 * @ver_1.0 (04/01/2024 - mm/dd/yyyy)
 */

import edu.duke.*;
import java.io.*;

public class Part2 {

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
    
    
    public void testCgRatio() {
        System.out.println("Testing cgRatio...");
        String dna = "ATGCCATAG";
        System.out.print("The ratio of C's and G's in " + dna + ": ");
        System.out.printf("%.7f\n------------------", cgRatio(dna));
    }
    
    
    public static void main(String args[]) {
        Part2 test = new Part2();
        test.testCgRatio();
    }
}
