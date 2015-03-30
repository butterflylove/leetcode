package practice;

import java.util.HashMap;

public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
        int[] a=new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
        	if((target%2==0)&&(numbers[i]==target/2)){
        		Integer nn=hm.get(numbers[i]);
        		if(nn!=null){
        			a[0]=++nn;
        			a[1]=(i+1);
        			return a;
        		}
        	}
        	Integer n=hm.get(numbers[i]);
        	if(n==null) {
        		hm.put(numbers[i], i);
        		n=i;
        		System.out.println("====="+hm.get(numbers[i]));
        	}
        	Integer x=hm.get(target-numbers[i]);
        	if((x!=null)&&(x<n)){
        		n++;
        		x++;
        		a[0]=x;
        		a[1]=n;
        		break;
        	}
        }
        return a;
    }
	public static void main(String[] args){
		int[] a={0,4,3,0};
		twoSum(a,0);
	}
}
