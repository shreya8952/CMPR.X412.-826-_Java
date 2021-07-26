import java.util.*;
import java.io.*;

public class TestIO {
	//understand System.in you have not thought of so far
	static void testSystemIn() throws IOException { //what happens if you don't throw IOException?
		//we never used System.in directly, why?
		int b = System.in.read();
//		System.out.println(b);
//		System.out.println((char) b); //because it is a byte stream, and reads integer so not much of use to us
										//as we have to format it.
		//you can put it in an array and keep reading it
		do {
			b = System.in.read();
			System.out.println("You Entered: " + (char) b);
		} while (b != -1);
/*
		//you can put the value in byte array as well
		byte [] byteArray = new byte[4];

		System.in.read(byteArray, 0, 4);
		System.out.println("Byte read: " + (char)byteArray[0] + (char)byteArray[1] + (char)byteArray[2] + (char)byteArray[3]);
*/	}

	//working with File
	static void testFileClass() {
		String fileName = "input_final.txt"; 		//where should you put this file?  
		                                            //where this file is searched at, how do you know?
		File myFile = new File(fileName);
		if (myFile.exists()){
			System.out.println("File name is: "+ myFile.getName());
			System.out.println("File  is: " + myFile.getAbsolutePath());
		}
		//the directory where it searches in first place?
		//want to know what is the absolute path for current directory?
//		File basePathofApp = new File("."); //current directory
//		String absPath = basePathofApp.getAbsolutePath();
//		System.out.println(absPath);
	}

	// Scanner can be used with the disk File as well
	static void testFileReaderWithScanner(String fileName) {
		Scanner readInput;
		try {
			readInput = new Scanner(new File(fileName));
			while (readInput.hasNextLine()) {
				System.out.println(readInput.nextLine());
			}
		}
		//start with most specific to most general exception
		catch (FileNotFoundException e) {
			System.out.println("File: " + fileName + "not found");
		} // end catch
		catch (IOException e) {
			System.out.println("Error Reading from file: "+ fileName + e.getMessage());
		} // end catch
		catch (Exception e) {
			System.out.println(e);
		} // end catch

	}
	
	static void testInputFileSize (String inputDiskFileName) throws FileNotFoundException,IOException {
		//why I need to throw these exceptions, when I am not even using a try and catch block?
		 InputStream inStream;
		if (inputDiskFileName.length() > 0) {
			inStream = new FileInputStream(inputDiskFileName);

			int total = 0;
			while (inStream.read() != -1)
				total++;

			System.out.println("File: " + inputDiskFileName + " is: " + total + " bytes long");
			inStream.close();
		}		
	}

	static void testFileReaderDirectly(String inputDiskFileName) {
		try { //what happens if you don't have this try can catch?
			
			FileReader fileReader = new FileReader(inputDiskFileName); //which directory it looks for the file?

			int readInt;
			while ((readInt = fileReader.read()) != -1) {
				System.out.println("Byte: "+ readInt + "\tChar: " + (char)readInt);
			}
			fileReader.close(); //let us close this stream
		} catch (Exception e) {
			System.out.println("The file input_file.txt is not available in default folder\n");
			//e.printStackTrace();
		}
	}

