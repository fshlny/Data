package com.fsh.data.tree;

import java.util.HashMap;

public class BinaryTree<T extends Comparable<? super T>> {
	private TreeNode<T> root;

	
	public BinaryTree(TreeNode root){
		this.root = root;
	}
	
	public BinaryTree(){}
	
	public TreeNode<T> getRoot(){
		return root;
	}
	
	
	public void put(T t){
		TreeNode<T> node = new TreeNode<T>(t);
		if(root == null){
			root = node;
			return;
		}
		putValue(node,root);
	}
	/**
	 * 保存
	 * @param value
	 * @param compare
	 */
	private void putValue(TreeNode value,TreeNode compare){
		int result = compare.v.compareTo(value.v);
		if(result == 0){
			compare.v = value.v;
			return;
		}else if(result > 0){
			if(compare.l == null){
				compare.l = value;
			}else{
				putValue(value, compare.l);
			}
		}else if(result < 0){
			if(compare.r == null){
				compare.r = value;
			}else{
				putValue(value, compare.r);
			}
		}
		
		switch(result){
		case 0: compare.v = value.v; break;
		case 1: 
			if(compare.l == null){
				compare.l = value;
				break;
			}else{
				putValue(value, compare.l);
			}
			break;
		case -1:
		}
	}
	
	public static class TreeNode<T extends Comparable<? super T>>{
		public T v;
		public TreeNode<T> l;
		public TreeNode<T> r;
		public TreeNode(T v){
			this.v = v;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.put(3);
		tree.put(2);
		tree.put(1);
		tree.put(7);
		tree.put(6);
		tree.put(5);
		tree.put(4);
		
		System.err.println("");
	}
}
