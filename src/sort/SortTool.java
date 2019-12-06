package sort;

public class SortTool {
//	  不稳定：
//
//      选择排序（selection sort）— O(n2)
//
//      快速排序（quicksort）— O(nlogn) 平均时间, O(n2) 最坏情况; 对于大的、乱序串列一般认为是最快的已知排序
//
//      堆排序 （heapsort）— O(nlogn)
//
//      希尔排序 （shell sort）— O(nlogn)
//
//      基数排序（radix sort）— O(n·k); 需要 O(n) 额外存储空间 （K为特征个数）
//
// 
//
//      稳定：
//
//      插入排序（insertion sort）— O(n2)
//
//      冒泡排序（bubble sort） — O(n2)
//
//      归并排序 （merge sort）— O(n log n); 需要 O(n) 额外存储空间
//
//      二叉树排序（Binary tree sort） — O(nlogn); 需要 O(n) 额外存储空间
//
//      计数排序  (counting sort) — O(n+k); 需要 O(n+k) 额外存储空间，k为序列中Max-Min+1
//
//      桶排序 （bucket sort）— O(n); 需要 O(k) 额外存储空间
	
//	对于不稳定的排序算法，只要举出一个实例，即可说明它的不稳定性；而对于稳定的排序算法，必须对算法进行分析从而得到稳定的特性。
//	需要注意的是，排序算法是否为稳定的是由具体算法决定的，不稳定的算法在某种条件下可以变为稳定的算法，而稳定的算法在某种条件下也可以变为不稳定的算法。
//	例如，对于如下冒泡排序算法，原本是稳定的排序算法，如果将记录交换的条件改成r[j]>=r[j+1]，则两个相等的记录就会交换位置，从而变成不稳定的算法
//	再如，快速排序原本是不稳定的排序方法，但若待排序记录中只有一组具有相同关键码的记录，而选择的轴值恰好是这组相同关键码中的一个，此时的快速排序就是稳定的。
	
	public static void main(String[] args) {
		int[] a={88,49,38,65,97,76,13,27,49,78,34,12,64,1};
		//selectSort(a);
		//insertSort1(a);
		//shellSort(a);
		//mergeSort1(a);
		//quickSort(a);
		heapSort1(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	//选择排序
	//首先寻找到最小的元素，并将其与第一个元素交换
	//然后寻找到第二小的元素，并将其与第二个元素交换
	//以此类推，直到将整个数组排好序为止
	public static void selectSort(int[] arr) {
	
		for (int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int pos = -1;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					pos=j;
				}
			}
			if(pos >= 0) {
				arr[pos] = arr[i];
				arr[i]=min;
			}
		}
	}
	
	//插入排序：将未排序的元素，插入到已经排好序的数组里，
	//数组后面的元素都向后移动一个位置

