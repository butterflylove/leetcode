package practice;

import java.util.HashMap;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s.length()==1) return s.length();
        int pre=0,result=1;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        char[] xx = s.toCharArray();
        hm.put(xx[0], 0);
        for(int i=1;i<xx.length;i++){
        	Integer temp=hm.get(xx[i]);
        	if(temp==null||temp<pre){
        		//不存在
        		hm.put(xx[i], i);
        		result=result>(i-pre+1)?result:(i-pre+1);
        	}else{
        		//已存在
         		result=result>(i-pre)?result:(i-pre);
        		pre=hm.get(xx[i])+1;
        		hm.put(xx[i], i);
        	}
        }
        return result;
    }
    public static void main(String[] args){
    	System.out.println(lengthOfLongestSubstring("eee"));
    }
}
