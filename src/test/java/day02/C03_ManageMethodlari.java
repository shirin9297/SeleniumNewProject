package day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethodlari {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://amazon.com");
        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanın Konumu = "+driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutları = "+driver.manage().window().getSize());
        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(20,20)); //Sayfanın konumunu istediğimiz şekilde ayarlar
        driver.manage().window().setSize(new Dimension(600,300));// Sayfanın ölçülerini istediğimiz şekilde ayarlar
        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println("Sayfanın Yeni Konumu = "+driver.manage().window().getPosition());
        System.out.println("Sayfanın Yeni boyutları = "+driver.manage().window().getSize());
        //8. Sayfayi kapatin
        Thread.sleep(2000);
        driver.close();
    }
}

