package practice;

public class Palindrome {
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        int base=1;
        while(x/base>=10){
        	base*=10;
        }
        while(x>0){
        	int left=x/base;
        	int right=x%10;
        	if(left!=right) return false;
        	x=x-left*base;
        	base/=100;
        	x/=10;
        }
        return true;
    }
	public static void main(String[] args){
		System.out.print(isPalindrome(123321));
	}
}
