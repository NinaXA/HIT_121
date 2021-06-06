package basic;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first=120,second=140;
		System.out.println("---Before Swap---");
		System.out.println("First number = " + first);
		System.out.println("Second number = " + second);
		int temporary=first;
		first=second;
		second=temporary;
		System.out.println("--After swap--");
		System.out.println("First number = " + first);
		System.out.println("Second number = " + second);

	}

}
