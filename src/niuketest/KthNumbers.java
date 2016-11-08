package niuketest;

import java.util.Arrays;
import java.util.Random;

public class KthNumbers {
	 public int[] findKthNumbers(int[] A, int n, int k) {
	        // write code here
//		 int[] a=new int[k];
//		 int[] b=new int[1000];		 
//		 int count=0;
//		 for(int i=0;i<A.length;i++){
//			 b[A[i]]=i+1;
//		 }
//		 for(int j=0;j<b.length;j++){
//			 if(b[j]==0&&j!=0){
//				 continue;
//			 }else{
//			 a[count++]=b[j];
//			 if(count>=k){
//				 break;
//			 }
//			 }
//		 }
//		 return a;
		 int[] a=new int[k];
		 int[] b=new int[1000];		 
		 int count=0;
		 for(int i=0;i<A.length;i++){
			 b[A[i]]=i;
		 }
		 for(int j=0;j<b.length;j++){
			 if(b[j]==0){
				 continue;
			 }else{
			 a[count++]=b[j];
			 if(count>=k){
				 break;
			 }
			 }
			 
		 }
		 Arrays.sort(a); 
		 for(int j=0;j<a.length;j++){
			 	
			 a[j]=A[a[j]];
		 } 
		 return a;
	    }
	 public static void main(String args[]){
		 int[] A=new int[20];
		 Random a=new Random();
		 for(int i=0;i<20;i++){
			 A[i]=a.nextInt(100);
			 System.out.print(A[i]+" ");
			
		 }
		 System.out.println(" ");
		 KthNumbers k=new KthNumbers();
		 k.findKthNumbers(A, 20, 1);
		 
	 }

}
