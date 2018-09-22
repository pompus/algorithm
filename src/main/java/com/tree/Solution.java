package com.tree;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {

		int A=4;
		int K=5;
		int P=1;
		
		String a="{}{)";
		Solution s= new Solution();
		System.out.println(s.isBalanced(a));
	}
	
	boolean isBalanced (String st) {
		Stack<Character> s=new Stack<>();		
		for (int i=0; i<st.length();i++) {
			char t=st.charAt(i);
			
			if (t=='{' || t=='(' || t=='[') {
				s.push(t);
			}
			else if (t=='}') {
				if (s.isEmpty())
					return false;
				char k =s.pop();
				if (k!='{') {
					return false;
				}
			}
			else if ( t==')') {
				if (s.isEmpty())
				return false;
				char k =s.pop();
				if (k!='(') {
					return false;
				}
			}
			else if ( t==']') {
				if (s.isEmpty())
				return false;
				char k =s.pop();
				if (k!='[') {
					return false;
				}
			}
		
		}		
		if (s.isEmpty()) {
			return true;
		}		
		return false;
	}
	
	

	private static String smallestString(List<String> substrings) {
		String array[]=new String[substrings.size()];
		for (int i=0; i< substrings.size();i++) {
			array[i]=substrings.get(i);
		}
		int i,j;
		for (i=0; i< substrings.size(); i++) {
			for (j=i+1; j< substrings.size();j++) {
				if ( (array[i]+array[j]).compareTo(array[j]+array[i]) > 0) {
					String t=array[i];
					array[i]=array[j];
					array[j]=t;
				}
			}
		}
		
		
		String result=""; 
		for (i=0; i< array.length;i++) {
			
			result= result+array[i];
		}
		return result;
	}
}
