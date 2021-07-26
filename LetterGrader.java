import java.util.*;
import java.io.*;

/*
 * This is solution for Final Programming Assignment.
 * StudentDetails Class has states(variables) and methods in it- it holds all information of student.
 * LetterGrader Class is the parent class.
 * It has the various methods that the driver program TestLetterGrader uses 
 * 
 * @author shreyagurumurthy
 * @version 1.0
 * @since 04-29-21NN
 */
class StudentDetails {
    private String name;
    private int q1;
    private int q2;
    private int q3;
    private int q4;
    private int mid1;
    private int mid2;
    private int fin;
    private int total;
    private char grade;

    /*
     * @param name 
     *      : Used as student name
     * @param q1, q2, q3, q4, mid1, mid2, fin
     *      : Used to store the scores of the student for quiz 1-4, midterm 1-2, final
     * Constructor method for the StudentDetails class
     */
    public StudentDetails(String name, String q1, String q2, String q3, String q4, String mid1, String mid2,
            String fin) {
        this.name = name;
        this.q1 = Integer.parseInt(q1);
        this.q2 = Integer.parseInt(q2);
        this.q3 = Integer.parseInt(q3);
        this.q4 = Integer.parseInt(q4);
        this.mid1 = Integer.parseInt(mid1);
        this.mid2 = Integer.parseInt(mid2);
        this.fin = Integer.parseInt(fin);
        this.total = (int) (this.q1 * 0.1 + this.q2 * 0.1 + this.q3 * 0.1 + this.q4 * 0.1 + this.mid1 * 0.2
                + this.mid2 * 0.15 + this.fin * 0.25);
    }
    
    /*
     * No parameters passed 
     * Getter method for name
     */
    public String getName() {
        return this.name;
    }

    /*
     * No parameters passed 
     * Getter method for weighted total
     */
    public int getTotal() {
        return this.total;
    }

    /*
     * No parameters passed 
     * Getter method for grade
     */
    public char getGrade() {
        return this.grade;
    }
    
    /*
     * @param grade 
     *      : sets the grade for each student object
     * setter method for grade for each student
     */
    public void setGrade(char grade) {
        this.grade = grade;
    }

    /*
     * No parameters passed 
     * Getter method for quiz1
     */
    public int getq1() {
        return this.q1;
    }

    /*
     * No parameters passed 
     * Getter method for quiz2
     */
    public int getq2() {
        return this.q2;
    }

    /*
     * No parameters passed 
     * Getter method for quiz3
     */
    public int getq3() {
        return this.q3;
    }

    /*
     * No parameters passed 
     * Getter method for quiz4
     */
    public int getq4() {
        return this.q4;
    }

    /*
     * No parameters passed 
     * Getter method for mid1
     */
    public int getmid1() {
        return this.mid1;
    }

    /*
     * No parameters passed 
     * Getter method for mid1
     */
    public int getmid2() {
        return this.mid2;
    }

    /*
     * No parameters passed 
     * Getter method for final
     */
    public int getfin() {
        return this.fin;
    }
}

/*
 * This class implements Comparator to sort the names of the students alphabetically
 */
class CompareStudentNames implements Comparator {
    /*
     * @param s1,s2 
     *      : objects used to compare the student names- sort alphabetically
     */
    public int compare(Object s1, Object s2) {
        String str1 = ((StudentDetails) s1).getName();
        String str2 = ((StudentDetails) s2).getName();
        return (str1.compareTo(str2));
    }
    /*
     * @param s1,s2 
     *      : objects used to check if student names are the same
     */

    public boolean equals(Object s1, Object s2) {
        String str1 = ((StudentDetails) s1).getName();
        String str2 = ((StudentDetails) s2).getName();
        return (str1.equalsIgnoreCase(str2));
    }
}

/*
 * This is the public class- superclass with the various methods that the driver program calls
 */
