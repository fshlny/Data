# 二叉树

### 二叉树定义

```text
二叉树（英语：Binary tree）是每个节点最多只有两个分支（即不存在分支度大于2的节点）的树结构。
通常分支被称作“左子树”或“右子树”。二叉树的分支具有左右次序，不能随意颠倒。
```

### 二叉树结构
```text 
                 G
              /     \
             C       V
           / \      /  \
          A   B    H    I
```

### 二叉树的访问

二叉树的访问方法，根据访问root节点的顺序分为以下三种（D:root；L:左子树；R：右子树）：

```text
 1.DLR,先访问root，在访问左子树，最后访问右子树 
 2.LDR,先访问左子树，再访问root，最后访问右子树  
 3.LRD,先访问左子树，再访问右子树，最后访问root 
```
具体代码实现

```java
/**
 * 深度优先搜索算法
 */
public void depthFirstSearch(){
    if(root == null) return;
    ////这里借用栈先进后出的特点
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

/**
 * 广度优先
 */
public void breathFirstSearch(){
	if(root == null) return;
	//这里借用队列先进先出的特点
	LinkedList<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
    queue.offer(root);
    while (!queue.isEmpty()){
        TreeNode<T> node = queue.poll();
        System.err.println("node.v  ---->  "+node.v);
        if(node.l != null){
            queue.offer(node.l);
        }
        if(node.r != null){
            queue.offer(node.r);
        }
    }
}
```

### 插入数据
```text
1. 若b是空树，则将s所指结点作为根节点插入，否则：
2. 若s->data等于b的根节点的数据域之值，则返回，否则：
3. 若s->data小于b的根节点的数据域之值，则把s所指节点插入到左子树中，否则：
4. 把s所指节点插入到右子树中。（新插入节点总是叶子节点）
```

保存数据实现

```java
public void put(T t){
    TreeNode<T> node = new TreeNode<T>(t);
    if(root == null){
    	root = node;
		return;
	}
	putValue(node,root);
}

private void putValue(TreeNode<T> value,TreeNode<T> compare){
	int result = compare.v.compareTo(value.v);
	if(result == 0){
		return;
	}else if(result > 0){
		if(compare.l == null){
			compare.l = value;
			value.p = compare;
		}else{
			putValue(value, compare.l);
		}
	}else if(result < 0){
		if(compare.r == null){
			compare.r = value;
			value.p = compare;
		}else{
			putValue(value, compare.r);
		}
	}
}
```    

### 删除结点

在二叉查找树删去一个结点，分三种情况讨论：

```text
1. 若*p结点为叶子结点，即PL（左子树）和PR（右子树）均为空树。由于删去叶子结点不破坏整棵树的结构，则只需修改其双亲结点的指针即可。
2. 若*p结点只有左子树PL或右子树PR，此时只要令PL或PR直接成为其双亲结点*f的左子树（当*p是左子树）或右子树（当*p是右子树）即可，
作此修改也不破坏二叉查找树的特性。
3. 若*p结点的左子树和右子树均不空。在删去*p之后，为保持其它元素之间的相对位置不变，可按中序遍历保持有序进行调整，
可以有两种做法：其一是令*p的左子树为*f的左/右（依*p是*f的左子树还是右子树而定）子树，*s为*p左子树的最右下的结点，
而*p的右子树为*s的右子树；其二是令*p的直接前驱（in-order predecessor）或直接后继（in-order successor）替代*p，然
后再从二叉查找树中删去它的直接前驱（或直接后继）。
```

删除节点具体实现

```java
public boolean remove(T t){
    if(t == null) return false;
    TreeNode<T> deleteNode = root;
    boolean isLeft = false;
    while(deleteNode != null){
        int compairResult = t.compareTo(deleteNode.v);
        if(compairResult < 0){
            deleteNode = deleteNode.l;
            isLeft = true;
        }else if(compairResult > 0){
            deleteNode = deleteNode.r;
            isLeft = false;
        }else{
            break;
        }
    }
    if(deleteNode == null){
       return false;
    }
    if(deleteNode.r == null && deleteNode.l == null){
        if(isLeft){
            deleteNode.p.l = null;
        }else
            deleteNode.p.r = null;
	        deleteNode = null;
	        return true;
        }else if(deleteNode.l != null){//左子树不为空
	        deleteNode.v = deleteNode.l.v;
	        deleteNode.l = null;
	        return true;
        }else if(deleteNode.r != null){
        deleteNode.v = deleteNode.r.v;
         deleteNode.r = null;
         return true;
    }
    return false;
}

```

### 参考

[维基百科](https://zh.wikipedia.org/wiki/%E4%BA%8C%E5%85%83%E6%90%9C%E5%B0%8B%E6%A8%B9#%E5%9C%A8%E4%BA%8C%E5%85%83%E6%90%9C%E5%B0%8B%E6%A8%B9%E6%8F%92%E5%85%A5%E7%AF%80%E7%82%B9%E7%9A%84%E7%AE%97%E6%B3%95)

[自己用java实现二叉树的增，删，查](https://blog.csdn.net/guo_xl/article/details/78883071)
    

