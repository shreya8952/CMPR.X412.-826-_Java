package Assignment;

import java.util.*;
public class Sort {
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        int num = 0;
        System.out.printf("Enter the number of numbers you'd like to sort:");
        num = readInput.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.printf("Enter number %d:", i + 1);
            numbers[i] = readInput.nextInt();
        }
        Arrays.sort(numbers);
        System.out.printf(Arrays.toString(numbers));
        readInput.close();
    }   
}
