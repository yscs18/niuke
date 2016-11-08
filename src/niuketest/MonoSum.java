package niuketest;

public class MonoSum {
	public int calcMonoSum(int[] A,int n){
		int sum=0;
		int[] a=new int[500];
		for(int i=0;i<n;i++){
			if(A[i]>0){
				a[A[i]]++;
			}
		}
		return sum;
	}

}
