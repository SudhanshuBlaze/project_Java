// implementation of 2Stack with 1 Array
import java.util.*;
public class TwoStack1Array{

	int size;
	int stack[];
	int top1,top2;
	TwoStack1Array(int size){  //parameterized constructor
		this.size=size;
		stack=new int[size];
		top1=-1;
		top2=size;
	}
	void push1(int x){
		if(top1<top2-1){
			top1+=1;
			stack[top1]=x;
		}			
		else
			System.out.println("Stack 1 overflow");
	}
	void push2(int x){
		if(top1<top2-1){
			top2-=1;
			stack[top2]=x;
		}
		else
			System.out.println("Stack 2 overflow");
	}
	int pop1(){
		if(top1==-1){
			System.out.println("Stack 1 Underflow");
			return -999;
		}
		else
			return stack[top1--];
	}
	int pop2(){
		if(top2==size){
			System.out.println("Stack 2 Underflow");
			return -999;
		}
		else
			return stack[top2++];	
	}
	void display1() {
		if(top1==-1)
			System.out.println("Stack 1 Underflow");
		else{
			for(int i=top1;i>=0;i--)
				System.out.print(stack[i]+" ");
		}
	}
	void display2() {
		if(top2==size)
			System.out.println("Stack 2 Underflow");
		else{
			for(int i=top2;i<size;i++)
				System.out.print(stack[i]+" ");
		}
	}

	public static void main(String args[]){
		TwoStack1Array obj = new TwoStack1Array(10);
		obj.push1(6);
		obj.push1(2);
		obj.push2(443);
		System.out.println(obj.pop2());
		obj.display1();
		
	}
}