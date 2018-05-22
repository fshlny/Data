package com.fsh.data.queue;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于链表的队列
 */
public class LinkedQueue<E> extends AbsQueue<E> {
	/**
	 * 节点数据
	 * 
	 * @param <E>
	 */
	static class Node<E> {
		E item;
		Node<E> next;

		Node(E e) {
			item = e;
		}
	}

	/** 容器容量，如果没有设置就是Integer.MAX_VALUE,否者就是设置值 */
	private int capacity;

	/** 容器中数据数量 */
	private final AtomicInteger count = new AtomicInteger();

	/** 链表的头 */
	private Node<E> head;

	/** 链表的尾 */
	private Node<E> last;

	public LinkedQueue(int initCapacity) {
		if (initCapacity < 0)
			throw new IllegalArgumentException("容器初始化大小必须大于等于0");
		capacity = initCapacity;
		last = head = new Node<E>(null);
	}

	/** 在尾部添加数据 */
	private void enqueue(Node<E> e) {
		last = last.next = e;
	}

	/**
	 * @return
	 */
	private E dequeue() {
		Node<E> h = head;
		Node<E> first = h.next;
		h.next = h;
		head = first;
		E x = first.item;
		first.item = null;
		return x;
	}

	public E element() {
		return null;
	}

	public E remove() {
		final AtomicInteger count = this.count;
		if(count.get() == 0) return null;
		E e = null;
		int c = -1;
		if(count.get() > 0){
			e = dequeue();
			c = count.getAndDecrement();
		}
		return e;
	}

	public boolean offer(E e) {
		if (e == null)
			throw new NullPointerException("e is null");
		final AtomicInteger count = this.count;
		if (count.get() == capacity)
			return false;
		int c = -1;
		Node<E> node = new Node<E>(e);
		if (count.get() < capacity) {
			enqueue(node);
			c = count.getAndIncrement();
		}
		return c >= 0;
	}

	public boolean remove(E e) {
		if (e == null)
			return false;
		for (Node<E> trail = head, p = trail.next; p != null; trail = p, p = p.next) {
			if (e.equals(p.item)) {
				unlinke(p, trail);
				return true;
			}
		}
		return false;
	}

	void unlinke(Node<E> p, Node<E> trail) {
		p.item = null;
		trail.next = p.next;
		if (last == p)
			last = trail;
	}

	public void clear() {

	}

	@Override
	public int size() {
		return count.get();
	}

	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		int size = count.get();
		if (a.length < size)
			a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
		int k = 0;
		for (Node<E> p = head.next; p != null; p = p.next)
			a[k++] = (T) p.item;
		if (a.length > k)
			a[k] = null;
		return a;
	}

	public Object[] toArray() {
		int size = count.get();
		Object[] a = new Object[size];
		int k = 0;
		for (Node<E> p = head.next; p != null; p = p.next)
			a[k++] = p.item;
		return a;
	}
}
