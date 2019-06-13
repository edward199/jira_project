package steps;

import static org.testng.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegisterAUser extends Steps {

	private static WebDriver driver = null;

	@Given("I open browser")
	public void openingABrowser() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extentions");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		driver.manage().deleteAllCookies();
	}

	@Given("I access $url")
	public void accessingAUrl(String url) {
		driver.get(url);
	}

	@Given("I enter the login $username and $password for admin and press login button")
	public void enterTheLoginUserAndPass(String username, String password) {
		driver.findElement(By.id(username)).sendKeys("admin");
		driver.findElement(By.id(password)).sendKeys("java123");
		driver.findElement(By.className("btn")).click();
	}

	@Given("I enter the details for the user registered")
	public void enterTheUserDetails() {
		driver.findElement(By.id("userName")).sendKeys("edi");
		driver.findElement(By.id("password")).sendKeys("passwordd");
		driver.findElement(By.id("active")).sendKeys("1");
		driver.findElement(By.id("firstName")).sendKeys("Gabriel");
		driver.findElement(By.id("lastName")).sendKeys("Eduard");
		driver.findElement(By.id("displayName")).sendKeys("edward");
		driver.findElement(By.id("emailAddress")).sendKeys("edward@yahoo.com");
	}

	@When("I press the $button button")
	public void pressRegisterUserButon(String button) {
		driver.findElement(By.id(button)).click();
	}

	@Then("the list $list appears")
	public void showUsersRegistered(String list) {
		final WebElement element = driver.findElement(By.id(list));
		assertTrue(element.isDisplayed());
	}
}
