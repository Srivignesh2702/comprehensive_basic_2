import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationSeleniumTasks {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\java_Workspace\\Selenium\\src\\test\\resources\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @Test(priority = 1, enabled = true, timeOut = 10000)
    public void verifyRequestDemoButton() {
        // Navigate to the URL
        driver.get("https://www.automationanywhere.com");

        // Find the "Request Demo" button element
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[contains(text(), 'Request demo')]"));

        // Verify if the button element is present
        if (requestDemoButton != null && requestDemoButton.isDisplayed()) {
            System.out.println("Task 1: Request Demo button is present.");
        } else {
            System.out.println("Task 1: Request Demo button is not present.");
        }
    }

    @Test(priority = 2, enabled = true, timeOut = 10000)
    public void verifyButtonClickability() {
        // Navigate to the URL
        driver.get("https://www.automationanywhere.com");

        // Find the "Request Demo" button element
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[contains(text(), 'Request demo')]"));

        // Verify if the button element is clickable
        if (requestDemoButton != null && requestDemoButton.isDisplayed() && requestDemoButton.isEnabled()) {
            // Click the button to verify if it is clickable
            requestDemoButton.click();
            System.out.println("Task 2: Request Demo button is clickable.");
        } else {
            System.out.println("Task 2: Request Demo button is not clickable.");
        }
    }

    @Test(priority = 3, enabled = true, timeOut = 20000)
    public void verifyLinksNavigation() {
        // Navigate to the URL
        driver.get("https://www.automationanywhere.com");

        // Handle the cookie pop-up
        handleCookiePopup(driver);

        // List of links to verify and click
        String[] links = {"Products", "Solutions", "Resources", "Beyond RPA", "Company"};

        // Loop through each link
        for (String linkText : links) {
            // Find the link element
            try {
                WebElement linkElement = driver.findElement(By.xpath("//a[contains(text(), '" + linkText + "')]"));

                // Verify if the link element is present
                if (linkElement != null && linkElement.isDisplayed()) {
                    System.out.println("Link '" + linkText + "' is present on the page.");

                    // Click the link directly
                    linkElement.click();
                    System.out.println("Clicked on '" + linkText + "'. Current URL: " + driver.getCurrentUrl());

                    // Verify if navigation is correct (you can add additional verification logic here)
                    // For simplicity, let's navigate back to the home page for each iteration
                    driver.navigate().back();
                } else {
                    System.out.println("Link '" + linkText + "' is NOT present on the page.");
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Link '" + linkText + "' is NOT present on the page.");
            }
        }
    }

    // Method to handle the cookie pop-up
    private void handleCookiePopup(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler"))).click();
        System.out.println("Cookie pop-up handled.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
