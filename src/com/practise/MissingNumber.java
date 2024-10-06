package com.practise;

public class MissingNumber {

	public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5,7,6,8 };
        int n = arr.length;
        System.out.println(missingNumber(n, arr));
	}
	
	public static int missingNumber(int n, int[] arr)
    {
        int sum = 0;

        // Calculate the sum of array elements
        for (int i = 0; i < n ; i++) {
            sum += arr[i];
        }

        // Calculate the expected sum
        int expectedSum = ((n+1) * (n+2)) / 2;

        // Return the missing number
        return expectedSum - sum;
    }

}
