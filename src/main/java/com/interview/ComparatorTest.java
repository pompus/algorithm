package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Merit List
subject Codingcasino 100 points
DESCRIPTION
 Hagrid is the teaching assistant of Wizardry-101 in Hogwarts. There are T students who registered in this semester for the course. 
 
Each student's data has following comma separated things: 
 <student_name>,<roll_no>,<mark> , where 
1. <student_name>: can contain one or many space separated tuples having English lowercase/uppercase letters. for example "Luna" and "George Weasley" (spaces can be more than one) 
2. <roll_no>: unique positive integer of at most six digits. 
3. <marks>: marks of student in the first quiz, can be non-negative integer of at most two digits. 

After first quiz, he wants to create a merit list of students. 
Merit list will be based on decreasing order of <marks> of the students. If two students have same marks, then tie will be broken on <student_name>. 
Student whose name occur first in the dictionary (lexicographic order), will be above in merit list. 
If two students have same <student_name>, then student with smaller <roll_no> with be above in merit list. 

Being complex problem with large data, Hagrid offers you a course in Hogwarts, if you write a program to solve this task.    

Given data of T students, your task is to prepare merit list and print list in the format: roll_no, student_name i.e. for each student in merit list from top to bottom, print roll_no, then space, then student_name. 

Input
First line has T, number of students. 
Then for next T lines, each has a student's data in the format specified in the problem. 
 
Output
Print merit list in the given format 
 
Constraints
1<= T <=50 

Sample Test Cases

Input
3 
Luna, 356, 35 
Ron weasley, 289, 35 
hermione granger, 533, 36
  
Output
533 hermione granger 
356 Luna 
289 Ron weasley 
 Explanation
"hermione granger" has highest marks. Then "Luna" and "Ron weasley" have same marks, but "Luna" occurs before "Ron weasley", lexicographically. So "Luna" is second. 
EXECUTION TIME LIMIT
Default.
 *
 */
class check implements Comparable<check> {
	public int roll, marks;
	public String name;

	public check(String name, int roll, int marks) {
		this.name = name;
		this.roll = roll;
		this.marks = marks;
	}

	public String print() {
		return (roll + " " + name);
	}

	public int compareTo(check o) {
		check object = null;
		if (o != null && o instanceof check) {
			object = (check) o;
			if (this.marks > object.marks) {
				return -1;
			} else if (this.marks < object.marks) {
				return 1;
			} else if (this.name.compareTo(object.name) == 0) {
				return this.roll > object.roll ? 1 : -1;
			} else {
				return this.name.compareTo(object.name);
			}
		}
		return 0;
	}
}

public class ComparatorTest {
	public static void main(String[] args) throws java.lang.Exception {
		List<check> records = new ArrayList<check>();
		records.add(new check("Luna", 356, 35));
		records.add(new check("Luna", 289, 35));
		records.add(new check("hermione granger", 533, 36));
		Collections.sort(records);
		for (int i = 0; i < records.size(); i++)
			System.out.println(records.get(i).print());
	}
}