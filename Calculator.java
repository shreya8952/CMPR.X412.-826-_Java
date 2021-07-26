import java.util.Scanner;
import java.util.InputMismatchException;

/*
 * This is solution for Mid-term Project.
 * All static methods have been put under the class Calculator
 * 
 * @author shreyagurumurthy
 * @version 1.0
 * @since 04-16-21NN
 */

public class Calculator {
    /*
     * @param readInput
     *              : Scanner passed from main method 
     * A loop is used to continue asking for valid choice. 
     * nextInt method of scanner is used which throwsInputMistatchExceptionif the value is not able to extracted. 
     * After user enters correct choice, it is passed as an argument along with scanner to the performOperation method 
     * performOperation method will return the answer to the getFinalAnswer method
     * getFinalAnswer returns the final answer to the main method
     */

    public static float getFinalAnswer(Scanner readInput) {
        //initialize variables to get user choice and final answer
        int choice = 0;
        float answer = 0;
        System.out.println("Welcome to Shreya's Handy Calculator");
        System.out.println("1. Addition \n2. Subtraction \n3. Multiplication \n4. Division \n5. Exit ");
        System.out.printf("What would you like to do:");

        // loop to check if number is between 1-5
        for (int i = 0; i < 1; i++) {
            try {
                // read user input and store it in choice
                choice = readInput.nextInt();

                // to check if choice is not in range 1-5
                // this is not exception because number is still integer but not in range of 1-5
                if ((choice < 1) || (choice > 5)) {
                    System.out.printf("You have not entered a number between 1 and 5. Please re-enter:");

                    // to clear the buffer
                    readInput.nextLine();

                    // decrementing loop variable to stay in the loop so user can try again
                    i--;
                }
            }
            // enters this block only if user did not enter integer
            catch (InputMismatchException e) {
                // InputMismatchException occurs when user enters a string or anything other
                // than integer
                System.out.printf("You have entered invalid input,please re-enter your choice:");

                // to clear the buffer
                readInput.nextLine();

                // decrementing loop variable to stay in the loop so user can try again
                i--;
            }
        }
        answer = (performOperation(readInput, choice));
        return answer;
    }//end of getFinalAnswer
    
    /*
     * @param readInput 
     *              : Scanner passed from getFinalAnswer method
     * @param choice 
     *              : integer passed from getFinalAnswer method
     * Switch case is used to decide what operation must be performed- add,sub,mul,div
     * In every case the array of floats must be check if they are valid floats
     * getValidatedFloat method is called to check if correct floats are passed
     * the valid float array is returned by getValidatedFloat and then the operation is performed
     * answer is returned by the operation methods- getAddFloat, getSubtractFloat etc
     * performOperation returns this answer to getFinalAnswer
     */
    public static float performOperation(Scanner readInput, int choice) {
        //initialize a float array and answer variable to catch the return values
        float[] floats = { 0, 0 };
        float answer = 0;
        switch (choice) {
        case 1:
            System.out.printf("\nPlease enter 2 floats you want to add, separated by a space:");
            floats = getValidatedFloat(readInput, floats, choice);
            answer = getAddFloat(floats);
            break;
        case 2:
            System.out.printf("\nPlease enter 2 floats you want to subtract, separated by a space:");
            floats = getValidatedFloat(readInput, floats, choice);
            answer = getSubtractFloat(floats);
            break;
        case 3:
            System.out.printf("\nPlease enter 2 floats you want to multiply, separated by a space:");
            floats = getValidatedFloat(readInput, floats, choice);
            answer = getMultiplyFloat(floats);
            break;
        case 4:
            System.out.printf("\nPlease enter 2 floats you want to divide, separated by a space:");
            floats = getValidatedFloat(readInput, floats, choice);
            answer = getDivideFloat(floats);
            break;
        case 5:
            System.out.printf("Thank you for using my calculator!");
            System.exit(0);
            break;
        }
        return answer;
    }//end of performOperation
    
    /*
     * @param readInput 
     *               : Scanner passed from performOperation method
     * @param floats 
     *               :float[] passed from performOperation method
     * @param choice 
     *              : integer passed from performOperation method
     * 
     * A loop is used to continue asking for float values
     * nextFloat method of scanner is used which throwsInputMistatchException if the value is not able to extracted.
     * If the user wishes to perform division and the 2nd Float is 0 it prompts the user to re-enter the 2 floats again
     * The float array with 2 valid floats are returned to the performOperation method
     */
    
    public static float[] getValidatedFloat(Scanner readInput, float[] floats, int choice) {

        // loop to check if numbers are float values
        for (int i = 0; i < 1; i++) {
            try {
                // read user input and store it as 0th and 1st element in array
                floats[0] = readInput.nextFloat();
                floats[1] = readInput.nextFloat();

                //if block to check if user wishes to do division and the 2nd float is zero
                if (choice == 4 && floats[1] == 0) {
                    System.out.printf("\nYou cannot divide by zero. Please re-enter both floats:");
                    readInput.nextLine();
                    i--;
                }
            }
            // enters this block only if user did not enter float
            catch (InputMismatchException e) {
                // InputMismatchException occurs when user enters a string or anything other
                // than float
                System.out.printf("You have entered wrong input. Please re-enter:");

                // to clear the buffer
                readInput.nextLine();

                // decrementing loop variable to stay in the loop so user can try again
                i--;
            }
        }
        // return float array with 2 valid float values
        return floats;
    }// end of getValidatedFloat

    /*
     * @param floats
     *           : float [] passed from perform operation method 
     * It adds the 2 numbers and returns the answer to performOperation method
     */
    public static float getAddFloat(float[] floats) {
        float sum = floats[0] + floats[1];
        return sum;
    }// end of getAddFloat
    
    /*
     * @param floats 
     *              : float [] passed from perform operation method 
     * It subtracts the 2 numbers and returns the answer to performOperation method
     */
    public static float getSubtractFloat(float[] floats) {
        float difference = floats[0] - floats[1];
        return difference;
    }// end of getSubtractFloat

    /*
     * @param floats 
     *              : float [] passed from perform operation method 
     * It multiplies the 2 numbers and returns the answer to performOperation method
     */
    public static float getMultiplyFloat(float[] floats) {
        float product = floats[0] * floats[1];
        return product;
    }// end of getMultiplyFloat

    /*
     * @param floats 
     *              : float [] passed from perform operation method 
     * It divides the 2 numbers and returns the answer to performOperation method
     */
    public static float getDivideFloat(float[] floats) {
        float division = floats[0] / floats[1];
        return division;
    }// end of getDivideFloat
    
    /*
     * No parameters passed
     * Returns true to the do while loop in main method
     * when user presses enter so he can continue to use the calculator
     */
    public static boolean pressEnterKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
        return true;
    }// end of pressEnterKeyToContinue

    /*
     * @param args 
     *              : not used in this program 
     *The main method creates scanner and calls the getFinalAnswer method in a do-while loop
     *
     */
    
    public static void main(String[] args) {
        // to get user input
        do{
        Scanner readInput = new Scanner(System.in);
        float answer = 0;
        answer=getFinalAnswer(readInput);
        System.out.printf("Your answer is %.2f .\n", answer);
        }while(pressEnterKeyToContinue());
    }//end of main method
}//end of Calculator
