package practice;

public class MySub {
    public static int strStr(String haystack, String needle) {
    	if(needle == null||needle.length()<1) return 0;
        if(haystack.length()<needle.length()) return -1;
        for(int i=0;i<haystack.length();i++){
        	if(needle.length()>(haystack.length()-i)){
        		return -1;
        	}
        	int k=i;
        	int j=0;
        	while(j<needle.length()&&k<haystack.length()&&haystack.charAt(k)==needle.charAt(j)){
        		j++;
        		k++;
        		if(j==needle.length()){
        			return i; 
        		}
        	}
        }
        return -1;
    }
    
    public static void main(String[] args){
    	System.out.print(strStr("mi", "mi"));
    }
}
