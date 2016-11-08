package niuketest;

import java.util.Arrays;

public class ShortSubsequence {
	public int findShortest(int[] A, int n) {
        // write code here
		int[] b=new int[n];
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
			}
			if(count<min){
				min=count;
			}
		}
		return min;
    }

}
