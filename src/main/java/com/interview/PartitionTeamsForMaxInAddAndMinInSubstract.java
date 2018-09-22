package com.interview;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * Given a list of n players with strengths [s0 , s1, s2 ... sn], create two teams (A & B) of size k (k<=n/2)  

strength(A) = Sum of strength of all players in a team A 
strength(B) = Sum of strength of all players in a team B

Total strength = strength(A)+strength(B)
Diff strength = abs(strength(A)-strength(B))

such that — 
1. Total strength  is maximum.
2. Diff strength is minimum.

In case of same Total strength , select combination with minimum Diff strength

Example 
n = no of total players 
k = team size (k<=n/2)
players= list of player strength space separated

n = 5
k = 2
players   =   4 4 2 2 5
playerIds =   1 2 3 4 5
       
Possible Teams : 
  
CombId [Team1]   [Team2]  Strength    Difference      
1      [1,2]     [3,5]    15          1
2      [1,2]     [4,5]    15          1   
3      [1,3]     [2,5]    15          3
4      [1,4]     [2,5]    15          3
5      [1,3]     [2,4]    12          0
6      [1,4]     [3,2]    12          0
7      [1,4]     [3,5]    13          1       

 combination-1  and 
 combination-2 [1,2][4,5] are winning combinations as their total strength is 15(maximum), while the difference in strength is closest to minimum. Here [ 1, 2] [4, 5] are the player ids.

Hence you designed two equal strength teams.

Input Format
First line will be a string containing player strength as an array of space-separated integers.
Second Line will be a string containing player id's as an array of space-separated integers.
Third line will contain an integer denoting the max number of players in a team.

Output Format
Output will contain winning combination's  Total strength and the Diff strength separated by a space.
total_strength strength_diff

See Sample Input-output for more clarification.

Sample Test Case
Input
4 4 2 2 5
1 2 3 4 5
2

Output
15 1
EXECUTION TIME LIMIT
5 seconds
 *
 */
public class PartitionTeamsForMaxInAddAndMinInSubstract {

	public static void main(String[] args) {
		int s[] = new int[] { 4, 4, 2, 2, 5 ,6, 8, 10, 3, 4, 1, 5};
		int id[] = new int[] { 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12};
		int max = 4;
		printResults(s, id, max);
	}

	private static void printResults(int[] s, int[] id, int max) {

		Map<Integer, Integer> map = new HashMap<>();
		// put in a map for later sorting using value where value in strength[]
		for (int i = 0; i < s.length; i++) {
			map.put(id[i], s[i]);
		}
		// sort using strength in decreasing order as we need to maximize strength
		// on addition of two teams
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		List<Entry<Integer, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o1.getValue() > o2.getValue().intValue() ? -1 : 1;
			}
		});

		int teamA = 0;
		int teamB = 0;
		int i = 0;
		
		// the teams must have strengths from top max*2 elements
		int l = 0;
		int r = max + max - 1;
		
		// in case each team have only one player, then use the top most ones to form team
		if (max == 1) {
			Entry<Integer, Integer> entry = list.get(l++);
			teamA += entry.getValue();
			entry = list.get(l++);
			teamB += entry.getValue();
		} else {
		// in case each team have > one player, then for each team 
		// use the highest and then the lowest available strength
		// this is required to maximize strength on addition and minimize strength on subtraction
			for (i = 0; i < max / 2; i++) {
				Entry<Integer, Integer> entry = list.get(l++);
				teamA += entry.getValue();
				entry = list.get(l++);
				teamB += entry.getValue();
				entry = list.get(r--);
				teamA += entry.getValue();
				entry = list.get(r--);
				teamB += entry.getValue();
			}
		}
		System.out.println(teamA + teamB);
		System.out.println(Math.abs(teamA - teamB));
	}
}
