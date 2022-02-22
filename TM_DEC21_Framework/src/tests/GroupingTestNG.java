package tests;

import org.testng.annotations.Test;

public class GroupingTestNG {
	
	//Priority and grouping of test cases
	
	@Test(groups = {"sanity", "regression", "smoke"})
	public void TC1() {

		System.out.println("sanity, regression, smoke");
		System.out.println("Method 1 is executed");
	}

	@Test(groups = {"smoke"})
	public void TC2() {
		System.out.println("smoke");
		System.out.println("Method 2 is executed");
	}

	@Test(groups = {"sanity"})
	public void TC3() {
		System.out.println("sanity");
		System.out.println("Method 3 is executed");
	}

	@Test(groups = {"regression"})
	public void TC4() {
		System.out.println("regression");
		System.out.println("Method 4 is executed");
	}

}
