package node;

public class NodeCoding {
	//�ڵ�������ɾ��������K���ڵ�
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
	
	
	
	//��˫��������ɾ��������K���ڵ�
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



	//ɾ��������м�ڵ��a/b���ڵ�
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
			pre = pre.next;//�м�ڵ�
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		
		return head;
	}
	//-------------------------end---------------------------------------
	
	//��ת�����˫������
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
			pre = cur;
			cur = next;
		}
		return pre;
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
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		//Node cur = node1;
		
		Node cur = reverseList(node1);
		while(cur != null) {
			System.out.println(cur.value);
			cur = cur.next;
		}
		
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