package com.fsh.data.tree;

public class TreeNode<T extends Comparable<? super T>> {
		public T v;//值
		public TreeNode<T> p;//父节点
		public TreeNode<T> l;//左结点
		public TreeNode<T> r;//右节点
		public TreeNode(T v){
			this.v = v;
	}
}
