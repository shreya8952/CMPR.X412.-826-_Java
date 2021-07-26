import java.util.Scanner;
import java.util.InputMismatchException;
// import the package for handling exceptions and scanning user input

public class SortProgram {

    //method to check if user has entered an integer in range 1-5
    public static void checkInteger() {

        //to get user input
        Scanner readInput = new Scanner(System.in);

        // intitialize user choice
        int choice = 0;

        System.out.println("Welcome to the sorting program!");
        System.out.println("1. Title \n2. Rank\n3. Date\n4. Stars\n5. Likes ");

        //loop to check if number is between 1-5
        for (int i = 0; i < 1; i++) {
            System.out.printf("Enter a choice between 1 and 5 only:");
            try {
                //read user input and store it in choice
                choice = readInput.nextInt();

                //to check if choice is not in range 1-5
                // this is not exception because number is still integer but not in range of 1-5
                if ((choice < 1) || (choice > 5)) {
                    System.out.printf("You have not entered a number between 1 and 5. Please re-enter.\n");

                    //to clear the buffer
                    readInput.nextLine();

                    // decrementing loop variable to stay in the loop so user can try again
                    i--;
                }
            }
            // enters this block only if user did not enter integer
            catch (InputMismatchException e) {
                // InputMismatchException occurs when user enters a string or anything other than integer
                System.out.printf("You have entered invalid input. Try again\n");

                // to clear the buffer
                readInput.nextLine();

                //decrementing loop variable to stay in the loop so user can try again
                i--;
            }
        }
        System.out.printf("You have entered valid choice %d\n", choice);
        System.out.printf("Thank you for valid choice");
        //program ends here
    }

    public static void main(String[] args) {

        //call method to check if int
        checkInteger();
    }
}