package com.fsh.data.queue;
/**
 * 优先级队列
 * @param <E>
 */
public class PriQueue<E> extends AbsQueue<E> {
	//容器默认大小
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	Object[] queue;
	private int size = 0;
	int modifyCount;//队列结构被修改的次数
	
	public PriQueue(){
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public PriQueue(int initCapacity){
		this.queue = new Object[initCapacity];
	}
	

	
	public E element() {
		return null;
	}

	public E remove() {
		return null;
	}

	public boolean offer(E e) {
		return false;
	}

	public boolean remove(E t) {
		return false;
	}

	public void clear() {
		
	}

	@Override
	public int size() {
		return size;
	}

}
