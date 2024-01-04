import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPt = 0;
        for(Point curr : s.getPoints()){
            numPt++;
        }
        return numPt;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double totalLength = 0.0d;
        int numPt = getNumPoints(s);
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalLength += currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }      
        return totalLength/numPt;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double max = -1;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist > max)
                max = currDist;
            prevPt = currPt;
        }  
        return max;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double max = Double.MIN_VALUE;

        for (Point currPt : s.getPoints()) {
            double currX = currPt.getX();
            if(currX > max)
                max = currX;
        }  
        return max;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerim = Double.MIN_VALUE;
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            
            double currPerim = getPerimeter(s);
            
            largestPerim = largestPerim > currPerim ? largestPerim : currPerim;
        }
        
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double largestPerim = Double.MIN_VALUE;
        DirectoryResource dr = new DirectoryResource();
        File temp = null;    // replace this code
        
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            
            double currPerim = getPerimeter(s);
            
            if(currPerim > largestPerim) {
                largestPerim = currPerim;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPt = getNumPoints(s);
        double averageLength = getAverageLength(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points = " + numPt);
        System.out.println("Average length = " + averageLength);
        System.out.println("Largest Side = " + getLargestSide(s));
        System.out.println("Largest X = " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeterInMultiFiles = getLargestPerimeterMultipleFiles();
        System.out.println("The largest perimeter is = " + largestPerimeterInMultiFiles);
    }

    public void testFileWithLargestPerimeter() {
        String fileName = getFileWithLargestPerimeter();
        System.out.println("The largest perimeter file is = " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //System.out.println("One file:");
        //System.out.println("_______________________");
        //pr.testPerimeter();
        System.out.println("Multiple file:");
        System.out.println("_______________________");
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
        System.out.println();
    }
}
