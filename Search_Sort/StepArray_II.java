class StepArray_II{
	public static void main (String [] args) {
		int arr[] = { 2, 4, 5, 7, 7, 6 };
        int key = 6;
        int steps = 2;
        int n = arr.length;
         
        System.out.println("Element " + key +" is present at index "+ search(arr, n, key, steps));
	}

	static int search(int arr[], int n, int key, int steps) {
		/*Math.abs(): gives us the dist,
		on dividing the distance by max steps, gives us the minimum jumps,
		so the element lies in the jumped index or later on*/
		for (int i =0;i<arr.length;i++) {
			if (arr[i]!=key)
				i+= Math.abs(arr[i]-key)/steps;

			if(arr[i]==key)
				return i;
			}
		return -1;
	}
}