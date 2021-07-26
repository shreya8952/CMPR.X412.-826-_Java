
import java.util.*;

class NewBox implements Comparable{
	//state
	private int height = 10;
    public int width = 20;
	public String hStr = "-";
	private String vStr = "|";
	
	public String boxName = "Default Name";
	
	public String getBoxName() {
		return boxName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boxName == null) ? 0 : boxName.hashCode());
		result = prime * result + ((hStr == null) ? 0 : hStr.hashCode());
		result = prime * result + height;
		result = prime * result + ((vStr == null) ? 0 : vStr.hashCode());
		result = prime * result + width;
		return result;
	}

	public NewBox(int h, int w) {
		super();
		height = h;
		width = w;
	}
	
	public NewBox(String boxName) {
		super();
		this.boxName = boxName;
	}

	public NewBox(String boxName, int h, int w) {
		super();
		this.boxName = boxName;
		height = h;
		width = w;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewBox other = (NewBox) obj;
		if (boxName == null) {
			if (other.boxName != null)
				return false;
		} else if (!boxName.equals(other.boxName))
			return false;
		if (hStr == null) {
			if (other.hStr != null)
				return false;
		} else if (!hStr.equals(other.hStr))
			return false;
		if (height != other.height)
			return false;
		if (vStr == null) {
			if (other.vStr != null)
				return false;
		} else if (!vStr.equals(other.vStr))
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
    public int compareTo(Object o) {
    	int area1 = ((NewBox)o).height * ((NewBox)o).width;
       	int area2 = height * width;
           	
        if ( area1 < area2 )
            return 1;
        else if ( area1 > area2 )
            return -1;
        else
            return 0;
    }


	public void setBoxName(String bName) {
		this.boxName = bName;
	}

	//accessor methods aka getters
	public int getHeight () {
		return height;
	}

	public int getWidth () {
		return width;
	}
	
	//defininition of a default constructor
	public NewBox() {
		
	}
	public NewBox(int h) {
		height = h;
	}
}

//define a class which implements Comparator interface
class CompareBoxNames implements Comparator {
    public int compare(Object s1, Object s2) {
    	String str1 = ((NewBox)s1).getBoxName();
    	String str2 = ((NewBox)s2).getBoxName();
    	
       return (str1.compareTo(str2)) ;
    }
    public boolean equals(Object s1, Object s2) {
    	String str1 = ((NewBox)s1).getBoxName();
    	String str2 = ((NewBox)s2).getBoxName();
        return (str1.equalsIgnoreCase(str2));
        }
}


public class TestCollection {

	static void testArrayOfReferences() {
		NewBox [] myBoxArray = new NewBox[10]; 
        // is array of 10 Box objects � Java objects
		myBoxArray[0] = new NewBox();
		myBoxArray[1] = new NewBox(5);
		myBoxArray[2] = new NewBox("I am fancy");
		myBoxArray[3] = new NewBox("I am fat and fancy", 30, 60);
		//you can keep adding it.
	}
	
	//ArrayList is better array, shrinks and expands
	static void testArrayList(){
		//will dynamically grow
		ArrayList listOfValues1 = new ArrayList();
		listOfValues1.add(1); //add integer to it (it eventually converts to Inter object)
		listOfValues1.add(2);
		listOfValues1.add(3);
		System.out.println(listOfValues1);
		
		//remove all of the members
		listOfValues1.clear();
		System.out.println(listOfValues1);
		
		//now add another type of object to same ArrayList
		listOfValues1.add("John");
		listOfValues1.add("Jack");
		listOfValues1.add("Jill");
		System.out.println(listOfValues1);
		System.out.println("3: " + listOfValues1.get(2)); //fiind who is there in third position

		//is not this scary? You can even add newbox in it, WHAT?  wait a minute, how
		//can I mix apple and oranges? How do I know what I have stored in there
		listOfValues1.add(new NewBox(10));
		listOfValues1.add(new NewBox(20));
		listOfValues1.add(new NewBox(30));

		//this definitely looks scary to me
		NewBox getBox = (NewBox)listOfValues1.get(3);
		System.out.println(listOfValues1);
		
		NewBox newBox =new NewBox(30);
		//Ah this is consoling, at least I can test out what is inside the ArrayList before I use it
		//Ok, then looks like it can be used
		if (listOfValues1.contains(newBox)) {
			System.out.println("This Box is present");
		} else
			System.out.println("This Box is not present");
	}

