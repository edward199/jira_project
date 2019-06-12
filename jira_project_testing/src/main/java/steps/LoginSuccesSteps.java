package steps;

import static org.testng.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSuccesSteps extends Steps {

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

	@Given("a text field for username with name $nameFieldUser and value $valueFieldUser")
	public void includeUserField(String nameFieldUser, String valueFieldUser) {
		driver.findElement(By.id(nameFieldUser)).sendKeys(valueFieldUser);
	}

	@Given("a text field for password with name $nameFieldPassword and value $valueFieldPassword")
	public void inclusePasswordField(String nameFieldPassword, String valueFieldPassword) {
		driver.findElement(By.id(nameFieldPassword)).sendKeys(valueFieldPassword);
	}

	@When("button login is pressed")
	public void clickLogin() {
		driver.findElement(By.className("btn")).click();
	}

	@Then("displaying the page $page")
	public void resultingPage(String page) {
		final String page1 = driver.getCurrentUrl();
		assertEquals(page1, page);
	}
}
