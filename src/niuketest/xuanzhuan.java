package niuketest;

public class xuanzhuan {
	 public int[] clockwisePrint(int[][] mat, int n, int m) {
	        // write code here
		 int[] a=new int[n*m];
		 int count=0;
		 int c,flag=0;
		 if(n%2==0){
			 c=n/2;
		 } else{
			 c=n/2+1;
		 }
		 for(int i=0;i<c;i++){
	    		for(int j=i;j<m-i;j++){	   
	    			  if(count>=m*n){
	                  	count--;
	                  }
	    			a[count++]=mat[i][j];
	    			if(count==m*n){
	    				return a;
	    		}
	    		}
	    		for(int j=i+1;j<n-i;j++){
	    			  if(count>=m*n){
		                  	count--;
		                  }
	    			a[count++]=mat[j][m-i-1];
    			if(count==m*n){
    				return a;
    			}
	    		}
	    		for(int j=i+1;j<m-i;j++){
	    			if(count>=m*n){
	                	count--;
	                }
	    			a[count++]=mat[n-1-i][m-j-1];
	    			if(count==m*n){
	    				return a;
	    		}}
	    		for(int j=i+1;j<n-i-1;j++){
                if(count>=m*n){
                	count--;
                }
	    			a[count++]=mat[n-j-1][i];
	    			if(count==m*n){
	    				return a;
	    			}
	    		}
	    	}
		 return a;
	    }
//	    public int[][] rotateMatrix(int[][] mat, int n) {
//	        // write code here
//	    	int[] a=new int[n];
//	    	for(int i=0;i<n/2;i++){
//	    		for(int j=i;j<n-i;j++){
//	    			a[j]=mat[i][j];
//	    		}
//	    		for(int j=i;j<n-i;j++){
//	    			mat[i][j]=mat[n-j-1][i];
//	    		}
//	    		for(int j=i;j<n-i;j++){
//	    			mat[j][i]=mat[n-i-1][j];
//	    		}
//	    		for(int j=i;j<n-i;j++){
//	    			
//	    			mat[n-i-1][j]=mat[n-j-1][n-i-1];
//	    		}
//	    		for(int j=i;j<n-i;j++){
//	    			mat[j][n-i-1]=a[j];
//	    		}
//	    	}
//	    	
//	    	return mat;
//	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat=new int[300][300];
		int count=0;
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				mat[i][j]=++count;
			}
		}
		
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				System.out.print(mat[i][j]+"  ");
				
			}
			System.out.println();
		}
		System.out.println();
		xuanzhuan xu=new xuanzhuan();
		int[] a=new int[100];
		a=xu.clockwisePrint(mat, 6, 3);
		for(int i=0;i<6*3;i++){
			System.out.print(a[i]+" ");
			}
			System.out.println();
		}
	   

	}
