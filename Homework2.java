/*Since only one public class can be written per file in Java, it becomes difficult to manage 
 *writing homework.  You may have to write one class for one problem.
 *
 * Instead, you could write the solution for one problem in one method.  Method is a 
 * construct which allows you to write bulk of code(instructions) as a group.  So, 
 * you could simply write one public class per homework and create multiple methods, one
 * method for one exercise.
 * 
 * You can use the following template.
 * 
 * Later, when you learn Object Oriented Programming, then you can write multiple classes
 * and zip them together when you submit your work.
 *
 */

import java.util.Scanner; //you need this for your reading the input from keyboard
                          //do not worry about "!" icon with warning for now...Stay curious though!

public class Homework2 {
    
    public static void excercise_2_1() {
        //print one 1 line using printf with format specifier
        int radius = 2;
        double area;
        final double pi = 3.142;
        area = pi * radius * radius;
        System.out.printf("The area is: %2f",area);

    }

    public static void excercise_2_2() {
        //program to get the value of pi from user input and then calculate area
        Scanner readInput = new Scanner(System.in);
        int radius;
        double area;
        double pi;
        System.out.println();
        System.out.print("Enter the radius and value of pi: ");
        radius = readInput.nextInt();
        pi = readInput.nextDouble();
        area = pi * radius * radius;
        System.out.print("The area is: ");
        System.out.println(area);
        }

    
    public static void excercise_2_3() {
            Scanner readInput = new Scanner(System.in);
            System.out.println();
            System.out.print("What is your first name?: ");
            char yourInitial = readInput.next().charAt(0);
            System.out.println("Hello Mr. " + yourInitial + ".");
            readInput.nextLine();

            // extra line feed
            System.out.println();
            System.out.printf("5185 is fun course.\n\n");
            System.out.printf("First Name \tLast Name\tCity\n");
            System.out.printf("----------- \t---------\t---\n");
            System.out.printf("Bill \tClinton \tHarlem\n");
            System.out.printf("\n");

            // extra line feed
            System.out.println();
            System.out.printf("How do you print double quotes?\n");
            System.out.printf("Who said\"Test Scores Can Be Used ....\"\n");

            
            String firstname;
            String lastname;
            String city;
            long zip;

            //using scanner to read inputs
            System.out.println("Please enter your first name:");
            firstname = readInput.next();
            
            System.out.println("Please enter your last name:");
            lastname = readInput.next();
            
            System.out.println("Please enter your city:");
            city = readInput.next();
            
            System.out.println("Please enter your Zip code:");
            zip = readInput.nextLong();
            
            System.out.printf("First Name \tLast Name \tCity \tZip Code\n");
            System.out.printf("----------- \t---------\t-----\t----------\n");
            System.out.printf("%s \t %s \t %s \t %d\n",firstname,lastname,city,zip);
    }

    public static void main(String[] args) {
        excercise_2_1();
        excercise_2_2();
        excercise_2_3();    
    }
}
