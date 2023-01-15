// Java program to print all possible sentences from a list of word list
class SentencePrintAll_Recur{

	static void printColumns(String [][]arr,int m, int n,String []res){
	
		res[m]= arr[m][n]; //stores each sentence

		//BASE CASE: print the sentence, when last row is reached(or last word)
		if(m==arr.length-1){
			for(String words: res)
				System.out.print(words+" "); //combines to become one sentence
			System.out.println();
			return;
		}
		for(int i=0;i<arr.length;i++){
			if(arr[m+1][i]!= ""  && m<arr.length)
				printColumns(arr,m+1, i ,res);
			//do nothing if "" (null) occurs
		}
	}

//iterates over first row and sends the each element of first row to printColumns function
	static void firstRow(String [][]arr){
		// length equals to rows
		String res[]=new String[arr.length];
		for(int j=0;j<arr[0].length;j++){
			if(arr[0][j]!="")
				printColumns(arr, 0,j, res );
		}
	}
	public static void main(String[] args){
	String [][]arr = {{"you", "we", ""},
					  {"have", "are", ""},
					  {"sleep", "eat", "drink"}};
	firstRow(arr);
	}
}
