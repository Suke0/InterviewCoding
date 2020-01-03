package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class Node {
	Node left = null;
	Node right = null;
	int value = 0;
	Node(int value){
		this.value = value;
	}
}

public class TreeCoding {

	//分别用递归和非递归的方式实现二叉树的前序，中序和后序遍历
	//----------------------strat----------------------------
	//递归方式
	public static void preIterator(Node head) {//根左右
		if(head == null) {
			return;
		}
		System.out.print(head.value+", ");	
		preIterator(head.left);
		preIterator(head.right);
	}
	public static void midIterator(Node head) {//左根右
		if(head == null) {
			return;
		}
		midIterator(head.left);
		System.out.print(head.value+", ");	
		midIterator(head.right);
			
	}
	public static void endIterator(Node head) {//左右根
		if(head == null) {
			return;
		}
		endIterator(head.left);
		endIterator(head.right);
		System.out.print(head.value+", ");	
	}
	
	//非递归方式
	public static void opreIterator(Node head) {//根左右
		if(head !=null) {
			Stack<Node> stack = new Stack<Node>();	
			stack.push(head);
			while(!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value+", ");	
				if(head.right != null) {
					stack.push(head.right);
				}
				if(head.left !=null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	public static void omidIterator(Node head) {//左根右
		if(head != null) {
			Stack<Node> stack = new Stack<Node>();
			while(!stack.isEmpty() || head !=null) {
				if(head != null) {
					stack.push(head);
					head = head.left;
				}else {
					head = stack.pop();
					System.out.print(head.value+", ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}
	public static void oendIterator(Node head) {//左右根
		if(head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while(!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if(head.left != null) {
					s1.push(head.left);
				}
				if(head.right != null) {
					s1.push(head.right);
				}
			}
			while(!s2.isEmpty()) {
				System.out.print(s2.pop().value+", ");
			}
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right =node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		preIterator(node1);
		System.out.println();
		opreIterator(node1);
		
		midIterator(node1);
		System.out.println();
		omidIterator(node1);
		
		endIterator(node1);
		System.out.println();
		oendIterator(node1);
		
	}
	//-------------------------end---------------------------------------
	
	
	//二叉树中累加和为给定值的最长路径的长度
	//----------------------strat----------------------------
	public static int maxLengthSumK(Node head, int k) {
		if(head == null) {
			return 0;
		}
		HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
		sumMap.put(0, 0);
		return preOrder(head,k,0,1,0,sumMap);
	}
	
	public static int preOrder(Node head,int k,int preSum,int level,int maxLen,HashMap<Integer,Integer> sumMap) {
		if(head == null) {
			return maxLen;
		}
		int curSum = preSum + head.value;
		if(!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}
		if(sumMap.containsKey(curSum - k)) {
			maxLen = Math.max(level - sumMap.get(curSum-k),maxLen);
		}
		maxLen = preOrder(head.left,k,curSum,level + 1,maxLen,sumMap);
		maxLen = preOrder(head.right,k,curSum,level + 1,maxLen,sumMap);
		if(sumMap.get(curSum) == level) {
			sumMap.remove(curSum);
		}
		return maxLen;
	}

	//-------------------------end---------------------------------------


}
