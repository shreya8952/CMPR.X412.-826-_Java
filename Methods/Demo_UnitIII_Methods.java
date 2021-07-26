import java.util.Scanner;
import java.util.InputMismatchException;

class TwoDBox {
	private int width = 20;
	private int height = 10;
	private String hLineSymbol = "-";
	private String vLineSymbol = "|";

	public TwoDBox() { //speciale method - constructor

	}

	public TwoDBox(int w, int h, String hLine, String vLine) {
		width = w;
		height = h;
		hLineSymbol = hLine;
		vLineSymbol = vLine;
	}

	public void changeHLineSymbol(String hLine) {
		hLineSymbol = hLine;
	}

	public void changeVLineSymbol(String vLine) {
		vLineSymbol = vLine;
	}

	public void changeWidth(int newWidth) {
		width = newWidth;
	}

	public void changeHeight(int newHeight) {
		height = newHeight;
	}

	public void drawHorizontalLine() {
		int count = 0;
		while (count++ < width)
			System.out.printf(hLineSymbol);
		System.out.printf("\n");
	}

	void drawVerticalLines() {
		int count = 0, count2 = 0;
		while (count++ < height) {
			System.out.printf(vLineSymbol);
			count2 = 0;
			while (count2++ < width - 2)
				System.out.printf(" ");
			System.out.printf(vLineSymbol + "\n");
		}
	}

	public void drawBox() {
		drawHorizontalLine();
		drawVerticalLines();
		drawHorizontalLine();
	}
}//TwoDBox


public class Demo_UnitIII_Methods {

	//this method will fill in the temperature array
	//by getting the values from user
	static void getTemperatures(int [] tempArray){
		Scanner getInput = new Scanner (System.in); //this resource will be leaked, must close it
		
		int myDay;
		for (myDay = 0; myDay < tempArray.length; myDay++){
			System.out.printf("Enter the temp: ");
			tempArray[myDay] = getInput.nextInt();
		}
	}
	
	//print all the temperatures of tempArray
	static void printTemperatures(int [] tempArray) {
		int day;
		for (day=0; day < tempArray.length; day++)
			System.out.printf("The temperature on day %d was %d\n", day+1, tempArray[day]);
		System.out.println();
		
	}
	
	//returns minimum temperature in the tempArray
	static int getMinimum(int [] tempArray) {
		int min = tempArray[0];
		int day;
		for (day = 1; day < tempArray.length; day++){
			if (min > tempArray[day])
				min = tempArray[day];
		}
		return min;
	}

	//returns maximum temperatures in the tempArray
	static int getMaximum(int [] tempArray) {
		int day;
		int max = tempArray[0];
		for (day = 1; day < tempArray.length; day++){
			if (max < tempArray[day])
				max = tempArray[day];
		}
		return max;
	}

	//return total of the tempArray
	static int getTotal(int [] tempArray) {
		int day;
		int total = tempArray[0];
		for (day=1;day < tempArray.length; day++)
			total += tempArray[day];
		return total;
	}
	
	static void drawHorizontalLine(int width, String horizontalBar) {
		int count = 0;
		while (count++ < width)
			System.out.printf(horizontalBar);
		System.out.printf("\n");
	}

	static void drawVerticalLines(int height, int width, String verticalBar) {
		int count = 0, count2 = 0;
		while (count++ < height) {
			System.out.printf(verticalBar);
			count2 = 0;
			while (count2++ < width - 2)
				System.out.printf(" ");
			System.out.printf(verticalBar + "\n");
		}
	}

	static void drawBox(int h, int w, String hChar, String vChar){
		drawHorizontalLine(w, hChar);
		drawVerticalLines(h, w, vChar);
		drawHorizontalLine(w, hChar);
	}
	
