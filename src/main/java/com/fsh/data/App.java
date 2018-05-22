package com.fsh.data;

import com.fsh.data.queue.LinkedQueue;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		LinkedQueue<String> queue = new LinkedQueue<String>(20);
		for(int i=0;i<10;i++){
			queue.add(Thread.currentThread().getName()+i);
		}
		String remove = queue.remove();
		System.out.println(remove);
		
	}
}
