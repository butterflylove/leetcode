package practice;

import java.util.ArrayList;
import java.util.List;

public class Valid {
    public boolean isValid(String s) {
        List<Character> li = new ArrayList<Character>();
        char[] myArray=s.toCharArray();
        try{
	        for(int i=0;i<myArray.length;i++){
	        	if(myArray[i]=='('||myArray[i]=='['||myArray[i]=='{'){
	        		li.add(myArray[i]);
	        	}
	        	else{
	        		char temp=li.remove(li.size()-1);
	        		if(myArray[i]==')'){
	        			if(temp!='(') return false;
	        		}else if(myArray[i]==']'){
	        			if(temp!='[') return false;
	        		}else if(myArray[i]=='}'){
	        			if(temp!='{') return false;
	        		}
	        	}
	        }
	        if(li.size()!=0) return false;
	        else return true;
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }
    }
}
