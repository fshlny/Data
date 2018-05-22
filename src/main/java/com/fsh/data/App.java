package com.fsh.data;

import com.fsh.data.queue.LinkedList;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
        LinkedList<Integer> t = new LinkedList<Integer>();
        for(int i=0;i<100;i++){
            t.addFirst(i);
        }
        int first1 = t.removeFirst();
        int first2 = t.removeFirst();
        int last1 = t.removeLast();
        int last2 = t.removeLast();
        System.out.println(first1);
        System.out.println(first2);
        System.out.println(last1);
        System.out.println(last2);
        Object[] it = t.toArray();
        for(int i=0;i<it.length;i++){
            System.out.printf(" ||| "+i + " ---> "+it[i]);
        }
	}
}
