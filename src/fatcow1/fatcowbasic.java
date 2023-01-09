package fatcow1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fatcowbasic {
	public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver","../fatcow/exe/geckodriver.exe");
    // System.setProperty("webdriver.chrome.driver","../fatcow/exe/chromedriver.exe");
     WebDriver driver=new FirefoxDriver();
	//WebDriver driver=new ChromeDriver();
		driver.get("https://www.fatcow.com/");
		WebDriverWait wait=new WebDriverWait(driver,5);
		
		
		driver.manage().window().maximize();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("WebMail Login")));
		driver.findElement(By.linkText("WebMail Login")).click();
		//driver.findElement(By.xpath("../html/body/div[1]/div[5]/div/ul/li[4]/div/ul[1]/li[3]/a")).click();
		driver.findElement(By.id("okta-signin-username")).sendKeys("jeet.yadav@gmail.com");
		driver.findElement(By.id("okta-signin-password")).sendKeys("124567899");
		driver.findElement(By.id("okta-signin-submit")).click();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("../html/body/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/div/form/div[1]/div[1]/div/div"), null));
	  
		//String actualMsg =driver.findElement(By.xpath("../html/body/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/div/form/div[1]/div[1]/div/div")).getText();
 		String actualMsg = driver.findElement(By.partialLinkText("Unable to")).getText();
 				String errorMsg= "Unable to sign in";

				if(actualMsg.equalsIgnoreCase(errorMsg)) {
				        System.out.println("Test Case Passed");
				    }else{
				        System.out.println("Test Case Failed");
				    }
		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Unable to sign in")));
	//	driver.findElement(By.linkText("Unable to sign in")).getText();
		
	}                      

}
