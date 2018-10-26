package com.fsh.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fsh.data.tree.BinaryTree;

public class BinaryTreeTest {
	
	@Test
	public void testPut(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.put(3);
		tree.put(2);
		tree.put(1);
		tree.put(7);
		tree.put(6);
		tree.put(5);
		tree.put(4);
	}
	
	@Test
	public void testGetTreeHeight(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.put(3);
		tree.put(2);
		tree.put(1);
		tree.put(7);
		tree.put(6);
		tree.put(5);
		tree.put(4);
		assertEquals(tree.getTreeHeight(), 5);
	}
	@Test
	public void testOrder(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.put(3);
		tree.put(2);
		tree.put(1);
		tree.put(7);
		tree.put(6);
		tree.put(5);
		tree.put(4);
		System.err.println("================前序=================");
		tree.DLROrder(tree.getRoot());
		System.err.println("=================中序================");
		tree.LDROrder(tree.getRoot());
		System.err.println("==================后续===============");
		tree.LRDOrder(tree.getRoot());
	}
	
}
