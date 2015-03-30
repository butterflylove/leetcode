package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> al = new ArrayList<List<Integer>>();
    	Map<List<Integer>,Integer> myMap = new HashMap<List<Integer>, Integer>();
    	if(num==null||num.length<4){
        	return al;
        }
    	Map<Integer,List<Integer>> hm = new HashMap<Integer, List<Integer>>();
    	for(int i=0;i<num.length;i++){
    		for(int j=i+1;j<num.length;j++){
    			int tem=num[i]+num[j];
    			if(!hm.containsKey(tem)){
    				List<Integer> li = new ArrayList<Integer>();
    				li.add(i);
    				li.add(j);
    				hm.put(tem, li);
    			}else{
    				List<Integer> li = hm.get(tem);
    				li.add(i);
    				li.add(j);
    				hm.put(tem, li);
    			}
    		}
    	}
    	
    	for(int i=0;i<num.length;i++){
    		for(int j=i+1;j<num.length;j++){
    			int x=target-num[i]-num[j];
    			if(hm.containsKey(x)){
    				List<Integer> li = hm.get(x);
        			int size=li.size()/2;
        			for(int k=0;k<size;k++){
        				int a=li.get(k*2);
        				int b=li.get(k*2+1);
        				if(isSame(a, b, i, j)&&a<i&&b<i){   //四个数字没有重复
        					List<Integer> xxx=new ArrayList<Integer>();
        					xxx.add(num[a]);
        					xxx.add(num[b]);
        					xxx.add(num[i]);
        					xxx.add(num[j]);
        					Collections.sort(xxx);
        					if(!myMap.containsKey(xxx)){
        						myMap.put(xxx, 1);
        						al.add(xxx);
        					}
        				}
        			}
    			}   			
    		}
    	}
    	
    	
    	return al;
    	
    }
    
    static boolean isSame(int a,int b,int c,int d){
    	if(a==c) return false;
    	else if(a==d) return false;
    	else if(b==c) return false;
    	else if(b==d) return false;
    	else return true;
    }
    
    public static void main(String[] args){
    	int[] a={2,1,0,-1};
    	System.out.print(fourSum(a, 2));
    }
}
