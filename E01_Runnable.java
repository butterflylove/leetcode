package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Printer implements Runnable{
	private static int taskCount;
	private final int ID = taskCount++;
	Printer(){
		System.out.println("Printer started,ID = "+ID);
	}
	public void run(){
		for(int i=0;i<3;i++){
			System.out.println("Stage "+(i+1)+"...ID = "+ID);
			Thread.yield();
		}
		System.out.println("Printer ended,ID = "+ID);
	}
	
}

public class E01_Runnable {
	public static void main(String[] args){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			DataOutputStream dos = new DataOutputStream(bos);
			dos.writeDouble(Math.random());
			dos.writeBoolean(false);
			
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			DataInputStream dis = new DataInputStream(bis);
			System.out.println(dis.available());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			dos.close();
			bis.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
