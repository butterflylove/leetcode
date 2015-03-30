package practice;

public class Median {
	public static double findKth(int[] A,int startA,int m,int[] B,int startB,int n,int k){
		if(m>n) return findKth(B,startB,n,A,startA,m,k);
		if(m==0) return B[startB+k-1];
		if(k==1) return Math.min(A[startA], B[startB]);
		int pa=Math.min(k/2, m);
		int pb=k-pa;
		if(A[startA+pa-1]<B[startB+pb-1])
			return findKth(A, startA+pa, m-pa, B, startB, n, k-pa);
		else
			return findKth(A, startA, m, B, startB+pb, n-pb, k-pb);
	}
	
    public static double findMedianSortedArrays(int A[], int B[]) {
        int m=A.length;
        int n=B.length;
        int k=m+n;
        if(k%2==1){
        	return findKth(A, 0, m, B, 0, n, k/2+1);
        }else{
        	return (findKth(A, 0, m, B, 0, n, k/2)+findKth(A, 0, m, B, 0, n, k/2+1))/2.0;
        }
    }
    
    public static void main(String[] args){
    	int[] A={1,2};
    	int[] B={1,2};
    	System.out.println(findMedianSortedArrays(A, B));
    }
}
