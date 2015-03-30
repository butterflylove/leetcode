package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SleepingTask2 implements Runnable{

	private int seconds;
	public SleepingTask2(){
		Random rand = new Random();
		seconds=rand.nextInt()%10;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			seconds=(seconds>=0?seconds:-seconds);
			TimeUnit.MILLISECONDS.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.err.println("InterruptedException!");
		}finally{
			System.out.println("sleeping time:"+seconds);
		}
		
	}
	
}

class Name implements Comparable<Name>{
	String firstName;
	String lastName;
	public Name(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String toString(){
		return this.firstName+"-"+this.lastName;
	}
	public boolean equals(Object obj){
		if(obj instanceof Name){
			Name name=(Name)obj;
			return (firstName.equals(name.firstName))&&(lastName.equals(name.lastName));
		}
		return super.equals(obj);
	}
	public int hashCode(){
		return this.firstName.hashCode();
	}
	@Override
	public int compareTo(Name o) {
		// TODO Auto-generated method stub
		int x=this.lastName.compareTo(o.lastName);
		return x!=0?x:this.firstName.compareTo(o.lastName);
		
	}
	
}

class StringAddress{
	private String s;
	public StringAddress(String s) {this.s=s;}
	public String toString(){
		return super.toString()+" "+s;
	} 
}

public class E06_SleepingTask2 {
	public static void main(String[] args){
		int b=0;
		FileInputStream s=null;
		try {
			 s = new FileInputStream("D:\\workstation_of_myeclipse\\TestShopping\\src\\com\\ztl\\model\\UserBeanBO.java");
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.print("文件无法找到");
			System.exit(-1);
		}
		int num=0;
		try {
			while((b=s.read())!=-1){
				System.out.print((char)b);
				num++;
			}
			System.out.println("all====="+num);
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("文件无法读取");
			System.exit(-1);
		}		
	}
}