	//linked list example
	static void testLinkedList() {
		LinkedList linkedListValues = new LinkedList();
		linkedListValues.addFirst("John");
		linkedListValues.addLast("Jill");
		linkedListValues.addFirst("Jack");
		linkedListValues.add("Kerry");
		linkedListValues.addLast("Sarah");
		
		System.out.println(linkedListValues);
	}

	static void testNormalArraySort() {
		//Use Compare To
        //using with normal array
        NewBox box1 = new NewBox("New Box 3", 10, 20);     
        NewBox box2 = new NewBox("New Box 4", 20, 28);      
        NewBox box3 = new NewBox("New Box 2", 20, 20);      
        NewBox box4 = new NewBox("New Box 1", 25, 20);      

        NewBox[] lotsOfBoxes = new NewBox[] {box1, box2, box3, box4};
        for (int i = 0; i < lotsOfBoxes.length; i++)
            System.out.println(lotsOfBoxes[i].getBoxName());
        
        //sort naturally - provided by the object
        Arrays.sort(lotsOfBoxes);
        for (int i = 0; i < lotsOfBoxes.length; i++)
            System.out.println(lotsOfBoxes[i].getBoxName() + " Area: " +
            		lotsOfBoxes[i].getHeight() * lotsOfBoxes[i].getWidth());
 
	}

	static void testArrayGotchas() {
        NewBox box1 = new NewBox("New Box 3", 10, 20);     
        NewBox box2 = new NewBox("New Box 4", 20, 28);      
        NewBox box3 = new NewBox("New Box 2", 20, 20);      
        NewBox box4 = new NewBox("New Box 1", 25, 20);      

        NewBox[] lotsOfBoxes = new NewBox[] {box1, box2, box3, box4};

        //assign an object to all of them
        Arrays.fill(lotsOfBoxes,  box1);
        for (int i = 0; i < lotsOfBoxes.length; i++)
            System.out.println(lotsOfBoxes[i].getBoxName());
        //be careful what you just did.  everyone is pointing to one reference
        box1.setBoxName("Box1");
        for (int i = 0; i < lotsOfBoxes.length; i++)
            System.out.println(lotsOfBoxes[i].getBoxName());
	}
	
	static void testArrayListSort() {
		//Use with ArrayList
        NewBox box_1 = new NewBox("New Box 3", 10, 20);     
        NewBox box_2 = new NewBox("New Box 4", 20, 28);      
        NewBox box_3 = new NewBox("New Box 2", 20, 20);      
        NewBox box_4 = new NewBox("New Box 1", 25, 20);      
        //populate the array list
        ArrayList lotsOfNewBoxes = new ArrayList();
        lotsOfNewBoxes.add(box_1);
        lotsOfNewBoxes.add(box_2);
        lotsOfNewBoxes.add(box_3);
        lotsOfNewBoxes.add(box_4);
        //use it
        System.out.println("In the order of creation:\n");
        for (int i = 0; i < lotsOfNewBoxes.size(); i++) {
        	NewBox nBox = (NewBox)lotsOfNewBoxes.get(i);
            System.out.println(nBox.getBoxName());
        }
		
        //sort natually - provided by the object
 		System.out.println("\nIn the order of natural sorting:\n");
 		Collections.sort(lotsOfNewBoxes);  //use collections instead of Arrays
 		for (int i = 0; i < lotsOfNewBoxes.size(); i++) {
 			NewBox nBox = (NewBox) lotsOfNewBoxes.get(i);
 			System.out.println(nBox.getBoxName() + " Area: " + nBox.getHeight()
 					* nBox.getWidth());
 		}
	}

	//test iterators
	
	static void testIterators() {
		//Use with ArrayList
        NewBox box_1 = new NewBox("New Box 3", 10, 20);     
        NewBox box_2 = new NewBox("New Box 4", 20, 28);      
        NewBox box_3 = new NewBox("New Box 2", 20, 20);      
        NewBox box_4 = new NewBox("New Box 1", 25, 20);      

        ArrayList lotsOfNewBoxes = new ArrayList();
        lotsOfNewBoxes.add(box_1);
        lotsOfNewBoxes.add(box_2);
        lotsOfNewBoxes.add(box_3);
        lotsOfNewBoxes.add(box_4);
        System.out.println("In the order of creation:\n");
        for (int i = 0; i < lotsOfNewBoxes.size(); i++) {
        	NewBox nBox = (NewBox)lotsOfNewBoxes.get(i);
            System.out.println(nBox.getBoxName());
        }
        
        System.out.println("\nUsing Iterator:\n");
        //using iterator
        Iterator it = lotsOfNewBoxes.iterator();
        while(it.hasNext()) {
          NewBox box = (NewBox)(it.next());
          System.out.println(box.getBoxName());
        }            

	}
	
