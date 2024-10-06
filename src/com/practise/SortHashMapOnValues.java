package com.practise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHashMapOnValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1,500);
		map.put(2,200);
		map.put(4,600);
		map.put(5,400);
		map.put(3,100);
		
		Map<Integer,Integer> mp = map.entrySet().stream().sorted((a,b)->a.getValue().compareTo(b.getValue())).
		collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(s,d)->s,LinkedHashMap::new));
		for(Map.Entry<Integer,Integer> m:mp.entrySet()) {
			System.out.println(m.getValue());
		}
		
	}

}
