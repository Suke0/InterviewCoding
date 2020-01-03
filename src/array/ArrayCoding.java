package array;

import java.util.HashMap;

public class ArrayCoding {

	//δ�����������ۼӺ�Ϊ����ֵ���������ϵ������
	//----------------------strat----------------------------
	public static int maxLengthSumK(int[] arr, int k) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		//a[j..i]���ۼӺ�Ϊsum(i)-sum(j-1)
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int len = 0;
		int sum = 0;
		hm.put(0,-1);
		for (int i = 0; i < arr.length; i++) {
			sum +=arr[i];
			if(hm.containsKey(sum - k)) {
				len = Math.max(i - hm.get(sum - k), len);
			}
			//��ŵ�һ���ۼӺ�Ϊsum��i
			if(!hm.containsKey(sum)) {
				hm.put(sum, i);
			}
		}
		return len;
	}
	

	public static void main(String[] args) {
		
	}
	//-------------------------end---------------------------------------
}
