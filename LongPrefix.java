package practice;

public class LongPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int length=getLong(strs);
        try{
        	for(int i=0;i<length;i++){
        		char temp=strs[0].charAt(i);
            	for(int j=1;j<strs.length;j++){
            		if(temp!=strs[j].charAt(i)){
            			return new String(sb);
            		}
            	}
            	sb.append(temp);
            }
        	return new String(sb);
        }catch(ArrayIndexOutOfBoundsException e){
        	e.printStackTrace();
        	 return new String(sb);
        }
       // return x;
        
    }
    
    public static int getLong(String[] strs){
    	int length=Integer.MAX_VALUE;
    	for(int i=0;i<strs.length;i++){
    		length=strs[i].length()<length?strs[i].length():length;
    	}
    	return length;
    }
}