	//test Arrays using Compare
	static void testArraySortUsingCompare() {
        NewBox box1 = new NewBox("New Box 3", 10, 20);     
        NewBox box2 = new NewBox("New Box 4", 20, 28);      
        NewBox box3 = new NewBox("New Box 2", 20, 20);      
        NewBox box4 = new NewBox("New Box 1", 25, 20);      

        NewBox[] lotsOfBoxes = new NewBox[] {box1, box2, box3, box4};
		//using  CompareBoxNames
        Arrays.sort(lotsOfBoxes, new CompareBoxNames());
        for (int i = 0; i < lotsOfBoxes.length; i++)
            System.out.println(lotsOfBoxes[i].getBoxName());
   
        //assign an object to all of them
        Arrays.fill(lotsOfBoxes,  box1);
        for (int i = 0; i < lotsOfBoxes.length; i++)
            System.out.println(lotsOfBoxes[i].getBoxName());
        //be careful what you just did.  everyone is pointing to one reference
        box1.setBoxName("Box1");
        for (int i = 0; i < lotsOfBoxes.length; i++)
            System.out.println(lotsOfBoxes[i].getBoxName());

	}

	static void testArrayListSortUsingCompare() {
		//Use with ArrayList
        NewBox box_1 = new NewBox("New Box 3", 10, 20);     
        NewBox box_2 = new NewBox("New Box 4", 20, 28);      
        NewBox box_3 = new NewBox("New Box 2", 20, 20);      
        NewBox box_4 = new NewBox("New Box 1", 25, 20);      

        ArrayList lotsOfNewBoxes = new ArrayList();
        lotsOfNewBoxes.add(box_1);
        lotsOfNewBoxes.add(box_2);
        lotsOfNewBoxes.add(box_3);
        lotsOfNewBoxes.add(box_4);

        System.out.println("In the order of creation:\n");
        for (int i = 0; i < lotsOfNewBoxes.size(); i++) {
        	NewBox nBox = (NewBox)lotsOfNewBoxes.get(i);
            System.out.println(nBox.getBoxName());
        }
        
		System.out
				.println("\nIn the order of Comparator sorting Implementation:\n");
         Collections.sort(lotsOfNewBoxes,new CompareBoxNames());
        for (int i = 0; i < lotsOfNewBoxes.size(); i++) {
        	NewBox nBox = (NewBox)lotsOfNewBoxes.get(i);
            System.out.println(nBox.getBoxName() + " Area: " +
            		nBox.getHeight() * nBox.getWidth());
        }
 		
	}
	
	//test ArrayList With Generics
	static void testArrayListWithGenerics() {
        NewBox box_1 = new NewBox("New Box 3", 10, 20);     
        NewBox box_2 = new NewBox("New Box 4", 20, 28);      
        NewBox box_3 = new NewBox("New Box 2", 20, 20);      
        NewBox box_4 = new NewBox("New Box 1", 25, 20);      

		//with generics
		//Use with ArrayList
        ArrayList<NewBox> arrayOfBoxes = new ArrayList<NewBox>();
        arrayOfBoxes.add(box_1);
        arrayOfBoxes.add(box_2);
        arrayOfBoxes.add(box_3);
        arrayOfBoxes.add(box_4);
        System.out.println("In the order of creation:\n");
        for (int i = 0; i < arrayOfBoxes.size(); i++) {
        	NewBox nBox = arrayOfBoxes.get(i);
            System.out.println(nBox.getBoxName());
        }
        
        //sort natually - provided by the object
		System.out.println("\nIn the order of natural sorting:\n");
		Collections.sort(arrayOfBoxes);
		for (int i = 0; i < arrayOfBoxes.size(); i++) {
			NewBox nBox = (NewBox) arrayOfBoxes.get(i);
			System.out.println(nBox.getBoxName() + " Area: " + nBox.getHeight()
					* nBox.getWidth());
		}

		System.out
				.println("\nIn the order of Comparator sorting Implementation:\n");
        Collections.sort(arrayOfBoxes,new CompareBoxNames());
        for (int i = 0; i < arrayOfBoxes.size(); i++) {
        	NewBox nBox = (NewBox)arrayOfBoxes.get(i);
            System.out.println(nBox.getBoxName() + " Area: " +
            		nBox.getHeight() * nBox.getWidth());
        }
            
        System.out.println("\nUsing Iterator:\n");
        //using iterator
        Iterator it1 = arrayOfBoxes.iterator();
        while(it1.hasNext()) {
          NewBox box = (NewBox)(it1.next());
          System.out.println(box.getBoxName());
        }            
 	}

