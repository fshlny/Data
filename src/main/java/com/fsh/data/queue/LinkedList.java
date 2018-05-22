package com.fsh.data.queue;

public class LinkedList<E> {
    static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;
        Node(E e,Node<E> p,Node<E> n){
            item = e;
            next = n;
            prev = p;
        }
    }

    private int size;

    private Node<E> first;
    private Node<E> last;

    public LinkedList(){}

    /**
     * 在队列头部添加元素
     * @param e
     */
    private void linkFirst(E e){
        final Node<E> f = first;
        final Node<E> newNode = new Node<E>(e,null,f);//新元素放在First之前
        first = newNode;//将全局First更新为最新的节点数据
        if(f == null){//如果是刚初始化，这First为null,last=First
            last = newNode;
        }else//如果添加之前First不为null，添加之前的First的prev指向新的First
            f.prev = newNode;
        size ++;//元素内容
    }

    /**
     * 在队列尾部添加元素
     * @param e
     */
    private void linkLast(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node(e,l,null);//将新元素和之前的last绑定last.next=newNode
        last = newNode;//最后的元素设置为新添加的元素
        if(l == null){
            first = newNode;//刚初始化后调用，last为null，First也为null，first=last
        }else{//将添加之前的last的next指向新元素
            l.next = newNode;
        }
        size ++;
    }

    /**
     * 删除头元素并返回
     */
    private E unlinkFirst(){//这里就不判断刚初始化容器 情况下调用
        if(first == null) return null;
        final Node<E> f = first;//拿到头元素
        final Node<E> n = first.next;//拿到头元素的下一个元素
        first = n;//将第二个元素设置为头元素
        final E e = f.item;//拿到头元素的内容，用final设置是因为后面置空f.item时，不影响到需要返回的内容
        f.item = null;//置空内容
        f.next = null;//置空next
        if(n == null){//删除到最后一位了
            last = null;
        }else{//置空prev
            n.prev = null;
        }
        size --;
        return e;
    }

    private E unlinkLast(){
        if(last == null) return null;
        final Node<E> l = last;
        final Node<E> p = last.prev;
        final E e = l.item;
        l.item = null;
        l.prev = null;
        last = p;
        if(p == null){
            first = null;
        }else{
            p.next = null;
        }
        size --;
        return e;
    }

    /**
     * 头部添加
     * @param e
     */
    public void addFirst(E e){
        linkFirst(e);
    }

    /**
     * 尾部添加
     * @param e
     */
    public void addLast(E e){
        linkLast(e);
    }

    /**
     *  删除头部元素
     * @return
     */
    public E removeFirst(){
        return unlinkFirst();
    }

    /**
     * 删除尾部元素
     * @return
     */
    public E removeLast(){
        return unlinkLast();
    }

    public int size(){
        return size;
    }

    public Object[] toArray(){
        Object[] array = new Object[size];
        int i=0;
        for(Node<E> x= first;x!=null;x=x.next){
            array[i++] = x.item;
        }
        return array;
    }
}
