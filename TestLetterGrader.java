import java.io.*;

/*
 * This is solution for Final Programming Assignment.
 * TestLetterGrader Class has the main method that instantiates LetterGrader object
 * This is the driver program for this application
 * 
 * @author shreyagurumurthy
 * @version 1.0
 * @since 05-29-21NN
 */
public class TestLetterGrader extends LetterGrader {

    public TestLetterGrader(String[] args) {
        super(args);
    }
    
    /*
     * @param args 
     *          : Used to take the input and output file name 
     * The main method calls the LetterGrader methods.
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            File inputFile = new File(args[0]);
            if (!inputFile.exists()) {
                System.out.println("Input file " + args[0] + " does not exist");
                System.exit(0);
            }
        } else {
            System.out.printf("Usage: java TestLetterGrader.java inputFile outputFile\n");
            System.exit(0);
        }
        LetterGrader letterGrader = new LetterGrader(args);
        letterGrader.readScore();
        letterGrader.calcLetterGrade();
        letterGrader.printGrade();
        letterGrader.displayAverages();
        // letterGrader.doCleanUp();
    }
}