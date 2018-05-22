package com.fsh.data.queue;

import com.fsh.data.IData;

/**
 * 队列方法的定义
 */
public interface Queue<E> extends IData<E> {
	
	/**
	 * 返回头部,不删除
	 * @return
	 */
	E element();
	
	/**
	 * 删除头部，并返回
	 * @return
	 */
	E remove();
	
	/**
	 * 判断数据是否超过容器大小限制，如果不超过，就插入
	 * @param e
	 * @return
	 */
	boolean offer(E e);
}
