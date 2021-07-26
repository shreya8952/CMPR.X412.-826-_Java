import java.util.*;
import java.io.*;

/*
 * This is solution for Mid-term Project.
 * All static methods have been put under the class Exercise5
 * 
 * @author shreyagurumurthy
 * @version 1.0
 * @since 05-10-21NN
 */

public class Exercise5 {

    /*
     * @param args 
     *          : String[] passed from command line
     * This array contains the name of the input and output file.
     * This method checks if 2 file names are given through command line
     */
    public static void processCLArguments(String[] args) {
        if (args.length < 2) {
            System.out.printf("Usage: java Exercise5 inputFile outputFile\n");
            
        } else {
            System.out.printf("Input will be read from: %s\n", args[0]);
            System.out.printf("Output will be read into: %s\n", args[1]);
            procesInputOutputFiles(args);
        }
    }
    
    /*
     * @param args 
     *          : String[] passed from processCLArguments
     * This array contains the name of the input and output file. 
     * It reads the from the input file and prints it, then writes the file content to output file
     */
    public static void procesInputOutputFiles(String[] args) {
        Scanner readInput;
        try {
            int studentNum = 1;
            readInput = new Scanner(new File(args[0]));
            while (readInput.hasNextLine()) {
                System.out.printf("Student # %d, ", studentNum);
                System.out.println(readInput.nextLine());
                studentNum++;
            }
            readInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("File: " + args[0] + "not found");
        } catch (Exception e) {
            System.out.println(e);
        }

        BufferedReader bufferedReader = null;
        StreamTokenizer myTokenizer;
        int nextToken;
        double numberToken;
        String strToken;

        try {
            bufferedReader = new BufferedReader(new FileReader(new File(args[0])));
        } catch (FileNotFoundException err) {
            System.out.println(err);
            System.exit(-1); // exit if file not found
        }
        myTokenizer = new StreamTokenizer(bufferedReader);
        myTokenizer.whitespaceChars(',', ',');
        myTokenizer.eolIsSignificant(true);

        String output = "";
        try {
            nextToken = myTokenizer.nextToken();
            int student = 1;
            while (nextToken != StreamTokenizer.TT_EOF) {
                output += "Student #: " + student;
                while (nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_WORD) {
                    strToken = myTokenizer.sval;
                    output += " " + strToken;
                    nextToken = myTokenizer.nextToken();
                }
                output += ", whose raw scores are:";
                while (nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_NUMBER) {
                    numberToken = myTokenizer.nval;
                    output += " " + numberToken + ": ";
                    nextToken = myTokenizer.nextToken();
                }
                output += "\n";
                nextToken = myTokenizer.nextToken();// eat up TT_EOL
                student++;
            }
        } catch (IOException err) {
            System.out.println(err);
        }

        //write to outputFile
        try (PrintWriter outputFile = new PrintWriter("output.txt")) {
            outputFile.println(output);
            outputFile.close();
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }
    }
    
    /*
     * @param args 
     *          : Used to take the input and output file name
     * The main method calls the processCLArguments method.
     */
    public static void main(String[] args) {
        processCLArguments(args);
    }
}
