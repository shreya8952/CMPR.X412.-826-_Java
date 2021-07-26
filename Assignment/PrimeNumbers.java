package Assignment;

public class PrimeNumbers {
    public static void main(String[] args) {
        int count = 0;
        int divisors = 0;
        int num = 2;
        while (count != 100) {
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    divisors += 1;
                }
            }
            if (divisors == 2) {
                count += 1;
                System.out.println(num);
            }
            divisors = 0;
            num += 1;
        }   
    }
}
