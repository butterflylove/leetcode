package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
	static List<String> al = new ArrayList<String>();
	static String[] str={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
    	if(digits.length()<1||digits==null) return al;
    	fun(0,digits.length(),digits,"");
    	return al;
    }
    
    public static void fun(int depth,int max,String s,String ans){
    	if(depth==max){
    		al.add(ans);
    		return;
    	}
    	int num=Integer.parseInt(s.charAt(depth)+"");
    	for(int i=0;i<str[num].length();i++){
    		fun(depth+1,max,s,ans+str[num].charAt(i));
    	}
    }
    public static void main(String[] args){
    	letterCombinations("3");
		System.out.println(al);
	}
    
}
