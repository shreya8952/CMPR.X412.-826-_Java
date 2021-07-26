import java.util.Scanner;

/*
 * This is solution for Homework #8.
 * OOPWeeklyTemp Class has states(variables) and methods in it.
 * WeeklyTemp Class has the main method
 * 
 * @author shreyagurumurthy
 * @version 1.0
 * @since 05-06-21NN
 */

class OOPWeeklyTemp {

    private int[] weeklyTemp = new int[7];
    private int maxTemp = 0;
    private int minTemp = 0;
    private float averageTemp = 0;

    /*
     * @param readInput 
     *          : Scanner passed from main method 
     * The numbers are added in the array based on
     */
    public void getTemperatures(Scanner readInput) {
        for (int i = 0; i < 7; i++) {
            System.out.printf("Please enter temperature on Day %d:", i + 1);
            weeklyTemp[i] = readInput.nextInt();
        }
    }

    /*
     * No parameters passed 
     * Prints all temperatures
     */
    public void printTemperatures() {
        for (int i = 0; i < 7; i++) {
            System.out.printf("The temperature on Day %d is :%d\n", i + 1, weeklyTemp[i]);
        }
    }

    /*
     * No parameters passed 
     * Returns the maximum of temperatures
     */
    public int getMax() {
        for (int i = 0; i < 7; i++) {
            if (i == 0)
                maxTemp = weeklyTemp[i];
            if (weeklyTemp[i] > maxTemp)
                maxTemp = weeklyTemp[i];
        }
        return maxTemp;
    }

    /*
     * No parameters passed 
     * Returns the minimum of temperatures
     */
    public int getMin() {
        for (int i = 0; i < 7; i++) {
            if (i == 0)
                minTemp = weeklyTemp[i];
            if (weeklyTemp[i] < minTemp)
                minTemp = weeklyTemp[i];
        }
        return minTemp;
    }

    /*
     * No parameters passed 
     * Returns the average of temperatures
     */
    public float getAverage() {
        int total = 0;
        for (int i = 0; i < 7; i++) {
            total += weeklyTemp[i];
        }
        averageTemp = total / 7;
        return averageTemp;
    }

    /*
     * No parameters passed 
     * Prints min,max and average
     */
    public void printStatistics() {
        System.out.printf("The maximum temperature is %d\n", getMax());
        System.out.printf("The minimum temperature is %d\n", getMin());
        System.out.printf("The average temperature is %f\n", getAverage());
    }
}

/*
 * This class contains the main method of this program
 */
public class WeeklyTemp {

    /*
     * @param args 
     *      : not used in this program 
     * The main method creates scanner and instantiates obj of OOPWeeklyTemp class 
     * temp obj calls its methods
     */
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        OOPWeeklyTemp temp = new OOPWeeklyTemp();
        temp.getTemperatures(readInput);
        temp.printTemperatures();
        temp.printStatistics();
        readInput.close();
    }
}