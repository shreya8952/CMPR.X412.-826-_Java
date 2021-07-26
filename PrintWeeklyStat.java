public class PrintWeeklyStat {
    
    // method to get details of temp array 
    public static void printStat() {
        //initialize arrays and other varibles
        int weeklyTemp[] = { 69, 70, 71, 68, 66, 71, 70 };
        int i, max = 0, min = weeklyTemp[0];
        float total = 0, average;
        
        //for loop to iterate over every item in the array and get min,max,avg
        for (i = 0; i < 7; i++) {

            //print every temp of the week
            System.out.printf("The temperature on day %d was:%d\n", i + 1, weeklyTemp[i]);
            
            //add every temp of the week and store it in total
            total += weeklyTemp[i];

            // to find the max temp of the week
            if (max < weeklyTemp[i])
                max = weeklyTemp[i];

            // to find the min temp of the week
            if (min > weeklyTemp[i])
                min = weeklyTemp[i];
        }
        //getting avg by taking the total and dividing it by 7 days of the week
        average = total / 7;
        
        //printing the min, max , average temps of the week
        System.out.printf("The minimum temperature is %d\n", min);
        System.out.printf("The maximum temperature is %d\n", max);
        System.out.printf("The average temperature is %f\n\n", average);
        System.out.printf("Thank you for using my Homework#5 solution");
    }

    public static void main(String[] args) {
        //method to print temps and get min,max,avg
        printStat();
    }
}
