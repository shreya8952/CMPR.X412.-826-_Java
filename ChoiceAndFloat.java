import java.util.Scanner;
import java.util.InputMismatchException;
// import the package for handling exceptions and scanning user input

public class ChoiceAndFloat {

    // method to check if the numbers are float
    public static float[] getTwoFloats(Scanner readInput, float[] floats) {
        
        // loop to check if numbers are float values
        for (int i = 0; i < 1; i++) {
            System.out.printf("Enter 2 numbers separated by a space:");
            try {
                // read user input and store it as 0th and 1st element in array
                floats[0] = readInput.nextFloat();
                floats[1] = readInput.nextFloat();
            }
            // enters this block only if user did not enter float
            catch (InputMismatchException e) {
                // InputMismatchException occurs when user enters a string or anything other
                // than float
                System.out.printf("You have entered wrong input. Try again\n");

                // to clear the buffer
                readInput.nextLine();

                // decrementing loop variable to stay in the loop so user can try again
                i--;
            }
        }

        // return float array with 2 valid float values
        return floats;
    }
    
    // method to get user choice
    public static int getUserChoice(Scanner readInput) {

        // intitialize user input- will be later returned
        int input = 0;

        System.out.println("Welcome to the sorting program!");
        System.out.println("1. Title \n2. Rank\n3. Date\n4. Stars\n5. Likes ");

        // loop to check if number is between 1-5
        for (int i = 0; i < 1; i++) {
            System.out.printf("Enter a choice between 1 and 5 only:");
            try {
                // read user input and store it in choice
                input = readInput.nextInt();

                // to check if choice is not in range 1-5
                // this is not exception because number is still integer but not in range of 1-5
                if ((input < 1) || (input > 5)) {
                    System.out.printf("You have not entered a number between 1 and 5. Please re-enter.\n");

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
                System.out.printf("You have entered invalid input. Try again\n");

                // to clear the buffer
                readInput.nextLine();

                // decrementing loop variable to stay in the loop so user can try again
                i--;
            }
        }
        // return the valid user choice
        return input;
    }

    public static void main(String[] args) {

        // to get user input
        Scanner readInput = new Scanner(System.in);
        
        // initialize a float array with 2 elements as 0
        float[] userFloats = { 0, 0 };
        
        //initialize an integer choice 
        int choice = 0;
        
        //calling getUserChoice method and storing the return value in choice
        choice = getUserChoice(readInput);
        //printing the user choice through main
        System.out.printf("You have entered valid choice %d\n", choice);
        System.out.printf("Thank you for valid choice\n\n");

        //calling getTwoFloats method and storing the returned float array
        userFloats = getTwoFloats(readInput, userFloats);
        //printing the values of floats through main using indexing 0th and 1st element
        System.out.printf("\nYou have entered 2 valid floats: %5.2f, %5.2f\n", userFloats[0], userFloats[1]);
        System.out.printf("Thank you for giving 2 valid floats");
    }
}
