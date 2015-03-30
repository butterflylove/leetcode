package practice;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FibonacciSum implements Callable<Integer>{
	private int count;
	private final int n;
	public FibonacciSum(int n){
		this.n=n;
	}
	private int fib(int n){
		if(n<2) return 1;
		else return fib(n-1)+fib(n-2);
	}
	private int next(){
		return fib(count++);
	}
	public Integer call(){
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=next();
		}
		return sum;
	}
}

public class E05_FibonacciSum {
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> al = new ArrayList<Future<Integer>>();
		for(int i=1;i<=100;i++){
			al.add(exec.submit(new FibonacciSum(i)));
		}
		Thread.yield();
		exec.shutdown();
		for(Future<Integer> f:al){
			try {
				System.out.println(f.get());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
