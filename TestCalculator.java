import java.util.Scanner;
import java.util.InputMismatchException;

/*
 * This is solution for Homework #7.
 * OOPCalculator Class has states(variables) and methods in it.
 * TestCalculator Class has the main method
 * 
 * @author shreyagurumurthy
 * @version 1.0
 * @since 04-26-21NN
 */

class OOPCalculator {

    private char menuChoice;
    private float firstFloat = 0;
    private float secondFloat = 0;

    /*
     * No parameters passed
     * Prints all the possible options for the user
     */
    public void printMenu() {
        System.out.println("Welcome to Shreya's Handy Calculator");
        System.out.println("1. Addition \n2. Subtraction \n3. Multiplication \n4. Division \n5. Exit ");
        System.out.printf("What would you like to do:");
    }

    /*
     * No parameters passed Returns true to the while loop in main method when
     * user presses enter so he can continue to use the calculator
     */
    public boolean pressEnterKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
        return true;
    }

    /*
     * @param readInput 
     *              : Scanner passed from main method 
     * A loop is used to check if the numbers entered are float values.
     * The valid floats are then stored in the variables firstFloat and seconfFloat
     */

    public void askTwoValues(Scanner readInput) {
        String calcOperation = (menuChoice == 'a') ? "add"
                : (menuChoice == 's') ? "subtract" : (menuChoice == 'm') ? "multiply" : "divide";
        System.out.printf("Please enter the numbers you wish to %s separated by a space:", calcOperation);

        // loop to check if numbers are float values
        for (int i = 0; i < 1; i++) {
            try {
                firstFloat = readInput.nextFloat();
                secondFloat = readInput.nextFloat();

                // if block to check if user wishes to do division and the 2nd float is zero
                if (menuChoice == 'd' && secondFloat == 0) {
                    System.out.printf("You cannot divide by zero. Please re-enter both floats:");
                    i--;
                }
            }
            // enters this block only if user did not enter float
            catch (InputMismatchException e) {
                System.out.printf("You have entered wrong input. Please re-enter:");
                i--;
            }
            readInput.nextLine();
        }
    }

    /*
     * @param readInput 
     *                  : Scanner passed from main method 
     * A loop is used to continue asking for calc choice. 
     * next(".").charAt(0) method of scanner is used which throwsInputMistatchException
     * if anything other than char is entered. 
     * This valid calculator choice is then stored in variable menuChoice
     */

    public char askCalcChoice(Scanner readInput) {
        printMenu();
        for (int i = 0; i < 1; i++) {
            try {
                menuChoice = readInput.next(".").charAt(0);
                if (menuChoice == 'A' || menuChoice == 'a' || menuChoice == '1') {
                    menuChoice = 'a';
                } else if (menuChoice == 'S' || menuChoice == 's' || menuChoice == '2') {
                    menuChoice = 's';
                } else if (menuChoice == 'M' || menuChoice == 'm' || menuChoice == '3') {
                    menuChoice = 'm';
                } else if (menuChoice == 'D' || menuChoice == 'd' || menuChoice == '4') {
                    menuChoice = 'd';
                } else if (menuChoice == 'X' || menuChoice == 'x' || menuChoice == '5') {
                    menuChoice = 'x';
                } else {
                    System.out.printf("Please enter a number between 1-5 or their character equivalent:");
                    i--;
                }
            } catch (InputMismatchException e) {
                System.out.printf("Please enter a valid choice:");
                i--;
            }
            //clear the buffer
            readInput.nextLine();
        }
        return menuChoice;
    }

    /*
     * @param readInput 
     *          : Scanner passed from main method 
     * Switch case is used for appropriate operation- add,sub, mulyiply, divide
     * The result is then printed out.
     */
    public void displayResults(Scanner readInput) {
        switch (menuChoice) {
        case 'a':
            System.out.printf("Result of adding %.2f and %.2f is %.2f\n", firstFloat, secondFloat,
                    firstFloat + secondFloat);
            break;
        case 's':
            System.out.printf("Result of subtracting %.2f and %.2f is %.2f\n", firstFloat, secondFloat,
                    firstFloat - secondFloat);
            break;
        case 'm':
            System.out.printf("Result of multiplying %.2f and %.2f is %.2f\n", firstFloat, secondFloat,
                    firstFloat * secondFloat);
            break;
        case 'd':
            System.out.printf("Result of dividing %.2f and %.2f is %.2f\n", firstFloat, secondFloat,
                    firstFloat / secondFloat);
            break;
        }
    }

    /*
     * No parameters passed 
     * Prints the Bye message for the user
     */
    public void displayBye() {
        System.out.printf("Thank you for using Shreya's Handy Calculator\n");

    }
}

/*
 * This class contains the main method of this program
*/
public class TestCalculator {

    /*
     * @param args 
     *          : not used in this program 
     * The main method creates scanner and instantiates obj of OOPCalculator class
     * calc obj calls its methods in a while loop
     */
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        boolean enter = true;
        OOPCalculator calc = new OOPCalculator();
        while(calc.askCalcChoice(readInput)!='x'&&enter){
            calc.askTwoValues(readInput);
            calc.displayResults(readInput);
            enter = calc.pressEnterKeyToContinue();
        }
        readInput.close();
        calc.displayBye();
    } 
}