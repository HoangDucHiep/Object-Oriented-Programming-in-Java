
/**
 * @HoangHiep
 * @ver_1.0 (04/01/2024 - mm/dd/yyyy)
 */

import edu.duke.*;
import java.io.*;

public class Part4 {
    public void findLinks(String url) {
        URLResource ur = new URLResource(url);
        
        for (String line : ur.lines()) {
            int youtubeIndex = line.toLowerCase().indexOf("youtube.com");
            
            if (youtubeIndex != -1) {
                    int startIndex = line.lastIndexOf("\"", youtubeIndex);
                    int lastIndex = line.indexOf("\"", youtubeIndex + 1);
                    System.out.println("Youtube link: " + line.substring(startIndex + 1, lastIndex));
            }
        }
    }
    
    public void test() {
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        findLinks(url);
    }
    
    
    public static void main(String args[]) {
        Part4 Test = new Part4();
        
        Test.test();
    }   
}
