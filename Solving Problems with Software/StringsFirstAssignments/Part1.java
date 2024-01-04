/**
 * @HoangHiep
 * @ver_1.0 (04/01/2024 - mm/dd/yyyy)
 */

import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("atg");
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("taa", start+3);
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
    
    public void testSimpleGene() {
        // a = "cccatggggtttaaataataataggagagagagagagagttt";
        String ap = "atgaggtaaataataatag";
        //String a = "atgcctag";
        //String ap = "";
        //String a = "ATGCCCTAG";
        //String ap = "ATGCCCTAG";
        String result = findSimpleGene(ap);
        System.out.println(result);
    }
    
    public static void main(String args[]) {
        Part1 pt = new Part1();
        pt.testSimpleGene();
    }
}