	public static void insertSort(int[] arr) {
		int temp=0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					temp = arr[j]; 
					arr[j] = arr[j-1]; 
					arr[j-1] = temp;
				}else {
					break;
				}
			}
			
		}
	}
	
	//希尔排序:分组插入排序
	//最小增量排序，当增量为1时，排序完成
	//取一整数d作为下标间隔，将全部元素分为d个子序列，所有距离为d的元素放在同一个子序列中，
	//在每一个子序列中分别进行直接插入排序，然后缩小间隔d，重复上述操作，直到d=1，将所有元素放在同一个子序列中排序为止。
	public static void shellSort(int[] arr) {
		int d = arr.length/2;
		int temp=0;
		while(d >= 1) {
			for (int ii = 0; ii < d; ii++) {//总共d个子序列
				
				for (int i = d+ii; i < arr.length; i+=d) {
					
					for (int j = i; j >=d; j-=d) {
						
						if(arr[j]<arr[j-d]) {
							temp = arr[j]; arr[j] = arr[j-d]; arr[j-d] = temp;
						}else {
							break;
						}
						
					}
				}
			}
			
			d/=2;
		}
	}
	
	//归并排序：拆分过程--首先将数组先拆分成两个子数组，再将生成的两个子数组，接着拆分成两个子数组，
	//				依次类推，直至子数组中只有一个元素为止；
	//		  合并过程--然后将拆分的子数组合并后，排序，知道所有子数组都合并完，并排好序为止；
	public static void mergeSort(int[] arr) {
		int temp = 0;
		int t=0;
		do {
			t++;
			int d =(int) Math.pow(2, t);
			for (int i = 0; i < arr.length-1; i+=d) {
				for (int j = i+1; j < i+d; j++) {
					for (int j2 = j; j2 >=i+1; j2--) {
						if(j2 >= arr.length) {
							break;
						}
						if(arr[j2]<arr[j2-1]) {
							temp = arr[j2];arr[j2]=arr[j2-1];arr[j2-1]=temp;
						}else {
							break;
						}
					}
				}
			}
		}while(Math.pow(2, t) < arr.length);
		
	}
	
	public static void mergeSort1(int[] arr) {
		mergeHold(arr,0,arr.length-1);
	}
	public static void mergeHold(int[] arr,int left, int right) {
		if(left >= right) {
			return;
		}
		int mid = (left + right)/2;
		
		mergeHold(arr,left,mid);//拆分得到左子数组
		mergeHold(arr,mid+1,right);//拆分得到右子数组
		merge(arr,left,mid,right);//合并左右子数组
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int[] t1=new int[mid-left+1];
		for (int i = 0; i < t1.length; i++) {
			t1[i] = arr[left+i];
		}
		int[] t2=new int[right-mid];
		for (int i = 0; i < t2.length; i++) {
			t2[i] = arr[mid+1+i];
		}
		
		int[] t3=new int[right-left+1];
		if(arr[left] >= arr[right]) {
			for (int i = 0; i < t2.length; i++) {
				t3[i] = t2[i];
			}
			for (int i = 0; i < t1.length; i++) {
				t3[i+t2.length] = t1[i];
			}
		}else if(arr[mid]< arr[mid+1]) {
			for (int i = 0; i < t1.length; i++) {
				t3[i] = t1[i];
			}
			for (int i = 0; i < t2.length; i++) {
				t3[i+t1.length] = t2[i];
			}
		}else {
			int a=0,b=0,c=0;
			while(a<mid-left+1 && b<right-mid) {
				if(t1[a]< t2[b]) {
					t3[c++] = t1[a++];
				}else{
					t3[c++] = t2[b++];
				}
				if(a<mid-left+1 && b==right-mid) {
					t3[c++] = t1[a++];
				}
				if(a==mid-left+1 && b<right-mid) {
					t3[c++] = t2[b++];
				}
			}
		}
		int m=0;
		while(m < right - left + 1) {
			arr[left+m]=t3[m];
			m++;
		}
	}
	
	//快速排序：选择数组里的一个元素，作为基准，将大于基准的元素放在基准右边，小于基准的元素放在基准左边，形成两个子数组；
	//通过递归，选择最佳的切分点，将子数组分成两个更小的子数组，之后分别对子数组重复先前的操作，直到整个数组排好序为止！
	public static void quickSort(int[] arr) {
		quickHold(arr,0,arr.length-1);
	}
	
	private static void quickHold(int[] arr,int left,int right) {
		if(left>=right) {
			return;
		}
		int mid=searchMid(arr,left,right);
		quickHold(arr,left,mid-1);
		quickHold(arr,mid+1,right);
	}

	private static int searchMid(int[] arr, int left, int right) {
		//选择arr[left]作为基准，大于它的放在它的右边，小于它的放在它的左边
//		①先从队尾开始向前扫描且当low < high时,如果a[high] >= tmp,则high–-,
		//但如果a[high] < tmp,则将high的值赋值给low,即arr[low] = a[high],
		//同时要转换数组扫描的方式,即需要从队首开始向队尾进行扫描了 
//		②同理,当从队首开始向队尾进行扫描时,如果a[low] <= tmp,则low++,但如果a[low] > tmp了,
		//则就需要将low位置的值赋值给high位置,即arr[low] = arr[high],同时将数组扫描方式换为由队尾向队首进行扫描. 
//		③不断重复①和②,知道low>=high时(其实是low=high),low或high的位置就是该基准数据在数组中的正确索引位置.
				
		int base = arr[left];
		
		while(left < right) {
			while(left < right && arr[right]>= base) {
				right--;
			}
			arr[left] = arr[right];
			while(left<right && arr[left] < base) {
				left++;
			}
			arr[right]=arr[left];
		}
		arr[left]=base;
		return left;
		
	}
	
	//堆排序
	public static void heapSort(int[] arr) {
		for (int i = (arr.length-1) / 2; i >= 0; i--) {//将整个数组构造成一个大根堆,注意由于是完全二叉树，所以我们从一半向前构造，传入父节点
			heapAdjust(arr,i,arr.length-1);//首先将无序数列转换为大顶堆
		}
		
		//上面大顶堆已经构造完成，现在需要排序，每次将最大的元素放入最后
	    //然后将剩余元素重新构造大顶堆.
		int temp=0;
		for (int i = arr.length-1; i > 0; i--) {
			temp= arr[0];arr[0]=arr[i];arr[i]=temp;
			heapAdjust(arr,0,i-1);
		}
	}
	public static void heapAdjust(int[] arr, int p,int n) {//p是父节点，n为构造大顶堆所用到的最后一个数组元素的下标
		int temp = arr[p];
		for (int i = 2*p; i <= n; i*=2) {//逐渐去找左右孩子结点
			//找到两个孩子结点中最大的
			if(i<n && arr[i]<arr[i+1]) {
				i++;
			}
			
			//父节点和孩子最大的进行判断，调整，变为最大堆
			if(temp >= arr[i]) {
				break;
			}
			
			//将父节点数据变为最大的，将原来的数据还是放在temp中，
			//若是孩子结点的数据更大，我们会将数据上移，为他插入的点提供位置
			arr[p]=arr[i];
			p=i;
		}
		 //当我们在for循环中找到了p子树中，满足条件的点，我们就加入数据到该点p,注意：p点原来数据已经被上移动了
	    //若没有找到，就是相当于对其值不变
	    //插入
		arr[p] = temp;
	}
	
	public static void heapSort1(int[] arr) {
		int N=arr.length;
		int t=0;
		for (int i = 0; i < N-1; i++) {
			buildBigHeap(arr,N-1-i);
			t=arr[0];arr[0]=arr[N-1-i];arr[N-1-i]=t;
		}
	}

	private static void buildBigHeap(int[] arr, int lastIndex) {
		for (int i = (lastIndex-1)/2; i >= 0; i--) {
			int k = i,leftSonIndex = 0;
			while(2*k+1<=lastIndex) {
				leftSonIndex = 2*k+1;
				if(leftSonIndex < lastIndex) {//存在右节点
					if(arr[leftSonIndex] < arr[leftSonIndex+1]) {
						leftSonIndex++;
					}
				}
				if(arr[k] < arr[leftSonIndex]) {
					int t= arr[k];arr[k]=arr[leftSonIndex];arr[leftSonIndex]=t;
					k=leftSonIndex;
				}else {
					break;
				}
			}
			
		}
		
	}
	
}
//堆排序、快速排序、希尔排序、直接选择排序是不稳定的排序算法，而基数排序、冒泡排序、直接插入排序、折半插入排序、归并排序是稳定的排序算法。
//首先，排序算法的稳定性大家应该都知道，通俗地讲就是能保证排序前2个相等的数其在序列的前后位置顺序和排序后它们两个的前后位置顺序相同。在简单形式化一下，如果Ai = Aj, Ai原来在位置前，排序后Ai还是要在Aj位置前。
//其次，说一下稳定性的好处。排序算法如果是稳定的，那么从一个键上排序，然后再从另一个键上排序，第一个键排序的结果可以为第二个键排序所用。基数排序就 是这样，先按低位排序，逐次按高位排序，低位相同的元素其顺序再高位也相同时是不会改变的。
//回到主题，现在分析一下常见的排序算法的稳定性，每个都给出简单的理由。
//(1)冒泡排序
//冒泡排序就是把小的元素往前调或者把大的元素往后调。比较是相邻的两个元素比较，交换也发生在这两个元素之间。所以，如果两个元素相等，我想你是不会再无聊地把他们俩交换一下的；如果两个相等的元素没有相邻，那么即使通过前面的两两交换把两个相邻起来，这时候也不会交换，所以相同元素的前后顺序并没有改 变，所以冒泡排序是一种稳定排序算法。
//(2)选择排序
//选择排序是给每个位置选择当前元素最小的，比如给第一个位置选择最小的，在剩余元素里面给第二个元素选择第二小的，依次类推，直到第n-1个元素，第n个 元素不用选择了，因为只剩下它一个最大的元素了。那么，在一趟选择，如果当前元素比一个元素小，而该小的元素又出现在一个和当前元素相等的元素后面，那么 交换后稳定性就被破坏了。比较拗口，举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法。
//(3)插入排序
//插入排序是在一个已经有序的小序列的基础上，一次插入一个元素。当然，刚开始这个有序的小序列只有1个元素，就是第一个元素。比较是从有序序列的末尾开 始，也就是想要插入的元素和已经有序的最大者开始比起，如果比它大则直接插入在其后面，否则一直往前找直到找到它该插入的位置。如果碰见一个和插入元素相 等的，那么插入元素把想插入的元素放在相等元素的后面。所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳 定的。
//(4)快速排序
//快速排序有两个方向，左边的i下标一直往右走，当a[i] <= a[center_index]，其中center_index是中枢元素的数组下标，一般取为数组第0个元素。而右边的j下标一直往左走，当a[j] > a[center_index]。如果i和j都走不动了，i <= j, 交换a[i]和a[j],重复上面的过程，直到i>j。 交换a[j]和a[center_index]，完成一趟快速排序。在中枢元素和a[j]交换的时候，很有可能把前面的元素的稳定性打乱，比如序列为 5 3 3 4 3 8 9 10 11， 现在中枢元素5和3(第5个元素，下标从1开始计)交换就会把元素3的稳定性打乱，所以快速排序是一个不稳定的排序算法，不稳定发生在中枢元素和a[j] 交换的时刻。
//(5)归并排序
//归并排序是把序列递归地分成短序列，递归出口是短序列只有1个元素(认为直接有序)或者2个序列(1次比较和交换),然后把各个有序的段序列合并成一个有 序的长序列，不断合并直到原序列全部排好序。可以发现，在1个或2个元素时，1个元素不会交换，2个元素如果大小相等也没有人故意交换，这不会破坏稳定 性。那么，在短的有序序列合并的过程中，稳定是否受到破坏？没有，合并过程中我们可以保证如果两个当前元素相等时，我们把处在前面的序列的元素保存在结 果序列的前面，这样就保证了稳定性。所以，归并排序也是稳定的排序算法。
//(6)基数排序
//基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优 先级排序，最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于分别排序，分别收集，所以其是稳定的排序算法。
//(7)希尔排序(shell)
//希尔排序是按照不同步长对元素进行插入排序，当刚开始元素很无序的时候，步长最大，所以插入排序的元素个数很少，速度很快；当元素基本有序了，步长很小， 插入排序对于有序的序列效率很高。所以，希尔排序的时间复杂度会比o(n^2)好一些。由于多次插入排序，我们知道一次插入排序是稳定的，不会改变相同元 素的相对顺序，但在不同的插入排序过程中，相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱，所以shell排序是不稳定的。
//(8)堆排序
//我们知道堆的结构是节点i的孩子为2*i和2*i+1节点，大顶堆要求父节点大于等于其2个子节点，小顶堆要求父节点小于等于其2个子节点。在一个长为n 的序列，堆排序的过程是从第n/2开始和其子节点共3个值选择最大(大顶堆)或者最小(小顶堆),这3个元素之间的选择当然不会破坏稳定性。但当为n /2-1, n/2-2, ...1这些个父节点选择元素时，就会破坏稳定性。有可能第n/2个父节点交换把后面一个元素交换过去了，而第n/2-1个父节点把后面一个相同的元素没 有交换，那么这2个相同的元素之间的稳定性就被破坏了。所以，堆排序不是稳定的排序算法。
//综上，得出结论: 选择排序、快速排序、希尔排序、堆排序不是稳定的排序算法，而冒泡排序、插入排序、归并排序和基数排序是稳定的排序算法。