	static void testFileReaderWithBufferedReader(String inputDiskFileName) {
		try {
			FileReader fileReader = new FileReader(inputDiskFileName); 

			BufferedReader finalInStream = new BufferedReader(fileReader);
			//shorter version:
			//BufferedReader finalInStream =  new BufferedReader(new FileReader(fileReader));
			String s;
			while ((s=finalInStream.readLine()) != null) {
				System.out.println(s);
			}
			finalInStream.close();
		} catch (Exception e) {
			System.out.println("The file input_file.txt is not available in default folder\n");
			//e.printStackTrace();
		}
	}
	//tokenizer example
	static void testTokenizer(String fileName) {
		BufferedReader bufferedReader = null;
		StreamTokenizer myTokenizer;
		int nextToken;
		double numberToken;
		String strToken;

		File inputFile = new File(fileName); 
		// create a buffered stream to read from the file
		try {
			FileReader fileStream = new FileReader(inputFile);
			bufferedReader = new BufferedReader(fileStream); //can be done in one step
			//	bufferedReader = new BufferedReader(new FileReader(new File(fileName)));

		} catch (FileNotFoundException err) {
			System.out.println(err);
			System.exit(-1); // exit if file not found
		}
		myTokenizer = new StreamTokenizer(bufferedReader);
		myTokenizer.whitespaceChars(',', ',');
        myTokenizer.eolIsSignificant(true);
		try {
			nextToken = myTokenizer.nextToken(); 
			while (nextToken != StreamTokenizer.TT_EOF) {
				if (nextToken != StreamTokenizer.TT_EOL && 
						nextToken == StreamTokenizer.TT_WORD){
					strToken = myTokenizer.sval; 
					System.out.println("Found a string: " + strToken);
				}
				if (nextToken != StreamTokenizer.TT_EOL && 
						nextToken == StreamTokenizer.TT_NUMBER){
					numberToken = myTokenizer.nval; 
					System.out.println("Found a number: " + numberToken);
				}
				nextToken = myTokenizer.nextToken();//eat up TT_EOL
			} // while
		}// try
		catch (IOException err) {
			// this code executes if there is an error in getting the next token
			// from the file
			System.out.println(err);
		}// catch
	}

	//StringTokenizer Example I
	static void testStringTokenizer_I(String inputFileName) {
		String getLine = "This is, \n a string. with four diferent delimeters"; 
		//create a tokenizer with multiple delemeters space, newline, a . and a ,
		StringTokenizer parseWords =
		            new StringTokenizer(getLine, " \n.,");
		while(parseWords.hasMoreTokens())
		{
		   System.out.println(parseWords.nextToken());
		}
	}

	//StringTokenizer Example II using Console.
	static void testStringTokenizer_II(Scanner keyBoard) {
		String getUserInput = keyBoard.nextLine();
		//create a tokenizer with multiple delemeters
		StringTokenizer parseUserInput =
		            new StringTokenizer(getUserInput, " \n.,");
		while(parseUserInput.hasMoreTokens())
		{
		   System.out.println(parseUserInput.nextToken());
		}
	}

	// Using output streams
	static void testOutputStream(String outputFileName) {
		PrintWriter textPrintStream = null;
		try {
			textPrintStream = new PrintWriter(new FileOutputStream(outputFileName));
			textPrintStream.println("This output will go to the file " + outputFileName);
			textPrintStream.write("This is Final Grade - retest \n"); //new line does not work
			textPrintStream.write("This is Final Grade - retest \r\n"); 
			//line separator for Windows is different \r\n 
			//find line separator and use it instead of using \n in print or printf.
			//printline just wroks fine
			String newLine = System.getProperty("line.separator");
			textPrintStream.write("This is new line " + newLine +"What is this");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + 
										  outputFileName + "\n" +
					                      e.getMessage());
			System.exit(0);
		}
		textPrintStream.close();
		System.out.println(outputFileName + " has been written and closed");
	}

	public static void main(String[] args) throws IOException {

//		testSystemIn();  //get more out of System.in without scanner
		testFileClass(); //what is File class anyway
		
		testInputFileSize("input_final.txt");

		testFileReaderWithScanner(args.length > 0? args[0]: "input_final.txt"); 
		testFileReaderDirectly(args.length > 0? args[0]: "input_final.txt"); //read one byte at a time		testFileReaderWithBufferedReader("input_final.txt"); //read while line
	
		testTokenizer("input_final.txt");

		testStringTokenizer_I("input_final.txt");
		testStringTokenizer_II(new Scanner(System.in)); //you can pass annonumous arguments like this
		                                                //is this a good idea? 
		testOutputStream(args.length > 1? args[1]: "output_final.txt");

	} // end main
} // end class
