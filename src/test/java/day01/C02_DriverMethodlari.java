package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // Amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        //kaynak kodlarin icinde "Gateway" kelimesinin oldugunu test ediniz
        //System.out.println(driver.getPageSource()); // Sayfadaki kaynak kodlarini verir
        String istenenKelime = "Gateway";
        if(driver.getPageSource().contains(istenenKelime)){
            System.out.println("PageSource testi PASSED");
        } else System.out.println("PageSource testi FAILED");

        driver.close();
       //driver.quit(); // birden fazla sayfa varsa hepsini kapatir

    }
    }



