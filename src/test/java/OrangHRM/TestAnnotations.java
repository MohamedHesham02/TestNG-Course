package OrangHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.Highlighter;

import java.util.concurrent.TimeUnit;


public class TestAnnotations {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohamed\\IdeaProjects\\TesNGCourse\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com");
        System.out.println("1. Open Chrome & Application");
    }
    @Test
    public void SignIn(){
        WebElement textUsername = driver.findElement(By.xpath("//input[contains(@placeholder, 'Username')][contains(@name, 'username')]"));
        Highlighter.highlightElement(driver, textUsername);
        textUsername.sendKeys("Admin");

        WebElement textPassword = driver.findElement(By.xpath("//input[contains(@class, 'oxd-input oxd-input--active')][contains(@name, 'password')]"));
        Highlighter.highlightElement(driver, textPassword);
        textPassword.sendKeys("admin123");

        WebElement buttonLogin = driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
        Highlighter.highlightElement(driver, buttonLogin);
        buttonLogin.click();

        System.out.println("2. Sign In");
    }



    @Test
    public void userSearch ()
    {
        WebElement menuAdmin = driver.findElement(By.xpath("//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')]"));
        Highlighter.highlightElement(driver, menuAdmin);
        menuAdmin.click();

        WebElement textUserName = driver.findElement(By.xpath("//input[contains(@class, 'oxd-input oxd-input--active')]"));
        Highlighter.highlightElement(driver, textUserName);
        textUserName.sendKeys("Admin");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')][contains(@type, 'submit')]"));
        Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("3. Search For User");
    }

    @Test
    public void SignOut(){
        WebElement accList = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
        accList.click();
        WebElement SignoutButton = driver.findElement(By.xpath("//i[contains(@class, 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon')]"));

        SignoutButton.click();

        System.out.println("4. Sign Out");
    }

    @AfterClass
    public void tearDown ()
    {
        System.out.println("5. Close Chrome & Application");
        driver.quit();
    }
}
