import java.util.Scanner;

/*
 * This is solution for Homework #8.
 * OOPBox Class has states(variables) and methods in it.
 * Box Class has the main method
 * 
 * @author shreyagurumurthy
 * @version 1.0
 * @since 05-07-21NN
 */
class OOPBox {

    private int hSize;
    private int vSize;
    private char hChar;
    private char vChar;

    /*
     * No parameters passed 
     * Setter method for hSize
     */
    public void sethSize(int size) {
        hSize = size;
    }

    /*
     * No parameters passed 
     * Setter method for vSize
     */
    public void setvSize(int size) {
        vSize = size;
    }

    /*
     * No parameters passed 
     * Setter method for hChar
     */
    public void sethChar(char hChar) {
        this.hChar = hChar;
    }

    /*
     * No parameters passed 
     * Setter method for vChar
     */
    public void setvChar(char vChar) {
        this.vChar = vChar;
    }

    /*
     * No parameters passed 
     * Draws box using horizontal and vertical line
     */
    public void drawBox() {
        drawHorizontalLine();
        drawVerticalLine();
        drawHorizontalLine();
    }

    /*
     * No parameters passed 
     * Draws horizontal line using hChar and hSize
     */
    public void drawHorizontalLine() {

        for (int i = 0; i < hSize; i++) {
            System.out.printf("" + hChar);
        }
        System.out.println();
    }

    /*
     * No parameters passed 
     * Draws vertical line using vChar and vSize
     */
    public void drawVerticalLine() {

        for (int i = 1; i <= vSize - 2; i++) {
            System.out.printf("" + vChar);
            for (int j = 1; j <= hSize - 2; j++) {
                System.out.printf(" ");
            }
            System.out.printf("" + vChar + "\n");
        }
    }
}

/*
 * This class contains the main method of this program
 */
public class Box {
    
    /*
     * @param args 
     *          : not used in this program 
     * The main method creates scanner and instantiates obj of OOPBox class 
     * myBox obj calls its methods in a while loop
     */
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        char answer = 'y';
        OOPBox myBox= new OOPBox();

        while (answer == 'y') {
            System.out.printf("Please enter the horizontal size of box: ");
            myBox.sethSize(readInput.nextInt());
            System.out.printf("Please enter the vertical size of box:");
            myBox.setvSize(readInput.nextInt());
            readInput.nextLine(); //clean the buffer

            System.out.printf("Please enter the horizontal charcters to draw box: ");
            myBox.sethChar(readInput.nextLine().charAt(0));
            System.out.printf("Please enter the vertical charcters to draw box: ");
            myBox.setvChar(readInput.nextLine().charAt(0));
            // readInput.nextLine(); // clean the buffer
            myBox.drawBox();
            
            System.out.printf("Continue? Type 'y' for yes:");
            answer = readInput.nextLine().charAt(0);
        }
        System.out.printf("Thank you for using my program");
        readInput.close();

    }
}
