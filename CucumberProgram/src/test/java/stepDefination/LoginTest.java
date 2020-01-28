package stepDefination;

//import java.awt.List;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//import cucumber.api.java.en.Given;

public class LoginTest {
	PageObjects po;

	public static WebDriver driver;

	@Given("^navigate to home page$")
	public void homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		po = new PageObjects(driver);

	}

	@When("^user enters username and password$")
	public void usernameandpass() {

		po.sigin.click();
		po.username.sendKeys("lalitha");
		po.password.sendKeys("password123");
		po.Login.click();

	}

	@Then("^user logged in Successfully$")
	public void userlogin() {
		System.out.println("user login successfully");
	}

	@When("^larry searches below products in the search box:$")
	public void searchproducts(DataTable dt)
	{
		    List<String> product = dt.asList(String.class);
            for (String s : product)  
        {
			driver.findElement(By.xpath("//*[@id=\'myInput\']")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("//a[@href='fetchat.htm']")).click();
		}

	}
	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")	 
	public void entersunamepwd(String uname, String pwd) 
	{
	 po.sigin.click();
	 po.username.sendKeys(uname);
	 po.password.sendKeys(pwd);
	 po.Login.click();
	}

	@Then("^product should be added in the cart if available$")
	public void productadd()
	{

		// throw new cucumber.api.PendingException();
	}
}
