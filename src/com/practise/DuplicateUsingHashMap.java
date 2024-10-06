package com.practise;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.HashMap;
public class DuplicateUsingHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Hash Map in java";
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),map.get(s.charAt(i))+1);
			}
			else {
				map.put(s.charAt(i),1);		
			}
//			map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
		}
		
		for(Map.Entry<Character, Integer> mp : map.entrySet()) {
			System.out.println(mp.getKey()+" "+mp.getValue());
		}

	}
}
