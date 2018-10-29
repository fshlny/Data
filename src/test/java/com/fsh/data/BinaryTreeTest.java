package com.fsh.data;


import com.fsh.data.tree.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
	/**
	 * 插入数据
	 */
	@Test
	public void testPut(){
		BinaryTree<Integer> tree = generatorBinaryTree();
	}

	private BinaryTree<Integer> generatorBinaryTree(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.put(3);
		tree.put(2);
		tree.put(1);
		tree.put(8);
		tree.put(7);
		tree.put(9);
		tree.put(6);
		return tree;
	}

	/**
	 * 二叉树高度
	 */
	@Test
	public void testGetTreeHeight(){
		BinaryTree<Integer> tree = generatorBinaryTree();
		assertEquals(tree.getTreeHeight(), 4);
	}

	/**
	 * 先序、中序、后序遍历
	 */
	@Test
	public void testOrder(){
		BinaryTree<Integer> tree = generatorBinaryTree();
		System.err.println("================先序=================");
		tree.DLROrder(tree.getRoot());
		System.err.println("=================中序================");
		tree.LDROrder(tree.getRoot());
		System.err.println("==================后序===============");
		tree.LRDOrder(tree.getRoot());
	}

	/**
	 * 深度优先
	 */
	@Test
	public void testDepthFirstSearchAlgorithm(){
		BinaryTree<Integer> tree = generatorBinaryTree();
		tree.depthFirstSearch(tree.getRoot());
	}
	
}
