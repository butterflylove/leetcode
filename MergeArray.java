package practice;

public class MergeArray {
	 public void merge(int A[], int m, int B[], int n) {
		 int flagA=m-1;
		 int flagB=n-1;
		 int flagX=m+n;
		 while(flagX>0){
			 if((flagA>-1)&&(flagB>-1)){
				 if(A[flagA]>=B[flagB]){
					 A[--flagX]=A[flagA];
					 flagA--;
				 }else{
					 A[--flagX]=B[flagB];
					 flagB--;
				 }
			 }else if(flagA==-1){
				 A[--flagX]=B[flagB];
				 flagB--;
			 }else if(flagB==-1){
				 A[--flagX]=A[flagA];
				 flagA--;
			 }
		 }
	 }
}
