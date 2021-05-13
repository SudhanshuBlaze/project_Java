class flippingBits
{
	public static String toBinary(int x) {
		return Integer.toBinaryString(x);
	}

	public static void main(String[] args)
	{
		System.out.println(toBinary(10));
		System.out.println(toBinary(1));
	}
}