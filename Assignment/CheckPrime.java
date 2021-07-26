package Assignment;
import java.util.*;

public class CheckPrime {
    public static void main(String[] args) {
        System.out.println("YES");
        Scanner readInput = new Scanner(System.in);
        int divisors = 1;
        System.out.printf("Enter the number you want to check:");
        int num = readInput.nextInt();

        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                divisors += 1;
            }
        }
        if (divisors == 2) {
            System.out.printf("%d is a prime number!", num);
        }
        else {
            System.out.printf("%d is NOT a prime a number!", num);
        }
        readInput.close();
    }
}
