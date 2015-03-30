package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Combination {
	public static Map<Integer,Integer> hm = new HashMap<Integer, Integer>();
	
	public static List<List<Integer>> li = new ArrayList<List<Integer>>();
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int i=0;i<candidates.length;i++){
        	hm.put(candidates[i], i);
        }
        List<Integer> listx = new ArrayList<Integer>();
        goback(0,listx,target,candidates);
        return li;
        
    }
    
    public static void goback(int sum,List<Integer> x,int target,int[] candidates){
    	if(sum==target) {
    		if(!li.contains(x)){
    			li.add(x);
    		}
    		//System.out.println(x);
    		return;
    	}
    	else if(sum<target) {
    		int index;
    		if(sum==0){
    			index=0;
    		}else{
    			int last=x.get(x.size()-1);
        		index=hm.get(last);
    		}
    		for(int i=index;i<candidates.length;i++){
    			List<Integer> list = null;
    			if(sum==0){
    				list = new ArrayList<Integer>();
    			}else{
    				list = new ArrayList<Integer>(x);
    			}
    			list.add(candidates[i]);
    			int temp=0;
    			for(int j=0;j<list.size();j++){
    				temp+=list.get(j);
    			}
    			goback(temp, list, target, candidates);
    		}
    	}
    	return;
    }
    
    public static void main(String[] args){
    	int[] x={1};
    	System.out.println(combinationSum(x,  2));
    }
}
