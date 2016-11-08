package niuketest;

public class MaxDivision {
	public int findMaxDivision(int[] A, int n) {
        // write code here
		int max=0;
		int a;
		int low=0,heigh=n-1;
		quickSort( A, low, heigh);
		max=A[1]-A[0];
		for(int i=1;i<n-1;i++){
			if(max<(A[i+1]-A[i])){
				max=A[i+1]-A[i];
			}
		}
		return max;
    }
	void  quickSort(int A[],int low,int heigh){
		if(low<heigh){
			int key=A[low];
			int low1=low;
			int heigh1=heigh;
			while(low1<heigh1){
				while(low1<heigh1&&A[heigh1]>key){
					heigh1--;
					
				}
				while(low1<heigh1&&A[low]<key){
					low1++;
				}
				A[heigh1]=A[low1];
				
			}
			A[low1]=key;
			quickSort( A, low, low1-1);
			quickSort( A, low1+1, heigh);
		}
		
	}
	 public int findMaxDivision1(int[] A, int n) {
	      // write code here
		 int  max=0;
		 for(int i=0;i<n;i++){
			 for(int j=0;j<n-i;j++){
				 int x;
				 if(A[i]>A[j]){
					 x=A[i];
					 A[i]=A[j];
					 A[j]=x;
				 }
			 }			 
		 }
		 for(int i=0;i<n-1;i++){
			 if(max<A[i+1]-A[i]){
				 max=A[i+1]-A[i];
			 }
		 }
		 return max;
			
		}

}
