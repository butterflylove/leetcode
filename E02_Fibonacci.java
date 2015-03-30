package practice;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

class Fibonacci implements Runnable{
	private int count;
	private final int n;
	public Fibonacci(int n){
		this.n = n;
	}
	public Integer next(){
		return fib(count++);
	}
	private int fib(int n){
		if(n<2) return 1;
		else return fib(n-1)+fib(n-2);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Integer[] x = new Integer[n];
		for(int i=0;i<n;i++){
			x[i]=next();
		}
		System.out.println("sequence of "+n+": "+Arrays.toString(x));
	}
	
}

class T implements Serializable{
	int k=10;
	double a=1;
	int b=2;
	transient int c=3;
}

public class E02_Fibonacci {
	public static void main(String[] args)throws Exception{
		FileOutputStream fos = new FileOutputStream("E:\\教学视频\\java\\尚学堂科技_马士兵-JAVA视频教程\\尚学堂科技_马士兵_J2SE_5.0_第08章_IO\\1.txt");
		T t = new T();
		t.k=8;
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("E:\\教学视频\\java\\尚学堂科技_马士兵-JAVA视频教程\\尚学堂科技_马士兵_J2SE_5.0_第08章_IO\\1.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		T txx= (T)ois.readObject();
		System.out.println(txx.a+" "+txx.b+" "+txx.c+" "+txx.k);
	}
}

