package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DisabledFalse {
	@Test(invocationCount=-3)
	public void demo1() {
		System.out.println("demo1");
	}
	@Test
	public void demo5() {
		System.out.println("demo5");
	}
	@Test(enabled=false)
	public void demo3() {
		System.out.println("demo3");
	}
	@Test(invocationCount=1)
	public void demo2() {
		System.out.println("demo2");
	}

}
