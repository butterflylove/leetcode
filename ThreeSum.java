package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> al = new ArrayList<List<Integer>>();
        if(num==null||num.length<3) return al;
        Arrays.sort(num);
        int n=num.length;
        for(int i=0;i<n-2;i++){
        	int x=-num[i];
        	int p=i+1;
        	int q=n-1;
        	while(p<q){
        		if((num[p]+num[q])<x){
            		p++;
            	}else if((num[p]+num[q])>x){
        			q--;
        		}else{
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(num[x]);
        			list.add(num[p]);
        			list.add(num[q]);
        			al.add(list);
        			p++;
        			q--;
        			while(p<n-1&&num[p]==num[p-1]){
        				p++;
        			}
        			while(q>i+1&&num[q]==num[q+1]){
        				q--;
        			}
        		}
        		while(i<n-2&&num[i]==num[i+1]){
        			i++;
        		}
        	}
        	
        }
        return al;
    }
}
