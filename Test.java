class Test{
	public static void main(String[] args){
		int a =191;
		solve(a);
	}

	static void solve(int a){
		int temp =a, ans=0;
		while(temp>0){
			ans+=temp%10;
			temp=temp/10;
		}
		System.out.println(ans);
	}
}