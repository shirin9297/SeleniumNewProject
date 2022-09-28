package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev {

    public static void main(String[] args) throws InterruptedException {

        /*
        -> "https://the-internet.herokuapp.com/add_remove_elements/" adresine gidiniz.
        -> Add Element butonuna 10 kez basiniz.
        -> 10 kez Add element butonuna basildigini test ediniz.
        -> Delete butonuna gorunmeyene kadar basiniz.
        -> Delete butonunun gorunmedigini test ediniz.
        -> Sayfayi kapatiniz.
        */

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //"https://the-internet.herokuapp.com/add_remove_elements/" adresine gitme :
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna 10 kez basma :
        WebElement addButon = driver.findElement(By.xpath("//*[@onclick='addElement()']"));

        for (int i = 0; i <10 ; i++) {

            addButon.click();
            Thread.sleep(1000);
        }

        //10 kez Add element butonuna basildigini test etme :
        List<WebElement> deleteButon = driver.findElements(By.xpath("//*[text()='Delete']"));
        int arananDeleteButonSayisi = 10;
        int actualDeleteButonSayisi = deleteButon.size();

        if (arananDeleteButonSayisi == actualDeleteButonSayisi) {

            System.out.println("Add Buton'a 10 Kez Basilma Testi : PASSED");
        }
        else {

            System.out.println("Add Andon'a 10 Kez Basilma Testi : FAİLED");
        }

        Thread.sleep(2000);

        //Delete butonuna gorunmeyene kadar basma :
        for (int i = 0; i <10 ; i++) {

            driver.findElement(By.xpath("//*[text()='Delete']")).click();
            Thread.sleep(1000);
        }

        //Delete butonunun gorunmedigini test etme :
        WebElement delete = driver.findElement(By.className("no-js"));
        String arananButon = "Delete";

        if (!delete.getText().contains(arananButon)) {

            System.out.println("Delete Buton Gorunum Testi : PASSED");
        }
        else {

            System.out.println("Delete Buton Gorunum Testi : FAILED");
        }

        Thread.sleep(2000);

        //Sayfayi kapatma :
        driver.close();
    }
}
