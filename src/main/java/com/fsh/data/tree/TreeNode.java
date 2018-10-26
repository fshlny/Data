package com.fsh.data.tree;

public class TreeNode<T extends Comparable<? super T>> {
		public T v;
		public TreeNode<T> l;
		public TreeNode<T> r;
		public TreeNode(T v){
			this.v = v;
	}
}
