package Assignment;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        System.out.printf("Please enter the word you want to check:");
        String word = readInput.next();
        int i = 0, j = word.length() - 1;
        if ((j + 1) % 2 != 0) 
        {
            while (i != j) {
                if (word.charAt(i) != word.charAt(j)) {
                    System.out.println("Not a palindrome");
                    return;
                }
                i++;
                j--;
            }
            System.out.println("Yes it is a palindrome!!");
        }
        else {
            while (i < j) {
                if (word.charAt(i) != word.charAt(j)) {
                    System.out.println("Not a palindrome");
                    return;
                }
                i++;
                j--;
            }
            System.out.println("Yes it is a palindrome!!");
            
        }
        readInput.close();
    }    
}
