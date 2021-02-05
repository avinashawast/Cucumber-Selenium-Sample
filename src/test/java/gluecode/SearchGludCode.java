package gluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class SearchGludCode {

	WebDriver driver = null; 
	String currentPath = System.getProperty("user.dir");


	@SuppressWarnings("deprecation")
	@Given("Browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver",currentPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("User is on google search page")
	public void user_is_on_google_search_page() {
		driver.get("https://google.com");
	}

	@When("User enters a keyword in search box")
	public void user_enters_a_keyword_in_search_box() {
		driver.findElement(By.name("q")).sendKeys("softwaretestfundamentals wordpress com");
	}

	@And("User hits enter button")
	public void user_hits_enter_button() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("User gets the matching result")
	public void user_gets_the_matching_result() {
		driver.getPageSource().contains("Software Test Fundamentals - WordPress.com");

		driver.close();
		driver.quit();
	}

}
