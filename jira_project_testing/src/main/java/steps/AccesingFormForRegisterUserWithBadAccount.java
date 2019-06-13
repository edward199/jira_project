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

public class AccesingFormForRegisterUserWithBadAccount extends Steps {

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

	@Then("the bad credentials $alert appears")
	public void resultingPage(String alert) {
		final WebElement element = driver.findElement(By.className(alert));
		assertTrue(element.isDisplayed());
	}
}
