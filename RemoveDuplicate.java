package practice;

public class RemoveDuplicate {
    public int removeDuplicates(int[] A) {
    	if(A==null||A.length<1) return 0;
        int start = 1;
        for(int i=1;i<A.length;i++){
        	if(A[i]!=A[start-1]){
        		A[start++]=A[i];
        	}
        }
        return start;
    }
}
