package niuketest;

public class Solution {
	  public int findKthNum(int[] arr1, int[] arr2, int kth) {
		  int n=0;
		  int count=kth;
		  int a1,a2;
		  int i=0,j=0;
		  while(true){
			  if(i<arr1.length){
				  a1=arr1[i];
			  }else{
				  a1=100000;
			  }
			  if(j<arr2.length){
				  a2=arr2[j];
			  }else{
				  a2=1000000;
				  }
			 if(a1<a2){
				 i++;
			 }else{
				 j++;
			 }
			 count--;
			 if(count==0){
				 n=a1>a2?a1:a2;
				 break;
			 }
			  
		  }
		  return n;
	  }

}
