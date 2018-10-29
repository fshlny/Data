package com.fsh.data.tree;

public interface Tree<T extends Comparable<? super T>> {
	/**
	 * 添加
	 * @param t
	 */
	void put(T t);
	/**
	 * 删除
	 * @param t
	 */
	boolean remove(T t);
}
