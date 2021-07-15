import java.util.*;
class ThreeWayQuickSort{
	public static void main(String args[]){
		int arr[]={3,2,1};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static int compare(int num1, int num2) {
    if (num1 > num2)
        return 1;
    else if (num1 < num2)
        return -1;
    else
        return 0;
	}
	// Next, let's add a method called swap() to exchange elements at two indices of the same array:

	public static void swap(int[] array, int position1, int position2) {
	    if (position1 != position2) {
	        int temp = array[position1];
	        array[position1] = array[position2];
	        array[position2] = temp;
	    }
	}
	// To uniquely identify a partition in the array, we'll need its left and right boundary-indices. So, let's go ahead and create a Partition class:

	public static class Partition {
	    private int left;
	    private int right;
	    Partition(int left, int right) {
	    	this.left = left;
	    	this.right = right;
	    }
	    public int getLeft() { return left; }
	    public int getRight() { return right; }
	}
	// Now, we're ready to write our three-way partition() procedure:

	public static Partition partition(int[] input, int begin, int end) {
	    int lt = begin, current = begin, gt = end;
	    int partitioningValue = input[begin];

	    while (current <= gt) {
	        int compareCurrent = compare(input[current], partitioningValue);
	        switch (compareCurrent) {
	            case -1:
	                swap(input, current++, lt++);
	                break;
	            case 0:
	                current++;
	                break;
	            case 1:
	                swap(input, current, gt--);
	                break;
	        }
	    }
	    return new Partition(lt, gt);
	}
	// Finally, let's write a quickSort() method that leverages our 3-way partitioning scheme to sort the left and right partitions recursively:

	public static void quickSort(int[] input, int begin, int end) {
	    if (end <= begin)
	        return;

	    Partition middlePartition = partition(input, begin, end);

	    quickSort(input, begin, middlePartition.getLeft() - 1);
	    quickSort(input, middlePartition.getRight() + 1, end);
	}
}