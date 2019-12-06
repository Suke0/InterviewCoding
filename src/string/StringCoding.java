package string;

import java.util.HashMap;

//��һ��0-1����ֻ����0��1�Ĵ���������������Խ�����������λ�ã������ٽ����Ĵ�����
//������ ����partition?����ߵ���Щ0�����ұߵ���Щ1�����Բ���

public class StringCoding {
	public static int sort0And1(String str) {
		int ans=0;
		char[] strs=str.toCharArray();
		for (int i = 0,j=strs.length-1; i < j; i++,j--) {
			while(i<j && strs[i]=='0') {
				i++;
			}
			while(i<j && strs[j]=='1') {
				j--;
			}
			if(i<j) {
				char t=strs[i];strs[i]=strs[j];strs[j]=t;
				ans++;
			}
		}
		System.out.println(strs);
		return ans;
	}
	
	//ɾ��һ���ַ������е�a,���Ҹ������е�b��ע���ַ������㹻��
	public static void delA_copyB(String str) {
		int n=0,numb=0;
		char[] strs=str.toCharArray();
		for (int i = 0; i < strs.length; i++) {
			if(strs[i]!='a') {
				strs[n++]=strs[i];
			}
			if(strs[i]=='b') {
				numb++;
			}
		}
		strs[n]=' ';
		int newLen=n+numb;
		strs[newLen]=' ';
		for (int i = newLen-1,j=n-1; j >=0 ; j--) {
			strs[i--]=strs[j];
			if(strs[j]=='b') {
				strs[i--]='b';
			}
		}
		System.err.println(strs);
	}
	
	//��3 һ���ַ���ֻ����*�����֣��������*�Ŷ��ſ�ͷ��
	public static void solve(String str) {
		char[] strs=str.toCharArray();
		int j = strs.length-1;
		for (int i = strs.length-1; i >= 0 ; i--) {
			if(strs[i]!='*') {
				strs[j--] = strs[i];
			}
		}
		while(j>=0) {
			strs[j]='*';
			j--;
		}
	}
	
	
	//�ж������ַ����Ƿ�Ϊ���δ�
	public static boolean solve1(String str1,String str2) {
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		if(str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			if(!hm.containsKey(str1.charAt(i))) {
				hm.put(str1.charAt(i), 1);
			}else {
				hm.put(str1.charAt(i),hm.get(str1.charAt(i))+1);
			}
		}
		for (int i = 0; i < str2.length(); i++) {
			if(!hm.containsKey(str2.charAt(i))) {
				return false;
			}else {
				if(hm.get(str2.charAt(i))-1 < 0) {
					return false;
				}
				hm.put(str2.charAt(i),hm.get(str2.charAt(i))-1);
			}
		}
		return true;
	}
	
	//�ַ����������ִ������
	public static int numSumInString(String str) {
		char[] strs=str.toCharArray();
		int j=0,t=0,sum=0;
		String s="";
		for (int i = 0; i < strs.length; i++) {
			t=0;
			if(strs[i]>='1' && strs[i]<='9') {
				j=0;
				for (int k = i+1; k < strs.length; k++) {
					if(strs[k]<'0' || strs[k]>'9') {
						break;
					}else {
						j++;
					}
				}
				s=str.substring(i, i+j+1);
				
				t=new Integer(s);
				for (int k = i-1; k >= 0; k--) {
					if(strs[k]=='-') {
						t=-t;
					}else {
						break;
					}
				}
				i+=j+1;
			}
			System.out.println(t);
			sum+=t;
		}
		System.out.println(sum);
		return sum;
	}
	
	public static int numSumInString1(String str) {
		char[] strs=str.toCharArray();
		int sum=0,num=0;
		boolean posi=true;
		int cur=0;
		for (int i = 0; i < strs.length; i++) {
			cur=strs[i]-'0';
			if(cur<0 || cur>9) {
				sum+=num;
				num=0;
				if(strs[i]=='-') {
					if(i-1>=0 && strs[i-1]=='-') {
						posi=!posi;
					}else {
						posi=false;
					}
					if(i+1<strs.length && strs[i+1] == '0') {
						posi=true;
					}
				}else {
					posi=true;
				}
			}else {
				num=num*10+(posi?cur:-cur);
			}
		}
		sum+=num;
		System.out.println(sum);
		return sum;
	}
	
	public static void main(String[] args) {
//		0000000000000000000001111111111111111111111
//		11
		//System.out.println(sort0And1("0100111101010100011101001011000101101000111"));
		//delA_copyB("abababaaaaab");
		//System.out.println(solve1("ererqqwaswwqa","qwreearqwqaws"));
		numSumInString1("a11-017Ahhh-----180-----41B-0----240C07--011D66E110");
	}

}
