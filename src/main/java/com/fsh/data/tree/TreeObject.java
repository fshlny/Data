package com.fsh.data.tree;

public class TreeObject implements Comparable<Integer> {
	public Integer value;
	
	
	public TreeObject(Integer value) {
		this.value = value;
	}


	@Override
	public int compareTo(Integer o) {
		if(o== null) return 1;
		return value - o;
	}

}
