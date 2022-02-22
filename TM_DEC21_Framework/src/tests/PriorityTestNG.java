package tests;

import org.testng.annotations.Test;

public class PriorityTestNG {
	
	//Priority and grouping of test cases
	/*
	 *1. We have given priority to all the test cases 
	 *2. If I don't give priority to all the test cases - 
	 *3. Can we give any numeric digit - Yes
	 *4. Can we give negative digits - Yes
	 *5. If I don't give any priority then it will trigger based on the method name which is ASCII value of chars
	 */
	
	@Test()
	public void Ta() {

		System.out.println("sanity, regression, smoke");
		System.out.println("Method 1 is executed");
	}

	@Test(priority=1) //This is only for your reference
	public void TD() {
		System.out.println("smoke");
		System.out.println("Method 2 is executed");
	}

	@Test()
	public void Tb() {
		System.out.println("sanity");
		System.out.println("Method 3 is executed");
	}

	@Test()
	public void TE() {
		System.out.println("regression");
		System.out.println("Method 4 is executed");
	}

}
