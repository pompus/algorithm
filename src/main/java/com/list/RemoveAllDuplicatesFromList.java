package com.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RemoveAllDuplicatesFromList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(6);
		list.add(2);
		list.add(1);
		list.add(8);
		list.add(9);
		list.add(6);
		removeDuplicates(list);
	}

	private static void removeDuplicates(LinkedList<Integer> list) {
		// sort to get same element consecutively
		Collections.sort(list);
		System.out.println(list); //[1, 1, 1, 2, 2, 6, 6, 8, 9]

		for (int i = 0; i < list.size(); i++) {
			//element for which duplicate need to be found
			int e = list.get(i);
			while (i + 1 < list.size()) {
				int k = list.get(i + 1);
				if (e == k) {
					List<Integer> l = new LinkedList<>();
					l.add(e);
					list.removeAll(l);
					//here we need to start with 0 as all 1 is removed
					--i;
					break;
				} else {
					break;// go to the for loop to check the next unique element
				}
			}
		}
		System.out.println(list);//[8, 9]
	}
}
