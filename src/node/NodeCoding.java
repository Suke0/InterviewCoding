package node;

public class NodeCoding {
	//在单链表中删除倒数第K个节点
	//----------------------strat----------------------------
	public static Node removeLastKthNode(Node head,int lastKth) {
		if(head == null || lastKth < 1 ) {
			return head;
		}
		
		Node cur = head;
		while(cur != null) {
			lastKth-- ;
			cur = cur.next;
		}
		
		if(lastKth == 0) {
			head = head.next;
		}else if(lastKth < 0) {
			cur = head;
			while(++lastKth !=0) {
				cur = cur.next;
			}
			cur.next = cur.next.next ;
		}
		
		return head;
	}

	//-------------------------end---------------------------------------
	
	
	
	//在双向链表中删除倒数第K个节点
	//----------------------strat----------------------------
	public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
		if(head == null || lastKth < 1) {
			return head;
		}
		DoubleNode cur = head;
		while(cur != null) {
			lastKth--;
			cur = cur.next;
		}
		
		if(lastKth == 0) {
			head = head.next;
			head.pre = null;
		}
		
		if(lastKth < 0) {
			cur = head;
			while(++lastKth != 0) {
				cur = cur.next;
			}
			DoubleNode newNode = cur.next.next;
			cur.next = newNode;
			if(newNode != null) {
				newNode.pre = cur;
			}
			
		}
		
		return head;
	}
	//-------------------------end---------------------------------------



	//删除链表的中间节点和a/b处节点
	//----------------------strat----------------------------
	public static Node removeMidNode(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		if(head.next.next == null) {
			return head.next;
		}
		
		Node pre = head;
		Node cur = head.next.next;
		while(cur.next != null && cur.next.next != null) {
			pre = pre.next;//中间节点
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		
		return head;
	}
	//-------------------------end---------------------------------------
	
	//反转单向和双向链表
	//----------------------strat----------------------------
	public static Node reverseList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node pre = null;
		Node next = null;
		Node cur = head;
		while(cur != null) {
			next = cur.next;
			cur.next = pre;
			//cur.last = next;
			pre = cur;
			cur = next;
		}
		return pre;
	}
//	public static void main(String[] args) {
//		Node node1 = new Node(1);
//		Node node2 = new Node(2);
//		Node node3 = new Node(3);
//		Node node4 = new Node(4);
//		Node node5 = new Node(5);
//		Node node6 = new Node(6);
//		Node node7 = new Node(7);
//		Node node8 = new Node(8);
//		
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
//		node7.next = node8;
//		//Node cur = node1;
//		
//		Node cur = reverseList(node1);
//		while(cur != null) {
//			System.out.println(cur.value);
//			cur = cur.next;
//		}
//		
//	}
	//-------------------------end---------------------------------------

	//反转部分单项链表
	//----------------------strat----------------------------
	public static Node reversePartList(Node head,int from, int to) {
		if(head == null || head.next == null || from >= to || from < 1) {
			return head;
		}
		
		int index = 0;
		Node tmp = head;
		Node preFromNode = null;
		Node toNode = null;
		while(tmp != null) {
			index++;
			if(index + 1 == from) {
				preFromNode = tmp;
			}
			if(index == to) {
				toNode = tmp;
			}
			tmp = tmp.next;
		}
		
		if(to > index) {
			return head;
		}
		
	
		Node pre = null;
		Node next = null;
		Node cur = preFromNode == null ? head : preFromNode.next;
		Node fromNode = cur;
		Node lastToNode = toNode.next;
		while(cur != lastToNode) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if(preFromNode != null) {
			preFromNode.next = toNode;
		}else {
			head = toNode;
		}
		fromNode.next = lastToNode;
		return head;
	}
//	public static void main(String[] args) {
//		Node node1 = new Node(1);
//		Node node2 = new Node(2);
//		Node node3 = new Node(3);
//		Node node4 = new Node(4);
//		Node node5 = new Node(5);
//		Node node6 = new Node(6);
//		Node node7 = new Node(7);
//		Node node8 = new Node(8);
//		
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
//		node7.next = node8;
//		
//		
//		Node cur = reversePartList(node1, 1, 8);
//		while(cur != null) {
//			System.out.println(cur.value);
//			cur = cur.next;
//		}
//		
//	}
	//-------------------------end---------------------------------------
	
	
	//环形单链表的约瑟夫问题
	//----------------------strat----------------------------
	public static Node yuesefuProblem(Node head,int m) {
		if(head == null || head.next == head || m < 1) {
			return head;
		}
		Node cur = head.next;
		int tmp = 1;
		while(cur != head) {
			tmp++;
			cur = cur.next;
		}
		
		tmp = getLive(tmp,m);
		cur = head;
		while(--tmp >= 0) {
			head = cur;
			cur = cur.next;
		}
		
		head.next = head;
		
		return head;
	}
	public static int getLive(int i,int m) {
		if(i == 1) {
			return 1;
		}else {
			return (getLive(i-1,m) + m - 1) % i + 1;
		}
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
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node1;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node1;
		
		
		
		Node cur = yuesefuProblem(node1,3);
		System.out.println(cur.value);
		
	}
	//-------------------------end---------------------------------------
	
	
	
}
class Node{
	int value;
	Node next;
	Node(int data){
		this.value = data;
	}
}

class DoubleNode{
	int value;
	DoubleNode pre;
	DoubleNode next;
	DoubleNode(int data){
		this.value =data;
	}
}