package niuketest;

import java.util.Arrays;
import java.util.Random;

public class MaxGap {
	 public int findMaxGap(int[] A, int n) {
		 int[] b = new int[n];
			int min=n;
			for(int i=0;i<n;i++){
				b[i]=A[i];
			}
			Arrays.sort(b);
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				if(A[i]==b[i]){
					a[i]=1;
				}
			}
			for(int i=0;i<n;i++){
				int count=0;
				while(a[i]==0){
					count++;
					i++;
					if(i>=n){
						break;
					}
				}
				if(count<min){
					min=count;
				}
			}
			return min;
	    }
		public static void main(String args[]){
			MaxGap ms=new MaxGap();
			int[] A=new int[10];
			for(int i=0;i<10;i++){
				Random ra=new Random(); 
				
				
				
				A[i]=ra.nextInt(100);
				System.out.print(A[i]+" ");
			}
			System.out.println();
			System.out.println(ms.findMaxGap( A,10));
		}

}
