package practice;

import java.util.ArrayList;

public class StringToInteger {
	public static int atoi(String str) {
		if(str.equals("")||str==null) return 0;
		str=str.trim();
		char[] tem=str.toCharArray();
		char flag='+';
		int i=0;
		if(tem[0]=='-'){
			flag='-';
			i++;
		}else if(tem[0]=='+'){
			i++;
		}
		double res=0;
		while(i<tem.length&&tem[i]>='0'&&tem[i]<='9'){
			res=res*10+(tem[i]-'0');
			i++;
		}
		if(tem[0]=='-') res=-res;
		System.out.println(res);
		System.out.println(Integer.MAX_VALUE);
		if(res>Integer.MAX_VALUE) {
			System.out.println("sssssss");
			return Integer.MAX_VALUE;
			
		}
		if(res<Integer.MIN_VALUE) {
			System.out.println("xxxxxx");
			return Integer.MIN_VALUE;
		}
		return (int)res;
	}
	
	
	
	
	public static void main(String[] args){
		System.out.println(atoi("2147483648"));
		
	}
}
