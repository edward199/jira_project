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

public class AddAIssue extends Steps {

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

	@Given("I enter the details for the issue added")
	public void enterTheIssueDetails() {
		driver.findElement(By.id("parentId")).sendKeys("");
		driver.findElement(By.id("projectKey")).sendKeys("BNCH");
		driver.findElement(By.id("issueNumber")).sendKeys("34");
		driver.findElement(By.id("projectId")).sendKeys("3");
		driver.findElement(By.id("reporter")).sendKeys("Edi");
		driver.findElement(By.id("creator")).sendKeys("George");
		driver.findElement(By.id("summary")).sendKeys("Testing");
		driver.findElement(By.id("description")).sendKeys("Jira Project Testing");
		driver.findElement(By.id("duedate")).sendKeys("14.06.2019");
		driver.findElement(By.id("timeSpent")).sendKeys("2");
		driver.findElement(By.id("timeEstimate")).sendKeys("200");
	}

	@When("I press the $button button")
	public void pressAddAIssueButon(String button) {
		driver.findElement(By.id(button)).click();
	}

	@Then("the list $list appears")
	public void showIssuesAdded(String list) {
		final WebElement element = driver.findElement(By.id(list));
		assertTrue(element.isDisplayed());
	}
}
