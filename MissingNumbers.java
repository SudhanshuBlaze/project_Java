import java.util.*;
class MissingNumbers{

	public static void main(String[] args){
		int arr[] = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
		int barr[]={203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
		func(arr,barr);
	}
	static void func(int arr[],int barr[]){
		int max= Arrays.stream(barr).max().getAsInt();
		int min= Arrays.stream(barr).min().getAsInt();
		int range=max-min+1;
		int keys[]=new int[range];
		Arrays.fill(keys,0);
		int i;
		for (i=0;i<barr.length;i++)
			keys[barr[i]-min]++;

		for(i=0;i<arr.length;i++)
			keys[arr[i]-min]--;

		for(i=0;i<keys.length;i++)
			if(keys[i]!=0)
				System.out.print(i+min+" ");

	}

}