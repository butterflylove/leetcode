package practice;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Regular {
    public static boolean isMatch(String s, String p) {
        if(p.length()==0)
        	return s.length()==0;
        else if(p.length()==1){
        	if(s.length()==0)
        		return false;
        	else if((s.charAt(0)!=p.charAt(0))&&(p.charAt(0)!='.')){
        		return false;
        	}else{
        		return isMatch(s.substring(1), p.substring(1));
        	}
        }else if(p.charAt(1)!='*'){
        	if(s.length()==0)
        		return false;
        	else if((s.charAt(0)!=p.charAt(0))&&(p.charAt(0)!='.'))
        		return false;
        	else
        		return isMatch(s.substring(1), p.substring(1));
        } 
        else{
        	if(isMatch(s, p.substring(2)))
        		return true;
        	int i=0;
        	while(i<s.length()&&(s.charAt(i)==p.charAt(0)||p.charAt(0)=='.')){
        		if(isMatch(s.substring(i+1), p.substring(2)))
        			return true;
        		i++;
        	}
        	return false;
        }
    }
    public static void main(String[] args){
    	System.out.println(isMatch("aaba", "ab*a*c*a"));
	}
}
