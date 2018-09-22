package com.stack;

import java.io.IOException;
import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) throws IOException {
		BalancedParanthesis s = new BalancedParanthesis();
		System.out.println(s.isBalanced("{}()"));
		System.out.println(s.isBalanced("[{()}]"));
		System.out.println(s.isBalanced("{}{)"));
		System.out.println(s.isBalanced("[]("));
	}

	boolean isBalanced(String st) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < st.length(); i++) {
			char t = st.charAt(i);

			if (t == '{' || t == '(' || t == '[') {
				s.push(t);
			} else if (t == '}') {
				if (s.isEmpty())
					return false;
				char k = s.pop();
				if (k != '{') {
					return false;
				}
			} else if (t == ')') {
				if (s.isEmpty())
					return false;
				char k = s.pop();
				if (k != '(') {
					return false;
				}
			} else if (t == ']') {
				if (s.isEmpty())
					return false;
				char k = s.pop();
				if (k != '[') {
					return false;
				}
			}
		}
		if (s.isEmpty()) {
			return true;
		}
		return false;
	}
}
