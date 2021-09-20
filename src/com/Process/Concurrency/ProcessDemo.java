package com.Process.Concurrency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ProcessDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> command=new ArrayList<>();
		command.add("Notepad.exe");
		Process pr=null;
		ProcessBuilder pb=new ProcessBuilder(command);
		try {
			pr=pb.start();
		long startTime=System.currentTimeMillis();
			//Thread.sleep(1000);
			/*
			 * if(!pr.waitFor(15, TimeUnit.SECONDS)) { throw new
			 * TimeoutException("Thread being blocked so throwing timeout exception"); }
			 */
		int extval=pr.waitFor();
		System.out.println("exit value is"+pr.exitValue());
		if(extval==0)
		{
			long endval=System.currentTimeMillis();
			System.out.println((endval-startTime)/1000);
		}
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * catch (TimeoutException e) { System.out.println("timeout");
			 * e.printStackTrace(); }
			 */
		finally {
			System.out.println("finally block executed");
			pr.destroy();
		}

	}

}
