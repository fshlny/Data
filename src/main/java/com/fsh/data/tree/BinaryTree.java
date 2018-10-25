package com.fsh.data.tree;

import java.util.HashMap;
/**
 * 二叉树的简单实现
 * 二叉树结构
 * 
 * 
 *                  G
 *                /   \
 *               C     V
 *              / \   / \
 *             A   B H   I
 *      
 */
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
	/**
	 * 获取树的高度
	 * @return
	 */
	public int getTreeHeight(){
		return getHeight(root);
	}
	
	public void DOrder(TreeNode node){
		if(node != null){
			System.err.println("node.v="+node.v);
			DOrder(node.l);
			DOrder(node.r);
		}
	}
	
	public void LOrder(TreeNode node){
		if(node != null){
			DOrder(node.l);
			System.err.println("node.v="+node.v);
			DOrder(node.r);
		}
	}
	
	public void ROrder(TreeNode node){
		if(node != null){
			DOrder(node.l);
			DOrder(node.r);
			System.err.println("node.v="+node.v);
		}
	}
	
	private int getHeight(TreeNode node){
		if(node == null) return 0;
		int leftHeight = getHeight(node.l);
		int rightHeight = getHeight(node.r);
		return leftHeight<rightHeight?(rightHeight+1):(leftHeight+1);
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
		
		System.err.println("TreeHeight = "+tree.getTreeHeight());
		
		System.err.println("================前序=================");
		tree.DOrder(tree.root);
		System.err.println("=================中序================");
		tree.LOrder(tree.root);
		System.err.println("==================后续===============");
		tree.ROrder(tree.root);
	}
}
