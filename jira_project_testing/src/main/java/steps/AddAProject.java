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

public class AddAProject extends Steps {

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

	@Given("I enter the details for the project added")
	public void enterTheProjectDetails() {
		driver.findElement(By.id("description")).sendKeys("Internal Project Jira Testing");
		driver.findElement(By.id("leader")).sendKeys("No one");
		driver.findElement(By.id("projectKey")).sendKeys("BNCH");
		driver.findElement(By.id("projectName")).sendKeys("Jira");
		driver.findElement(By.id("projectType")).sendKeys("Testing");
		driver.findElement(By.id("url")).sendKeys("www.jira_project_testing.com");
	}

	@When("I press the $button button")
	public void pressAddAProjectButon(String button) {
		driver.findElement(By.id(button)).click();
	}

	@Then("the list $list appears")
	public void showProjectsAdded(String list) {
		final WebElement element = driver.findElement(By.id(list));
		assertTrue(element.isDisplayed());
	}
}
