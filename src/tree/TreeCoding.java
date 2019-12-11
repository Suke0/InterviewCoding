package tree;

class Node {
	Node left = null;
	Node right = null;
	int value = 0;
	Node(int value){
		this.value = value;
	}
}

public class TreeCoding {

	//�ֱ��õݹ�ͷǵݹ�ķ�ʽʵ�ֶ�������ǰ������ͺ������
	//----------------------strat----------------------------
	//�ݹ鷽ʽ
	public static void preIterator(Node head) {//������
		if(head == null) {
			return;
		}
		System.out.println(head.value);
		preIterator(head.left);
		preIterator(head.right);
	}
	public static void midIterator(Node head) {//�����
		if(head == null) {
			return;
		}
		midIterator(head.left);
		System.out.println(head.value);
		midIterator(head.right);
			
	}
	public static void endIterator(Node head) {//���Ҹ�
		if(head == null) {
			return;
		}
		endIterator(head.left);
		endIterator(head.right);
		System.out.println(head.value);	
	}
	
	//�ǵݹ鷽ʽ
	public static void opreIterator(Node head) {
		
		
	}
	public static void omidIterator(Node head) {
			
	}
	public static void oendIterator(Node head) {
		
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
		
	}
	//-------------------------end---------------------------------------


}
