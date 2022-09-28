package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstClass {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("");

        driver.getCurrentUrl();

        driver.manage().window().maximize();

        driver.getTitle();

        driver.getPageSource();

        driver.getWindowHandle();

        driver.navigate();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.close();

        driver.quit();


    }
}
