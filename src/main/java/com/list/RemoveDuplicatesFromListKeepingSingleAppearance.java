package com.list;

import java.util.Collections;
import java.util.LinkedList;

public class RemoveDuplicatesFromListKeepingSingleAppearance {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(6);
		list.add(2);
		list.add(1);
		list.add(6);
		removeDuplicates(list);
	}

	private static void removeDuplicates(LinkedList<Integer> list) {
		// sort to get same element consecutively
		Collections.sort(list);
		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			int e = list.get(i);
			while (i + 1 < list.size()) {
				int k = list.get(i + 1);
				if (e == k) {
					//if we use remove(index) or remove(object) then sometimes object /index is used which cause error
					// dont use ArrayList or pass List as an interface as they dont have removeFirstOccurrence method
					list.removeFirstOccurrence(e);
				}
				else {
					break;// go to the for loop to check the next unique element
				}
			}
		}
		System.out.println(list);
	}
}
