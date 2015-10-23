package heap;

public class MinHeap {
	private int[] value;
	private int size;

	public MinHeap(int[] data) {
		size = data.length;
		value = data;
		buildHeap();
	}

	public void buildHeap() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			heaplify(i);
		}
	}

	public void heaplify(int i) {
		int l = (i<<1)+1;
		int r = (i<<1)+2;

		int smallest = i;
		if (l < size && value[smallest] > value[l])
			smallest = l;
		if (r < size && value[smallest] > value[r])
			smallest = r;

		if (smallest == i)
			return;
		else
			swap(smallest, i);

		heaplify(smallest);
	}

	public void swap(int i, int j) {
		int temp = value[i];
		value[i] = value[j];
		value[j] = temp;
	}

	public int getRoot() {
		return value[0];
	}

	public void setRoot(int i) {
		value[0] = i;
		heaplify(0);
	}

	public int findKthLargest(int[] nums, int k) {
		if (k > nums.length)
			return -1;
		
		int[] topk = new int[k];
		for(int i=0;i<k;i++)topk[i]=nums[i];
		MinHeap heap=new MinHeap(topk);
		
		for(int i=k;i<nums.length;i++){
			if(heap.getRoot()<nums[i]){
				heap.setRoot(nums[i]);
			}
		}
		
		return topk[topk.length-1];

	}



}