	//character 
	public static boolean isLetter (char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// delcration, no memory yet
		int [] weeklyTemp1; 

		weeklyTemp1 = new int[7];  //now 7 slots of memory created

		//initialize 7 elements with 0-6 index -- it zero based index
		weeklyTemp1[0] = 69;
		weeklyTemp1[1] = 70;
		weeklyTemp1[2] = 71;
		weeklyTemp1[3] = 90;
		weeklyTemp1[4] = 66;
		weeklyTemp1[5] = 71;
		weeklyTemp1[6] = 70;
		
		//you can initialize in different way
		//declration and definition can be combined and provide hard coded temperatures 
		int [] weeklyTemp = {69, 70, 71, 68, 66, 71, 70};

		//use the array, each element is one variable
		float sum = weeklyTemp1[0] + weeklyTemp1[1] + weeklyTemp1[2] +
				weeklyTemp1[3] + weeklyTemp1[4] + weeklyTemp1[5] + weeklyTemp1[6];
		
		System.out.println("The average of seven temperatur is: " + sum/7);

		//more efficient when using with loops
		int day;
		float total = weeklyTemp[0];
		for (day=1;day < weeklyTemp.length; day++)
			total += weeklyTemp[day];
		System.out.println("The average of seven temperature is: " + total/weeklyTemp.length);
		
		//find maximum temperature
		int max = weeklyTemp[0];
		for (day = 1; day < weeklyTemp.length; day++){
			if (max < weeklyTemp[day])
				max = weeklyTemp[day];
		}
		System.out.println("The maximum temperature of the week is: " + max);

		//comparing arrays
		int [] weeklyTemp3 = {69, 70, 71, 68, 66, 71, 70};
		int [] weeklyTemp4 = {69, 70, 71, 68, 66, 71, 70};
		
		//what do you think will be printed?
		if (weeklyTemp3 == weeklyTemp4)
		{
			System.out.println("These two are equal arrays");
		}else{
			System.out.println("These two are unequal arrays");
		}
		
//		System.out.println("THis is reference printing " + weeklyTemp3.toString());
//		System.out.println("THis is reference printing " + weeklyTemp4.toString());


		//now use methods

		//call a method to get the temperatures from users
		getTemperatures(weeklyTemp);
		//call a method to print temperatures
		int [] weeklyTemp2 = {69, 70, 71, 68, 66, 79, 70};
		printTemperatures(weeklyTemp2);

		//use methods within other methods as well
		System.out.printf("The Minimum temperature is: %d\n", getMinimum(weeklyTemp));
		System.out.printf("The Maximum temperature is: %d\n", getMaximum(weeklyTemp));
		//understand why you need to make a method as static
	
		System.out.printf("The average of weekly temperature is:%5.2f\n", getTotal(weeklyTemp) / 7.0);

		//Questions:  How do you change some of these methods to:
		
		//return minimum and maximum of array in one method
		
		//How do you write a method to swap two values?
		
		//How do you trap error when user gives wrong input?
		
		//How do you make sure that the Scanner resource is not leaked?
		
		//draw box code
		
		int j = 0;
		
		while (j < 20)
		{
			System.out.printf("-");
			j++;
		}
		
		System.out.println();

		int k = 0;
		while (k < 8)
		{
			//then          |              |
			j = 0;
			System.out.printf("|");
			while (j < 18)
			{
				System.out.printf(" ");
				j++;
			}
			System.out.printf("|");
			System.out.println();
			k++;
		}
		
		//finally last          ---------------
		j = 0;
		while (j < 20)
		{
			System.out.printf("-");
			j++;
		}
		System.out.println();

		//Now, change the following code to draw box and use methods
		//so that you can draw different sizes of boxes using different characters

		//draw 10x20 box with - and |
		     drawHorizontalLine(20, "-");
		     drawVerticalLines(10, 20,"|");
		     drawHorizontalLine(20, "-");

		//draw 5X10 box with = and +
			drawHorizontalLine(10, "=");
			drawVerticalLines(5, 10,"+");
			drawHorizontalLine(10, "=");

		//draw2X5 box with . and ,
			drawHorizontalLine(5, ".");
			drawVerticalLines(2, 5,",");
			drawHorizontalLine(5, ".");
			//how about even go one step further and call like this
			drawBox(10,20, "$", "&");

		
////class and objects
		//now crreate a box class so that you can do something like this
		TwoDBox myDefaultBox = new TwoDBox();
		myDefaultBox.drawBox();

		TwoDBox myBigBox = new TwoDBox(30, 20, "=", "|");
		myBigBox.drawBox();
		
		TwoDBox myTinyBox = new TwoDBox(3,5, "$", "+");
		myTinyBox.drawBox();
		

////Cahracters and Strings
		
		//character 
		
		char myChar = 'A';

		if (Character.isLetter(myChar)){
			System.out.println("This is a Character");
		}
		
		//strings
		String strExample = "Strings are Immutable, that means once they are created you can\'t change them";
		System.out.println(strExample);
		strExample = "How about now?";
		System.out.println(strExample);
		strExample = "I am confused, did not I just changed it?";
		System.out.println(strExample);
		
	
		//what is really happening?

		//why can't I do this?
		//System.out.println(strExample.length);

		String str1 = new String("John Desvernine");
		String str2 = new String("John Desvernine");
		String str3 = "John Desvernine";
		String str4 = "John Desvernine";

		if (str1 == str2)
			System.out.println("str1 and str2 are equal");
		else
			System.out.println("str1 and str2 are not equal");
	
		if (str1 == str3)
			System.out.println("str1 and str3 are equal");
		else
			System.out.println("str1 and str3 are not equal");

		if (str3 == str4)
			System.out.println("str3 and str4 are equal");
		else
			System.out.println("str3 and str4 are not equal");
		
		//what is the magic?  Java stores all strings created as literals "John Desvernine" 
		//in an internal table and re-uses them for efficiencies. 
		//String is an Immutable class - can't be destroyed once created

		//demo string
		String str = "Bineet K Sharma";
		//returns the size of string
		System.out.println("Length of string is:   " + str.length());
		
		//returns char at that index
		System.out.println("Instructors initial is:" 
		         + str.charAt(0) + str.charAt(7) + str.charAt(9));
		
		//returns index of first occurrence of that character or string 
		System.out.println("Index of 'a' is: " + str.indexOf('a'));
		System.out.println("Index of 'a' is: " + str.indexOf('a', 12));
		System.out.println("Index of 'Sharma' is: " + str.indexOf("Sharma"));

		//returns part of the string
		System.out.println("Substring starting at index 9: " + str.substring(9));
		System.out.println("Substring between index 0, 8-1: " + str.substring(0, 8));
		System.out.println("Upper case string: " + str.toUpperCase());

		//returns true or false
		System.out.println("Does the string start with this string: " + str.startsWith("neet"));
		System.out.println("Does the string start with this string: " + str.startsWith("neet", 2));
		
		//returns true or false
		System.out.println("Are these two strings equal? " + str.equals("Bineet K Sharma"));
		System.out.println("Are these two strings equal? " + str.equals("bineet k sharma"));
		System.out.println("Are these two strings equal? " + str.equalsIgnoreCase("BINEET K SHARMA"));
		
		//returns 0 if equal, difference if short or long, ASCII difference of first different character
		System.out.println("Are these two strings compare? " + str.compareTo("Bineet K Sharma"));
		System.out.println("Are these two strings compare? " + str.compareTo("Bineet"));
		System.out.println("Are these two strings compare? " + str.compareTo("Bineet K Sharma Ji"));
		System.out.println("Are these two strings compare? " + str.compareTo("BineeT K Sharma"));
		System.out.println("Are these two strings compare? " + str.compareTo("Bineet k"));
	}
}

