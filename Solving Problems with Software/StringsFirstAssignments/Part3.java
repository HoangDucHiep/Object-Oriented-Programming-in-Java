/**
 * @HoangHiep
 * @ver_1.0 (04/01/2024 - mm/dd/yyyy)
 */
import edu.duke.*;
import java.io.*;


public class Part3 {
    private boolean twoOccurrences(String stringa, String stringb) {
        int firstOccur = stringb.indexOf(stringa);
        int lastOccur = stringb.lastIndexOf(stringa);
        
        return firstOccur!= -1 && lastOccur!= -1 && (firstOccur != lastOccur); //so there are 2 (or more than one) occurences
    } 
    
    
    private String lastPart(String stringa, String stringb) {
        int firstOccur = stringb.indexOf(stringa);
        if(firstOccur == -1) return stringb;
        else
            return stringb.substring(firstOccur + stringa.length());
    }
    
    public void testing() {         //taken form https://github.com/misterpandaa/Java-Programming-Solving-Problems-with-Software/blob/master/Week2/StringsFirstAssignments/Part2.java
        String stringa;
        String stringb;
        
        System.out.println("Testing twoOccurences");
        System.out.println("=====================");
        
        stringa = "by";
        stringb = "A story by Abby Long";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurrences(stringa, stringb));
        
        stringa = "a";
        stringb = "banana";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurrences(stringa, stringb));
        
        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurrences(stringa, stringb));
        
        System.out.println("\n\nTesting lastPart:");
        System.out.println("=================");
        
        stringa = "an";
        stringb = "banana";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));
        
        stringa = "zoo";
        stringb = "forest";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));
    } 
    
    
    public static void main(String args[]) {
        Part3 pt = new Part3();
        pt.testing();
    }
}
