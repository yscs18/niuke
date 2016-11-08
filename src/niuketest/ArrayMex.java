package niuketest;

import java.util.Random;

public class ArrayMex {
	public int findArrayMex(int[] A,int n){
		int min=0;
		int[] a = new int[1000];
		for(int i=0;i<n;i++){
			if(A[i]>0){
				a[A[i]]=1;
			}	
		}
		for(int i=0;i<a.length-1;i++){
			if(a[i]!=1&&i!=0){
				min=i;
				break;
			}
		}
		return min;
	}
	public static void main(String args[]){
		ArrayMex ms=new ArrayMex();
		int[] A=new int[100];
		for(int i=0;i<100;i++){
			Random ra=new Random(3);
			A[i]=ra.nextInt(100);
			System.out.print(A[i]+" ");
		}
		System.out.println("ArrayMex.main()");
		System.out.println(ms.findArrayMex(A,100));
	}

}
