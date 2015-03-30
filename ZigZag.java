package practice;

public class ZigZag {
	    public static String convert(String s, int nRows) {
	    	char[] temp=s.toCharArray();
	    	char[] res=new char[temp.length];
	    	int count=0;
	    	if(nRows==1) return s;
	    	for(int i=0;i<nRows;i++){
	    		if(i==0||i==(nRows-1)){
	    			for(int off=i;off<s.length()&&count<s.length();off+=(nRows-1)*2){
	    				res[count++]=temp[off];
	    			}
	    		}
	    		else{
	    			int[] dou=new int[2];
	    			dou[0]=(nRows-1-i)*2;
	    			dou[1]=i*2;
	    			boolean flag=true;
	    			for(int off=i;off<s.length();){
	    				if(flag==true){
	    					res[count++]=temp[off];
	    					off+=dou[0];
	    					flag=!flag;
	    				}else{
	    					res[count++]=temp[off];
	    					off+=dou[1];
	    					flag=!flag;
	    				}
	    			}
	    		}
	    	}
	    	return new String(res);
	    }
	    public static void main(String[] args){
	    	System.out.print(convert("AB", 1));
	    }
}
