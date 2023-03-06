package Day01_SeleniumGiriş;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_DriverNavigateMethodlari {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");


        //wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");


        //yeniden amazon anasayfaya gidin
        driver.navigate().back();

        //wisequartar anasayfaya dönün
        driver.navigate().forward();

        //navigate().to() ile driver.get() ile ayni islemi yapar.

        driver.navigate().to("https://www.youtube.com");

        driver.navigate().refresh();

    }
}
