package com.fsh.data;

public abstract class AbstractData<E> implements IData<E> {
	
	protected AbstractData(){}
	
	
	
	public boolean isEmpty(){
		return size() == 0;
	} 
	
	/**
	 * 容器数据大小
	 */
	public abstract int size();
}
