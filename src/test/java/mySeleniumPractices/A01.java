package mySeleniumPractices;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //1- https://www.amazon.com url'ine gidin
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        //2- Basligin Amazon kelimesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedKelime = "Amazon";
        if(actualTitle.contains(expectedKelime)){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED");
        }

        //3- Url'in "htpps://www.amazon.com" a esit oldugunu test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "htpps://www.amazon.com";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED");
        }

        //4- sayfayi kapatin
        driver.close();

        driver.manage().window().getPosition();
        driver.manage().window().setPosition( new Point(15,15));

    }
}
