package com.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author HP PC
 * 
 * this assumes value is Integer, if value is String or custom object, say Employee,
 * different comparator or comparable need to be used
 *
 */
public class SortMapByValue {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);
        
        sortMapByValues(map);
	}

	private static void sortMapByValues(Map<String, Integer> map) {
		Set<Map.Entry<String, Integer>> set=map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o1.getValue()).compareTo( o2.getValue());
            }
        } );
        
        System.out.println(list);
	}
}
