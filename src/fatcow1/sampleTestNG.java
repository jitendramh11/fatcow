package fatcow1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class sampleTestNG {
	@Test
	public void test()
	{
		//System.out.println("hi"); o/p in console window only
		//Reporter.log("hi");//o/p in testng report only
		Reporter.log("hi",true); //both console and TestNG report
	}
	
	

}
