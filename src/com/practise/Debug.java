package com.practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Debug {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int arr[] = {-3,0,1,-3,1,1,1,-3,10,0};
//		boolean res = count(arr,4);
//		System.out.println(res);
		
		 System.out.println("Try programiz.pro");
	        int nums[] = {2,7,11,15}; int target = 9;
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<nums.length;i++){
	            if(map.containsKey(target-nums[i])){
	                System.out.println(map.get(target-nums[i])+","+i);
	            }
	            
	            map.put(nums[i],i);
	        }
	}
	
//	public static boolean count(int arr[],int k) {
//		Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<arr.length;i++){
//            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
//        }
//        Set<Integer> set = new HashSet<>();
//        for(Map.Entry<Integer,Integer> mp:map.entrySet()){
////        	System.out.println(mp.getKey()+" "+mp.getValue());
//        	if(!set.add(mp.getValue())) {
//        		return false;
//        	}
//
//        }
//        return true;
//	}

}