	//test Enhanced For Loop
	static void testEnchanceForLoop() {
		//enhanced for loop
		String [] args = {"First", "Second", "Third", "Fourth"};
		
		int [] weeklyTemp = {69, 70, 71, 68, 66, 71, 70};
		
		//instead of 
		for (int day=0; day < weeklyTemp.length; day++)
			System.out.printf("The temperature on day %d was %d\n", day+1, weeklyTemp[day]);
		System.out.println();
		//use this
		int day=0;
		for (int dayTemp : weeklyTemp)
			System.out.printf("The temperature on day %d was %d\n", ++day, dayTemp);
		System.out.println();

		//parsing command line arguments
	
		//how do you get them individually?
		//with old for loop way
		for (int i = 0; i < args.length; i++) {
			System.out.print("Argument " + (i+1) + ": ");
			System.out.println(args[i]);
		}

		//using enhanced for loop
		int i=0;
		for (String strArgument: args ) {
			System.out.print("Argument " + ++i + ": ");
			System.out.println(strArgument);
		}

	}

	//generics and methods
/*
	//instead of these
	private void displayStatisticsHelper(String str, float[] array){
	}

	private void displayStatisticsHelper(String str, double[] array){
	}
*/
	//you can have these
	private static <T> boolean displayStatisticsHelper(String str, T[] array){
//		Integer digit = Integer.parseInt(str); //you have to make sure you will use for compatible type
		Float digit = Float.parseFloat(str);
		for (T value : array) {
			if (digit.equals(value))
				return true;
		}
		return false;
	}
	
	public static  <T> void  displayStatisticsHelperNew (String str, T[] array){
		System.out.printf("%s:\t", str);
		for(int i=0; i<array.length; i++){
			System.out.printf("%.0f\t", array[i]);
		}
		System.out.println();
	}
	
	public static <T> boolean contains(T[] array, T anyObject) {
		for (T value : array) {
			if (anyObject.equals(value))
				return true;
		}
		return false;
	}
	
	public static void testGeneric() {
		
		//test a generic method which uses generics
		//same contains will work for Integer, or String object
		//Integer example

		//test contains
		Integer[] array = new Integer[5];
		for (int pos = 0; pos < 5; pos++) {
			array[pos] = pos * pos;
		}
		if (contains(array, new Integer(15))) {
			System.out.println("Found the value");
		} else {
			System.out.println("Value not found");
		}
		
		//test displayStatisticsHelper
		if (displayStatisticsHelper(new String ("15"), array)) {
			System.out.println("Found the value 15");
		} else {
			System.out.println("Value 15 not found");
		}
		
		if (displayStatisticsHelper(new String ("16"), array)) {
			System.out.println("Found the value 16");
		} else {
			System.out.println("Value 16 not found");
		}
		
		Float[] farray = new Float[5];
		for (int i = 0; i < 5; i++) {
			farray[i] = i * i * 1.0f;
		}
		if (displayStatisticsHelper(new String ("16"), farray)) {
			System.out.println("Found the value 16");
		} else {
			System.out.println("Value 16 not found");
		}
		
		//string example
		String[] strArray = new String[5];
		String strTemp;
		for (int i = 0; i < 5; i++) {
			strTemp = String.format("This is string %d",  i*i);
			strArray[i] = strTemp;
		}
		if (contains(strArray, new  String("This is string 18"))) {
			System.out.println("Found the value");
		} else {
			System.out.println("Value not found");
		}

//		displayStatisticsHelperNew("Average", farray);
//		displayStatisticsHelperNew("Minimum", array);
		
		displayStatisticsHelper("90.88", farray);
		displayStatisticsHelper("90", array);
	}

	public static void main(String[] args) {
		
		//just like array of primitive data types you can array of references
		testArrayOfReferences();
	
		//using ArrayList
		testArrayList();

		//what is linkedlist anyways?
		testLinkedList();
		
		//normal sorting
		testNormalArraySort();
		
		//Array Gotchas
		testArrayGotchas();

		//normal sorting ArrayList
		testArrayListSort();
		
		//Enhanced For Loop
		testEnchanceForLoop();

		//test iterators
		testIterators();
		
		//test ArrayListusing Compare
		testArraySortUsingCompare();

		//test ArrayListusing Compare
		testArrayListSortUsingCompare();
	
		//ArrayList and Generics
		testArrayListWithGenerics();
		
		//testMoreGenerics
		testGeneric();


        }
}


