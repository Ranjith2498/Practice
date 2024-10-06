package com.practise.stack;
import java.util.*;
public class NGE {
	public static void main(String[] args) {
		
//        int arr[] = {4,5,3,2,11};
//		Stack s = new Stack<Integer>();
//		
//		s.push(arr[0]);
//		
//		for(int i=1;i<arr.length;i++)
//		{
//			int next = arr[i];
//			
//			int element = (int) s.pop();
//			System.out.println(element);
//			while(element<next)
//			{
//				System.out.println("cur -> "+element +"  next -> "+next);
//				if(s.isEmpty())
//				{
//					break;
//				}
//				
//				element = (int) s.pop();
//				System.out.println(element);
//			}
//			
//			if(element>next)
//			{
//				s.push(element);
//			}
//			
//			s.push(next);	
//		}
//		
//		while (!s.isEmpty())
//		{
//			System.out.println("cur -> "+s.pop() +"  next -> "+"-1");
//		}
		
		
	    
	        int arr[] = new int[]{1, 4, 2, 17, 9, 12};
	        int ans[] = nextGreaterElement(arr, arr.length);
	        for(int e : ans){
	            System.out.print(e+" ");
	        }
	}
	// This function will find the next greater element for each 
    // element
    public static int[] nextGreaterElement(int arr[], int n)
    {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        
        // Iterate over the given array
        for(int i = n - 1; i>= 0; i--){
            
            // While stack is not empty and the current
            // element is greater than the top of the
            // stack, keeping removing the top of the stack
            while(!st.isEmpty() && arr[i] >= st.peek()){
            	System.out.println(st.pop());
            }
            
            // If the stack is empty, then it mean there is no next greater
            // element for this element
            if(st.isEmpty()){
                ans[i] = -1;
            } 
            // Otherwise, the top of the stack is the next greater
            // element for this element
            else {
                ans[i] = st.peek();
            }
            
            // Push the current element to the stack
            st.push(arr[i]);
        }
        return ans;
    }

}
	
	