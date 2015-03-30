package practice;

import java.util.Arrays;

public class ThreeClosest {
    public static int threeSumClosest(int[] num, int target) {
        if(num==null||num.length<3) return 0;
        Arrays.sort(num);
        int cha=Math.abs(target-(num[0]+num[1]+num[2]));
        int result=num[0]+num[1]+num[2];
        int n=num.length;
        for(int i=0;i<num.length-2;i++){
        	int x=num[i];
        	int p=i+1;
        	int q=n-1;
        	while(p<q){
        		if((x+num[p]+num[q])<target){
        			if(Math.abs(target-(x+num[p]+num[q]))<cha){
        				//update the result
        				cha=Math.abs(target-(x+num[p]+num[q]));
        				result=x+num[p]+num[q];
        				if(result==target)
        					return target;
        			}
        			p++;
        		}else{
        			if(Math.abs(target-(x+num[p]+num[q]))<cha){
        				//update the result
        				cha=Math.abs(target-(x+num[p]+num[q]));
        				result=x+num[p]+num[q];
        				if(result==target)
        					return target;
        			}
        			q--;
        		}
        	}
        	
        }
        return result;
    }
    
    public static void main(String[] args){
    	int[] a={-1,2,1,-4};
    	
    	System.out.println(threeSumClosest(a, 1));
    }
}
