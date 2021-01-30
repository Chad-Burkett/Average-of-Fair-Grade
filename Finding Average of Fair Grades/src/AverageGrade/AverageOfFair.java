package AverageGrade;

import java.util.Scanner;

public class AverageOfFair {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      int m, n; // initialize m and n
      m = 5; // student row
      n = 6; // grade column

      // your solution
   // make an array to hold # of students and grades
      double grades[][] = 							// students
    	  				   { {70, 80, 90, 90, 92, 96},  // 0
							 {80, 80, 80, 80, 34, 45},	// 1
							{10, 20, 100, 70, 67, 77},	// 2	
							{60, 60, 60, 90, 99, 22},	// 3
						  {100, 100, 60, 60, 90, 90} };	// 4
    		  	// grades   0    1   2   3    4   5  

      // read in the grades
      for (int i = 0; i < grades.length; i++) { // stop for loop when m = input for m
         for (int j = 0; j < grades[i][0]; j++) { // stop for loop when n = input for n
            //grades[i][j] = stdin.nextDouble(); //store the array
         }
      }

      // compute to see if a [column](grade) is fair
      boolean[] fairGrade = new boolean[n]; // boolean for giving "alarm" if grade is not fair
      int fairGradeCnt = 0; // set fair grade to default value of0

      for (int column = 0; column < n; column++) { // loop for each column to set the min and max
         double min, max;
         min = max = grades[0][column]; // set min and max to a default array which is row 0 and [n]

         for (int student = 1; student < m; student++) { // loop for each column starting at 1 to find max
            if (grades[student][column] > max) { // if statement to find max if certain [student][column] is larger than default
               max = grades[student][column]; // set max to certain [row](student)[column](grade)
            }

            if (grades[student][column] < min) { // if statement to find min
               min = grades[student][column]; // set min to certain [row][column]
            }
         }

         // find the min and max
         fairGrade[column] = (max - min <= 50); // set the fairGrade to less than or equal to 50
         if (fairGrade[column]) { // if a fairGrade is found in a [column] then
            fairGradeCnt++; // increment fairGradeCnt by 1
         }
      }

      for (int student = 0; student < m; student++) { // for loop to loop through each student or m
         double total = 0; // set total to default value of 0

         for (int column = 0; column < n; column++) { // for loop to loop through each column to find if grade is far
            if (fairGrade[column]) { // if there is a grade that is categorized as fair
               total += grades[student][column]; // then add the grades at specific student and column to the total
            }
         }
                 
      System.out.println("Student " + student + "'s average grade is: " + total / fairGradeCnt);
         //System.out.println(total / fairGradeCnt); // output the average for each student
      }

      stdin.close();
   }

} // end of AverageOfFair.java
