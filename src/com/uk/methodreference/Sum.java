package com.uk.methodreference;

public class Sum {

	public static void main(String[] args) {
		Isum iSumOne = (a, b) -> a + b;

		int sumUsingLambda = iSumOne.sum(8, 13);
		System.out.println(sumUsingLambda);

//		Interface requires implementation of its abstract method, already existing addition(int, int) is invoked.
		Isum iSumTwo = Sum::addition;
		int sumUsingMethodReference = iSumTwo.sum(13, 8);
		System.out.println(sumUsingMethodReference);

//		Integer class already has a static method sum(int, int)
		Isum iSumThree = Integer::sum;
		int sumUsingMethodReferenceOfIntegerClass = iSumThree.sum(26, 16);
		System.out.println(sumUsingMethodReferenceOfIntegerClass);
		
//		METHOD REFERENCES are internally converted to lambda expressions
	}

	public static int addition(int x, int y) {
		return x + y;
	}

}
