package stackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ExtendStackAndQueue {
	//��ν��õݹ麯����ջ��������һ��ջ
	//----------------------strat----------------------------
	//���ز�ɾ��ջ��Ԫ��
	public static Integer getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.isEmpty()) {
			return result;
		}else {
			int last =getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	//��תstack
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}else {
			int i = getAndRemoveLastElement(stack);
			reverse(stack);
			stack.push(i);
		}
	}
	
//	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<Integer>();
//		List<Integer> lsit = Arrays.asList(3,1,9,5,4,7,6,8,2,0);
//		stack.addAll(lsit);
//		reverse(stack);
//		for (Integer integer : lsit) {
//			System.err.println(stack.pop());
//		}	
//		
//	}
	//-------------------------end---------------------------------------
	
	
	
	//��һ��ջʵ����һ��ջ������
	//----------------------strat----------------------------
	public static void sortByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		if(stack.isEmpty()) {
			return;
		}
		while(!stack.isEmpty()) {
			int i = stack.pop();
			while(!help.isEmpty() && help.peek() < i) {
				stack.push(help.pop());
			}
			help.push(i);
		}
		while(!help.isEmpty()) {
			stack.push(help.pop());
		}

	}
	
	//-------------------------end---------------------------------------
	
	
	//���ɴ������ֵ����
	//----------------------strat----------------------------
	public static int[] getMaxWindow(int[] arr, int m) {
		if(arr == null || arr.length == 0 || m <= 0 || arr.length < m ) {
			return null;
		}
		//ʹ��һ��˫�˶��������������С�꣬�����У������m��Ԫ��
		LinkedList<Integer> help = new LinkedList<Integer>();
		int[] resArr = new int[arr.length - m + 1];
		for (int i = 0; i < arr.length; i++) {
			while(!help.isEmpty() && arr[help.peekLast()] <= arr[i]) {
				help.pollLast();
			}
			help.addLast(i);
			
			if(help.peekFirst() == i - m) {
				help.pollFirst();
			}
			if(i >= m - 1) {
				resArr[i - m + 1] = arr[help.peekFirst()];
			}
		}
		return resArr;
	}
//	public static void main(String[] args) {
//		int[] arr = new int[] {4,3,5,4,3,3,6,7};
//		int[] tempArr = getMaxWindow(arr, 3);
//		for(int t : tempArr) {
//			System.out.println(t);
//		}
//	}

	//-------------------------end---------------------------------------
	
	
	
	//������Ӿ���Ĵ�С
	//----------------------strat----------------------------
	public static int getMaxMatrix(int[][] arr) {
		if(arr == null || arr.length==0 || arr[0].length == 0) {
			return 0;
		}
		//ͳ����ÿһ����Ϊ��ʱ��ÿһ������������Ϊ0��Ԫ�ظ���
		int m = arr.length;
		int n = arr[0].length;
		//�Ե�һ��Ϊ��ʱ�ĸ߶�
//		int[] height1 =new int [n];
//		for (int j = 0; j < n; j++) {
//			for (int i = 0; i < m; i++) {
//				if(arr[i][j] == 1) {
//					height1[j] += 1;
//				}else {
//					height1[j] = 0;
//					continue;
//				}
//			}
//			
//		}
		//�Եڶ���Ϊ��ʱ�ĸ߶�
//		int[] height2 =new int [n];
//		for (int j = 0; j < n; j++) {
//			for (int i = 2 - 1; i < m; i++) {
//				if(arr[i][j] == 1) {
//					height2[j] += 1;
//				}else {
//					height2[j] = 0;
//					continue;
//				}
//			}
//		}
		
		int[][] heights =new int[m][n];
		for (int ii = 0; ii < m; ii++) {
		a:	for (int j = 0; j < n; j++) {
				for (int i = ii; i < m; i++) {
					if(arr[i][j] == 1) {
						heights[ii][j] += 1;
					}else {
						continue a;
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			int[] temp = heights[i];
			for (int j = 0; j < temp.length; j++) {
				if(temp[j] > 0) {
					//��j-1��ʼ�������ҵ���һ��С��temp[j]��λ��
					int leftBase = j - 1;
					
					while(leftBase>=0 && temp[leftBase] >= temp[j]) {
						leftBase--;
					}
					int leftLen = j - 1 - leftBase;
					
					
					//��j+1��ʼ�������ҵ���һ��С��temp[j]��λ��
					int rightBase = j + 1;
					
					while(rightBase <= temp.length-1  && temp[rightBase] >= temp[j]) {
						rightBase++;
					}
					int rightLen = rightBase - j - 1;
					int area = temp[j] * (leftLen + rightLen + 1);
					if(area > max) {
						max = area;
					}
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(heights[i][j] + " ");
			}
			System.out.println();
		}
		
		return max;
		
		

	}
	public static void main(String[] args) {	
		int[][] arr = new int[4][4];
		arr[0] =new int[] {1,1,1,1};
		arr[1] =new int[] {1,1,1,1};
		arr[2] =new int[] {1,1,1,1};
		arr[3] =new int[] {1,0,1,1};
		System.out.println(getMaxMatrix(arr));
	}
	//-------------------------end---------------------------------------
	
	//���ֵ��ȥ��СֵС�ڵ���num������������
	//----------------------strat----------------------------
	public static int getMaxMinNum(int[] arr, int num) {
		//��arr[i..j]��������ʱ��arr[i..j]�����������������������arr[i]Ϊ��һ��Ԫ�ص��������������������Ϊj-i��
		//��arr[i..j]����������ʱ�����а���arr[i..j]���������������������
		if(arr == null || arr.length == 0 ) {
			return 0;
		}
		//ʹ��˫�˶��������������С��
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		int res = 0;
		//�����������arr[0],arr[1],...,arr[N-1]��Ϊ��һ��Ԫ�ص��������У����������������ж��ٸ����ۼ������������������յĽ����
		while(i < arr.length) {//��һ��Ԫ��Ϊarr[i]
			while(j < arr.length) {//���һ��Ԫ��Ϊarr[j]
				while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				
				while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
					qmin.pollLast();
				}
				qmin.addLast(j);
				
				if(qmax.peekFirst() - qmin.peekFirst() > num) {
					break;
				}
				j++;
			}
			if(qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			if(qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			res += j - i;
			i++;
		}
			
		return res;
	}

	//-------------------------end---------------------------------------
	
}