public class LetterGrader {
    private String inputFile;
    private String outputFile;
    private ArrayList<Object> studentList = new ArrayList<>();
    private double[] average = { 0, 0, 0, 0, 0, 0, 0 };
    private int[] minimum = new int[7];
    private int[] maximum = { 0, 0, 0, 0, 0, 0, 0 };

    /*
     * @param args 
     *          : Used to take the input and output file name 
     * Constructor method for the LetterGrader class
     */
    public LetterGrader(String[] args) {
        inputFile = args[0];
        outputFile = args[1];
    }

    /*
     * No parameters passed 
     * Reads from inputFile and then stores the information as object of StudentDetails class
     * Creates a collection of StudentDetails objects(ArrayList)
     */
    public void readScore() {
        try {
            Scanner input = new Scanner(new File(inputFile));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] studentInfo = line.split(",");

                // to remove white spaces from the scores
                for (int i = 1; i < studentInfo.length; i++) {
                    studentInfo[i] = studentInfo[i].replaceAll("\\s", "");
                }
                studentList.add(new StudentDetails(studentInfo[0], studentInfo[1], studentInfo[2], studentInfo[3],
                        studentInfo[4], studentInfo[5], studentInfo[6], studentInfo[7]));
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File: " + inputFile + "not found");
        } catch (Exception e) {
            System.out.println(e);
        } // end catch
    }
    
    /*
     * No parameters passed 
     * Calculates the grade using the weighted total and saves it in grade
     */
    public void calcLetterGrade() {
        for (int i = 0; i < studentList.size(); i++) {
            int total = (((StudentDetails) studentList.get(i)).getTotal());
            if (total >= 90) {
                ((StudentDetails) studentList.get(i)).setGrade('A');
            } else if (total >= 80 && total <= 89) {
                ((StudentDetails) studentList.get(i)).setGrade('B');
            } else if (total >= 70 && total <= 79) {
                ((StudentDetails) studentList.get(i)).setGrade('C');
            } else if (total >= 60 && total <= 69) {
                ((StudentDetails) studentList.get(i)).setGrade('D');
            } else if (total <= 59) {
                ((StudentDetails) studentList.get(i)).setGrade('F');
            }
            // System.out.println(studentList.get(i));
        }
    }

    /*
     * No parameters passed 
     * Saves the names of students and their grades in the output file
     * Sorted alphabetically
     */
    public void printGrade() {
        try (PrintWriter op = new PrintWriter(outputFile)) {
            String output = "";
            Collections.sort(studentList, new CompareStudentNames());
            for (int i = 0; i < studentList.size(); i++) {
                output += ((StudentDetails) studentList.get(i)).getName() + ":  "
                        + ((StudentDetails) studentList.get(i)).getGrade() + "\n";
            }
            // System.out.println(output);
            op.println(output);
            op.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + outputFile + "\n" + e.getMessage());
            System.exit(0);
        }
    }

    /*
     * No parameters passed 
     * Prints the average, minimum and maximum score on the console
     * Prints for each quiz, midterm and final
     */
    public void displayAverages() {
        System.out.println("            Q1          Q2        Q3         Q4        Mid1       Mid2       Final");
        for (int i = 0; i < studentList.size(); i++) {
            average[0] += ((StudentDetails) studentList.get(i)).getq1();
            average[1] += ((StudentDetails) studentList.get(i)).getq2();
            average[2] += ((StudentDetails) studentList.get(i)).getq3();
            average[3] += ((StudentDetails) studentList.get(i)).getq4();
            average[4] += ((StudentDetails) studentList.get(i)).getmid1();
            average[5] += ((StudentDetails) studentList.get(i)).getmid2();
            average[6] += ((StudentDetails) studentList.get(i)).getfin();
            if (i == 0) {
                minimum[0] = ((StudentDetails) studentList.get(i)).getq1();
                minimum[1] = ((StudentDetails) studentList.get(i)).getq2();
                minimum[2] = ((StudentDetails) studentList.get(i)).getq3();
                minimum[3] = ((StudentDetails) studentList.get(i)).getq4();
                minimum[4] = ((StudentDetails) studentList.get(i)).getmid1();
                minimum[5] = ((StudentDetails) studentList.get(i)).getmid2();
                minimum[6] = ((StudentDetails) studentList.get(i)).getfin();
            }
        }
        System.out.printf("Average     ");
        for (int i = 0; i < average.length; i++) {
            System.out.printf("%.2f      ", average[i] / studentList.size());
        }

        for (int i = 0; i < studentList.size(); i++) {
            minimum[0] = (minimum[0] > ((StudentDetails) studentList.get(i)).getq1())
                    ? ((StudentDetails) studentList.get(i)).getq1()
                    : minimum[0];
            minimum[1] = (minimum[1] > ((StudentDetails) studentList.get(i)).getq2())
                    ? ((StudentDetails) studentList.get(i)).getq2()
                    : minimum[1];
            minimum[2] = (minimum[2] > ((StudentDetails) studentList.get(i)).getq3())
                    ? ((StudentDetails) studentList.get(i)).getq3()
                    : minimum[2];
            minimum[3] = (minimum[3] > ((StudentDetails) studentList.get(i)).getq4())
                    ? ((StudentDetails) studentList.get(i)).getq4()
                    : minimum[3];
            minimum[4] = (minimum[4] > ((StudentDetails) studentList.get(i)).getmid1())
                    ? ((StudentDetails) studentList.get(i)).getmid1()
                    : minimum[4];
            minimum[5] = (minimum[5] > ((StudentDetails) studentList.get(i)).getmid2())
                    ? ((StudentDetails) studentList.get(i)).getmid2()
                    : minimum[5];
            minimum[6] = (minimum[6] > ((StudentDetails) studentList.get(i)).getfin())
                    ? ((StudentDetails) studentList.get(i)).getfin()
                    : minimum[6];
            maximum[0] = (maximum[0] < ((StudentDetails) studentList.get(i)).getq1())
                    ? ((StudentDetails) studentList.get(i)).getq1()
                    : maximum[0];
            maximum[1] = (maximum[1] < ((StudentDetails) studentList.get(i)).getq2())
                    ? ((StudentDetails) studentList.get(i)).getq2()
                    : maximum[1];
            maximum[2] = (maximum[2] < ((StudentDetails) studentList.get(i)).getq3())
                    ? ((StudentDetails) studentList.get(i)).getq3()
                    : maximum[2];
            maximum[3] = (maximum[3] < ((StudentDetails) studentList.get(i)).getq4())
                    ? ((StudentDetails) studentList.get(i)).getq4()
                    : maximum[3];
            maximum[4] = (maximum[4] < ((StudentDetails) studentList.get(i)).getmid1())
                    ? ((StudentDetails) studentList.get(i)).getmid1()
                    : maximum[4];
            maximum[5] = (maximum[5] < ((StudentDetails) studentList.get(i)).getmid2())
                    ? ((StudentDetails) studentList.get(i)).getmid2()
                    : maximum[5];
            maximum[6] = (maximum[6] < ((StudentDetails) studentList.get(i)).getfin())
                    ? ((StudentDetails) studentList.get(i)).getfin()
                    : maximum[6];
        }
        System.out.printf("\nMinimum     ");
        for (int i = 0; i < minimum.length; i++) {
            System.out.printf(minimum[i] + "         ");
        }
        System.out.printf("\nMaximum     ");
        for (int i = 0; i < maximum.length; i++) {
            System.out.printf(maximum[i] + "        ");
        }
        pressEnterKeyToContinue();
    }

    /*
     * No parameters passed Returns true when user
     * presses enter and the program ends
     */
    public boolean pressEnterKeyToContinue() {
        System.out.println("\nPress Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
        return true;
    }

    /*
     * No parameters passed 
     */
    public void doCleanUp() {
        //cleanup done after any resource is opened within that method itself
    }
}
