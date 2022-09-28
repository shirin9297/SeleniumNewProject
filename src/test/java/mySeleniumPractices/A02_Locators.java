package mySeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class A02_Locators {
    /*
  Main method olusturun ve asagidaki gorevi tamamlayin.
  a. http://a.testaddressbook.com adresine gidiniz.
  b. sign in butonuna basin
  c. email textbox, password textbox, and signin button elementlerini locate ediniz.
  d. kullanici adini ve sifresini asagiya girin ve oturum ac(sign in) buttonunu tiklayin:
     i. Username : testtechproed@gmail.com
     ii. Password : Test1234!
   e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
   f. "Addresses" ve "Sign in" textlerinin goruntulendigini(displayed) dogrulayin(verify).
   g. Sayfada kac tane link oldugunu bulun.
  */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        // b. sign in butonuna basin
        WebElement singInLink = driver.findElement(By.id("sign-in"));
        singInLink.click();
        //  c. email textbox, password textbox, and signin button elementlerini locate ediniz.
        WebElement emailTextbox = driver.findElement(By.id("session_email"));
        WebElement passwordTextbox = driver.findElement(By.id("session_password"));
        WebElement signinButton = driver.findElement(By.name("commit"));

        //  d. kullanici adini ve sifresini asagiya girin ve oturum ac(sign in) buttonunu tiklayin:
        //    i. Username : testtechproed@gmail.com
        //     ii. Password : Test1234!
        Thread.sleep(2000);
        emailTextbox.sendKeys("testtechproed@gmail.com");
        passwordTextbox.sendKeys("Test1234!");
        signinButton.click();
        Thread.sleep(2000);
        //   e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement actualUserElement = driver.findElement(By.className("navbar-text"));
        //Bir WebElementin uzerinde ne yazdigini gormek istiyorsak webElementIsmi.getText() kullaniriz.
        System.out.println(actualUserElement.getText());
        String expectedUserMail = "testtechproed@gmail.com";
        if (expectedUserMail.equals(actualUserElement.getText())) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        //   f. "Addresses" ve "Sign out" textlerinin goruntulendigini(displayed) dogrulayin(verify).
        WebElement addresses = driver.findElement(By.linkText("Addresses"));
        WebElement signOut = driver.findElement(By.linkText("Sign out"));
        if(addresses.isDisplayed()){
            System.out.println("addresses testi PASSED");
        }else{
            System.out.println("addresses testi FAILED");
        }
       if(signOut.isDisplayed()){
           System.out.println("signOut testi PASSED");
       }else{
           System.out.println("signOut test FAILED");
       }

        //   g. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("sayfadaki link sayisi = " + linklerListesi.size());

        //likleri yazdiralim
        //Listemiz webelementlerden olustugu icin, direk yazdirirsak referanlari yazdirir
        // onun yerine for-each loop yapip her bir link webelementinin uzerindeki yaziyi yazdirmaliyiz
        for (WebElement each : linklerListesi
             ) {
            System.out.println(each.getText());
        }

        // h. sayfayi kapat
        driver.close();
    }
}
