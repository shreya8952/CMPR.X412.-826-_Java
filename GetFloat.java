import java.util.Scanner;
import java.util.InputMismatchException;
// import the package for handling exceptions and scanning user input

public class GetFloat {

    //method to check if the numbers are float
    public static void checkFloat() {

        // initialize 2 float values to 0
        float firstFloat = 0, secondFloat = 0;

        // to get user input   
        Scanner readInput = new Scanner(System.in);

        // loop to check if numbers are float values
        for (int i = 0; i < 1; i++) {
            System.out.printf("Enter 2 numbers separated by a space:");
            try {
                // read user input and store it in firstFloat, second Float
                firstFloat = readInput.nextFloat();
                secondFloat = readInput.nextFloat();
            }
            // enters this block only if user did not enter integer
            catch (InputMismatchException e) {
                // InputMismatchException occurs when user enters a string or anything other
                // than float
                System.out.printf("You have entered wrong input. Try again\n");
                
                //to clear the buffer
                readInput.nextLine();
                
                // decrementing loop variable to stay in the loop so user can try again
                i--;
            }
        }
        System.out.printf("\nYou have entered 2 valid floats: %5.2f, %5.2f\n", firstFloat, secondFloat);
        System.out.printf("Thank you for giving 2 valid floats");
        //program ends here
    }

    public static void main(String[] args) {
        //call method to check if float
        checkFloat();
    }
}