package com.practise;

public class ArrayMultiply {
	public static void main(String[] args) {
		String a = "Ranjith Tejas Shashank";
		String[] s = a.split(" ");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length;i++) {
			sb.append(new StringBuilder(s[i]).reverse()).append(" ");
		}
		System.out.println(sb.toString().trim());
		

	}
}
