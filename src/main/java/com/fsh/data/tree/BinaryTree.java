package com.fsh.data.tree;

import java.util.Stack;

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
 * 二叉树的访问方法，根据访问root节点的顺序分为以下三种（D:root；L:左子树；R：右子树）：
 * 
 * 1.DLR,先访问root，在访问左子树，最后访问右子树   {@link #DLROrder(TreeNode) }
 * 2.LDR,先访问左子树，再访问root，最后访问右子树   {@link #LDROrder(TreeNode) }
 * 3.LRD,先访问左子树，再访问右子树，最后访问root {@link #LRDOrder(TreeNode) }
 * 
 *      
 *      
 */
public class BinaryTree<T extends Comparable<? super T>> {
	private TreeNode<T> root;
	
	public BinaryTree(TreeNode<T> root){
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
	private void putValue(TreeNode<T> value,TreeNode<T> compare){
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
	
	public void DLROrder(TreeNode<T> node){
		if(node != null){
			System.err.println("node.v="+node.v);
			DLROrder(node.l);
			DLROrder(node.r);
		}
	}
	
	public void LDROrder(TreeNode<T> node){
		if(node != null){
			LDROrder(node.l);
			System.err.println("node.v="+node.v);
			LDROrder(node.r);
		}
	}
	
	public void LRDOrder(TreeNode<T> node){
		if(node != null){
			LRDOrder(node.l);
			LRDOrder(node.r);
			System.err.println("node.v="+node.v);
		}
	}
	
	private int getHeight(TreeNode<T> node){
		if(node == null) return 0;
		int leftHeight = getHeight(node.l);
		int rightHeight = getHeight(node.r);
		return leftHeight<rightHeight?(rightHeight+1):(leftHeight+1);
	}
	/**
	 * 深度优先搜索算法
	 */
	public void depthFirstSearch(TreeNode<T> root){
		if(root == null) return;
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode<T> node = stack.pop();
			System.err.print(node.v +"  ");
			if(node.r != null){
				stack.push(node.r);
			}
			if(node.l != null){
				stack.push(node.l);
			}

			System.err.println();
		}
	}
	
}
