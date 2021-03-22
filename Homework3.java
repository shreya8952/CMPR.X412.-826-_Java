import java.util.Scanner;

public class Homework3 {

    public static void exercise_3_1() {
        //question 3.1- check if kid,adult or teenager
        int yourAge;
        Scanner readInput = new Scanner(System.in);
        System.out.printf("How old are you?: ");
        yourAge = readInput.nextInt();
        if (yourAge <=13){
            System.out.printf("You are a kid\n");
        }
        else if(yourAge>=19){
            System.out.printf("You are an adult\n");
        }
        else {
            System.out.printf("You are a teenager\n");
        }
    }

    public static void exercise_3_2() {
        //question 3.2
        float firstN; //making the numbers float
        float secondN;
        char operator;
        boolean choice = true;
        char answer;
        while (choice) {
            Scanner readInput = new Scanner(System.in);
            System.out.printf("Type a number, operator, number --" + "separated by a space: ");
            firstN = readInput.nextFloat();
            operator = readInput.next().charAt(0);
            secondN = readInput.nextFloat();
            if (operator == '+')
                System.out.printf("%5.2f + %5.2f = %5.2f", firstN, secondN, firstN + secondN);
            else if (operator == '-')
                System.out.printf("%5.2f - %5.2f = %5.2f", firstN, secondN, firstN - secondN);
            else if (operator == '*')
                System.out.printf("%5.2f * %5.2f = %5.2f", firstN, secondN, firstN * secondN);
            else if (operator == '/')
                System.out.printf("%5.2f / %5.2f = %5.2f", firstN, secondN, firstN / secondN);
            else if (operator == '%')
                System.out.printf("%5.2f %% %5.2f = %5.2f", firstN, secondN, firstN % secondN);
            else
                System.out.printf("Unknown operator");
            System.out.printf("\n\n");

            System.out.printf("Do you wish to continue:");
            answer = readInput.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                choice = true;
            } else {
                choice = false;
            }
        }
    }
    
    public static void exercise_3_3() {
        //question 3.3
        int max;    //max num
        int num1, num2, num3;   //the 3 numbers
        boolean choice = true;  //for the while loop
        Scanner readInput = new Scanner(System.in);
        char answer; //check if user wants to continue the program
        while(choice)
        {
            System.out.println("Enter 3 numbers that you want to find the max for separated by space:");
            num1 = readInput.nextInt(); //get input from user
            num2 = readInput.nextInt();
            num3 = readInput.nextInt();
            // System.out.printf("%d %d %d",num1, num3, num3);
            max = (num1 > num2) ? (num3 > num1 ? num3 : num1) : (num3 > num2 ? num3 : num2);
            System.out.printf("The max number is %d\n", max);
            System.out.println("Do you wish to continue? y/n:");
            answer = readInput.next().charAt(0);
            choice = (answer == 'y'||answer=='Y') ? true : false;
        }
        System.out.println("Thanks for using my max program!");
    }
    public static void main(String[] args) {
        //exercise_3_1();
        //exercise_3_2();
        exercise_3_3();   
    }
}