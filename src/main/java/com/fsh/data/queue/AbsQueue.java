package com.fsh.data.queue;

import com.fsh.data.AbstractData;

public abstract class AbsQueue<E> extends AbstractData<E> implements Queue<E> {
	protected AbsQueue(){}
	
	
	public boolean add(E e){
		if(offer(e))
			return true;
		else 
			throw new IllegalStateException("队列已经满了");
	}
}
