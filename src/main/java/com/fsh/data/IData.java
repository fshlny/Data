package com.fsh.data;
/**
 * 所有数据结构的方法标准
 */
public interface IData<T> {
	/**
	 * 返回容器中有多少条数据
	 * @return
	 */
	int size();
	/**
	 * 向容器中添加数据
	 * @param t
	 */
	boolean add(T t);
	
	/**
	 * 删除容器中的数据T
	 * @param t
	 */
	boolean remove(T t);
	
	/**
	 * 清空容器的数据
	 */
	void clear();
	
	/**
	 * 返回容器的hashCode
	 * @return
	 */
	int hashCode();
	
	/**
	 * 是否是空容器
	 * @return
	 */
	boolean isEmpty();
}
