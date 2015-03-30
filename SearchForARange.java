package practice;

public class SearchForARange {
    public static int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = binarySearch(A, 0, A.length-1, target, true);
        result[1] = binarySearch(A, 0, A.length-1, target, false);
        return result;
    }
    public static int binarySearch(int[] A,int left,int right,int target,boolean isleft){
    	if(left>right) return -1;
    	int m=(left+right)/2;
    	if(target==A[m]){
    		if(isleft){
    			if(m==0||A[m-1]<target) return m;
    			else return binarySearch(A, left, m-1, target, isleft);
    		}else{
    			if(m==(A.length-1)||A[m+1]>target) return m;
    			else return binarySearch(A, m+1, right, target, isleft);
    		}
    	}else{
    		if(target<A[m]){
    			return binarySearch(A, left, m-1, target, isleft);
    		}else{
    			return binarySearch(A, m+1, right, target, isleft);
    		}
    	}
    }
    
    public static void main(String[] args){
    	int[] A={2,2};
    	System.out.println(searchRange(A, 2)[0]+" "+searchRange(A, 2)[1]);
    }
}
