import java.util.Scanner;

public class UglyCode{
	public static void main(String[] args){
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Number");
		n=sc.nextInt();
		for (int i=0; i<n*n;i++){
			for (int j=0; j<n*n;j++){
				for (int k=0; k<n*n;k++){
					System.out.print("");
				}
			}
		}
		print();
	}
	static void print(){
		String str="Heyy I am Sudhanshu kumar";
		char a[]=str.toCharArray();
		for(char e: a)
			System.out.print(e);
		call();
	}
	static void call(){
		System.out.println("\nI am 2nd year CS undergrad");
	}
}