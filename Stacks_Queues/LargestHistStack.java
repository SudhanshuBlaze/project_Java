import java.util.Stack;

public class LargestHistStack{
	static int getMaxArea(int hist[], int n){
		Stack<Integer> st = new Stack<>();
		int i = 0,area_with_top=0, max_area=0;
		while(i<n){
			// if current element is smaller than top of stack
			while(!st.isEmpty() && hist[st.peek()]>hist[i]){
				int top=hist[st.pop()]; 
				area_with_top= st.isEmpty()? top*i : top*(i-st.peek()-1); 
				max_area= Math.max(max_area, area_with_top);
			}
		st.push(i++);
		}
		//if some elements are there in stack then evaluate them
		while(!st.isEmpty()){
			int top=hist[st.pop()];
			area_with_top= st.isEmpty()? top*i : top*(i-st.peek()-1); //top*length
			max_area= Math.max(max_area, area_with_top);
		}

		return max_area;
	}

		public static void main(String[] args){
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
			// int hist[] = {1,2,3,4,5};
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}
}