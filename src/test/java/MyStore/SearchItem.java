package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.Highlighter;

public class SearchItem {

    public WebDriver driver;

    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohamed\\IdeaProjects\\TesNGCourse\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }
    @Test(priority = 1)
    public void SignIn(){
        WebElement signInButton = driver.findElement(By.xpath("//a[contains(@title, 'Log in to your customer account')]"));
        signInButton.click();
        WebElement EmailAddress = driver.findElement(By.id("email"));
        EmailAddress.sendKeys("TestNG@Framework.com");
        WebElement PassWordField = driver.findElement(By.id("passwd"));
        PassWordField.sendKeys("TestNG1234");
        WebElement signInField = driver.findElement(By.id("SubmitLogin"));
        signInField.click();
        System.out.println("1. Sign In");

    }
    @Test(priority = 2)
    public void SearchTshirt(){
        WebElement SelectCateg = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"));
        Highlighter.highlightElement(driver, SelectCateg);
        SelectCateg.click();

        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("Blue");

        WebElement Search = driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
        Search.click();

        System.out.println("2. Search For T-Shirt");

    }

    @Test(priority = 3)
    public void SignOut(){
        WebElement SignOutButton = driver.findElement(By.xpath("//a[contains(@title, 'Log me out')]"));
        SignOutButton.click();
        System.out.println("3. Sign Out");
    }

    @AfterClass
    public void TearDown(){
        System.out.println("5. Close Chrome & Application");
        driver.quit();
    }


}
