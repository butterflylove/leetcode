package practice;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] num) {
    	if(num.length<2||num==null) return;
        int i=num.length-2;
        try {
        	while(i>=0&&num[i]>=num[i+1]){
            	i--;
            }
        	if(i==-1){
        		reverse(num,0,num.length-1);
        		return;
        	}else{
        		int index=num.length-1;
        		while(num[index]<=num[i]){
        			index--;
        		}
        		int temp=num[index];
        		num[index]=num[i];
        		num[i]=temp;
        		reverse(num,i+1,num.length-1);
        	}
		} catch (Exception e) {
			// TODO: 数组越界
			
		}
        
    }
    
    public static void reverse(int[] A,int x,int y){
    	if(A==null||A.length<1||(y-x)<1) return ;
    	int i=x,j=y;
    	while(i<j){
    		int temp=A[i];
    		A[i]=A[j];
    		A[j]=temp;
    		i++;
    		j--;
    	}
    }
}
